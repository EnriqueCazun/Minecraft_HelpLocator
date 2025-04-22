package com.helplocator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HelpLocator extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("ayuda").setExecutor(this);
        getLogger().info("HelpLocator activado! Configuración cargada.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equalsIgnoreCase("ayuda")) return false;

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cEste comando solo puede ser usado por jugadores.");
            return true;
        }

        Player player = (Player) sender;
        Location loc = player.getLocation();

        String message = getConfig().getString("message-format")
                .replace("{player}", player.getName())
                .replace("{x}", String.valueOf((int) loc.getX()))
                .replace("{y}", String.valueOf((int) loc.getY()))
                .replace("{z}", String.valueOf((int) loc.getZ()))
                .replace("{world}", loc.getWorld().getName());

        int range = getConfig().getInt("broadcast-range");
        if (range <= 0) {
            Bukkit.broadcastMessage(message);
        } else {
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.getWorld().equals(loc.getWorld()) && 
                    online.getLocation().distance(loc) <= range) {
                    online.sendMessage(message);
                }
            }
        }

        return true;
    }

    @Override
    public void onDisable() {
        getLogger().info("HelpLocator desactivado.");
    }
}