# HelpLocator - Plugin para Minecraft

Sistema de alertas de ayuda con ubicación para servidores Minecraft.

---

## Características
- **Comando `/ayuda`** que muestra coordenadas exactas.
- **Configuración personalizable** (formato de mensaje, alcance).
- **Difusión por radio** (global o por distancia).

---

## Instalación
1. Descarga `HelpLocator-1.0.jar` desde [Releases](https://github.com/EnriqueCazun/Minecraft_HelpLocator/releases/tag/1.0).
2. Colócalo en la carpeta `plugins` de tu servidor.
3. Reinicia el servidor.

---

## Uso
### Comandos
- `/ayuda` → Envía tu ubicación a otros jugadores.

### Variables disponibles:
- `{player}` → Nombre del jugador
- `{x}`, `{y}`, `{z}` → Coordenadas
- `{world}` → Mundo actual

---

## Contribuciones
Los reportes de errores y sugerencias son bienvenidos. Abre un issue para discutir cambios.

---

## Configuración
Edita `plugins/HelpLocator/config.yml`:

```yaml
# Formato del mensaje (usa códigos de color §)
message-format: "§6§l[ALERTA] §e{player} §7necesita ayuda en §a[{x}, {y}, {z}] §7(Mundo: §b{world}§7)"

# Radio de difusión en bloques (0 = todos los jugadores)
broadcast-range: 0

# Opciones adicionales
show-particles: true
sound-effect: "ENTITY_PLAYER_LEVELUP"
