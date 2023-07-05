# Basic utilities
## Rangos
| Rango        | Color       | Comandos                                                                                                                    | Requisitos para obtenerlo                |
|--------------|-------------|-----------------------------------------------------------------------------------------------------------------------------|------------------------------------------|
| Novice       | Yellow      | `stp {get}` `utils {trade} {list} - {obj}` `location {add} - {view}` `quest`                                                | Join the server.                         |
| Beginner     | Light green | `stp {update} {rock}`                                                                                                       | Reach location x:0, y:0.                 |
| Intermediate | Green       | `stp {update} {gold}`                                                                                                       | Kill the Dragon                          |
| Advanced     | Blue        | `stp {update} {iron}`                                                                                                       | Kill the Warden                          |
| Expert       | Cyan        | `stp {update} {drop} {0}` `stp {update} {diamond}` `utils {join} {armor} {piece}` `utils join tool {tool}` `location {rtp}` | Kill all mobs in the game.               |
| Master       | Orange      | `stp {update} {drop} {1}` `location {tp} {name}`                                                                            | Complete all achievements.               |
| Legend       | Red         | `stp {update} {drop} {2}`                                                                                                   | Kill all special monsters.               |
| Mythical     | Purple      | `stp {update} {drop} {3}`                                                                                                   | Complete all missions.                   |
| God          | Gold        | `stp {update} {drop} {4}`                                                                                                   | Complete special armor to level VII.     |
| Admin        | Black       | `all`                                                                                                                       | Create server.                           |
## Comandos
### utils {commands}
* [x] utils reload                        (Recarga la config)
* [ ] utils join   armor      {piece}     (junta ciertas armaduras)
* [ ] utils join   tool       {tool}      (junta ciertas armaduras)
* [ ] utils trade  list                   (lista de intercambios disponibles)
  * obsidian	  {obs}
  * elderchest	{elc}
  * shulkerbox	{skb}
  * .
* [ ] utils trade  {material}             (intercambia materiales)
  * {obs} = 1	iron block
  * {elc} = 8 obsidian + 16 elder perls
  * {skb} = 1	ender chest
  * .
### location {commands}
* [ ] location add        {name}
* [ ] location view
* [ ] location delete     {name}
* [ ] location sethome            (Una)
* [ ] location deletehome
* [ ] location tp         {name}  (Se desbloquea con rango Expert, 3 por día, 30seg de delay)
* [ ] location rtp                (uno por día)
* [ ] .
### starterpack ó stp {commands}
* [ ] stp get                         (1 por día, ver recompensas)
* [ ] stp update {category}           (Cuando alcanza cierto rango)
  * {rock}
  * {gold}
  * {iron}
  * {diamond}
  * {netherite}
* [ ] stp update {drop}     {amount}  (Sube el nivel del drop {IV -> V})
  * {0} (Protección IV)               (Se activan los drops)
  * {1} (Protección V)
  * {2} (Protección VI)
  * {3} (Protección VII)
  * {4} (Protección VIII)
### quest {commands}
* [ ] quest view        (Ver las misiones)
* [ ] quest view  {id}  (Ver detalle de una misión)
* [ ] quest claim {id}  (Cobrar misión)
## Recompensas
### Iniciales
* [ ] Armadura de cuero (protección V, de color {por spawn}) y herramientas de madera (eficiencia VI) (Irrompible, maldición de desaparición)
* [ ] Armadura de cuero (protección IV, de color {por spawn}) y herramientas de roca (eficiencia V) (Irrompible, maldición de desaparición)
* [ ] Armadura y herramientas de oro (protección III, eficiencia IV) (Irrompible, maldición de desaparición)
* [ ] Armadura y herramientas de hierro (protección II, eficiencia II) (Irrompible, maldición de desaparición)
* [ ] Armadura y herramientas de diamante (protección I, eficiencia I) (Irrompible, maldición de desaparición)
* [ ] Armadura y herramientas de netherite (maldición de desaparición)
### Logros
#### Todos los efectos
* [ ] Visión nocturna infinita
#### Altura máxima (1 vez)
* [ ] .
#### Arqueología (revisión)
* [ ] .
#### Atrapar un gast (revisión)
* [ ] Resistencia al fuego infinita
#### Beacon de de 4 (revisión [diamante])
* [ ] .
#### Completar todos los logros del end
* [ ] .
#### Completar todos los logros del nether
* [ ] .
#### Completar todos los logros del overworld
* [ ] .
### Por matar monstruos
Se desbloquean por rango y el drop es aleatorio.
#### Warden
* [ ] Peto
#### Ender dragon
* [ ] Casco
#### Wither
* [ ] Pantalón
#### Elder guardian
* [ ] Botas
#### Giant
* [ ] .
### Todos los mobs pacíficos
* [ ] Espada golpeó VI
### Todos los mobs agresivos
* [ ] Espada artrópodos VI
### Todos los mobs
* [ ] Espada filo VI
### .
* [ ] Hacha filo VI, eficiencia VI
##3 .
* [ ] Pico eficiencia VI, toque de seda
### .
* [ ] Pico eficiencia VI, fortuna IV
### .
* [ ] Pala eficiencia VI, fortuna IV
### .
* [ ] Asada eficiencia VI
### .
* [ ] Elytra
### .
* [ ] Arco infinidad
### .
* [ ] .
## Restricciones
### Acciones
* [ ] Portal al nether	(Se necesita un ítem en el inventario[Ciudadela])
* [ ] Portal al end	(Se necesita un ítem en el inventario[Ciudadela])
* [ ] .
### Crafteos
* [ ] Herramientas
* [ ] Armaduras
* [ ] .
## Nuevos logros
* [ ] Racista (Matar a Kevin)
* [ ] Xenofobia (Matar al trans [Randal])
* [ ] Sinofobia (Matar al chino)
* [ ] Patriarcado (Golpear a una mujer [Se configura desde archivos el id de la mujer])
* [ ] Contra el sistema (Matar un admin)
* [ ] Ingeniero (Crear una granja)
* [ ] Terminator ()
* [ ] .
## GIT comandos
* git commit (usar vs code)
* git fetch (usar vs code)
* git checkout (usar vs code)
* git merge {branch} (usualmente yo los hago)
## Plugins interesantes
* Aurelium Skills
* easywhitelist
* action announcer
* Trade
* Chat reaction
* ChestSort
* Announcer Plus (Mini message)
* GRIM Anticheat
## objetos chetos admin
### Elytra
* give @p elytra 1 {display:{Name:'{"text":"WINGS OF FREEDOM","color":"gold","bold":true}',Lore:['{"text":"SE OPTIENEN AL COMPLETAR TODOS LOS LOGROS DEL THE_END","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:protection",lvl:10s},{id:"minecraft:fire_protection",lvl:10s},{id:"minecraft:blast_protection",lvl:10s},{id:"minecraft:projectile_protection",lvl:10s},{id:"minecraft:thorns",lvl:10s}]}
### Casco
* give @p netherite_helmet 1 {display:{Name:'{"text":"DRAGON SLAYER","color":"gold","bold":true}',Lore:['{"text":"SE OPTIENEN AL ASESINAR EL ELDER DRAGON","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:protection",lvl:10s},{id:"minecraft:fire_protection",lvl:10s},{id:"minecraft:blast_protection",lvl:10s},{id:"minecraft:projectile_protection",lvl:10s},{id:"minecraft:respiration",lvl:10s},{id:"minecraft:aqua_affinity",lvl:10s},{id:"minecraft:thorns",lvl:10s}]}
### Pantalones
* give @p netherite_leggings 1 {display:{Name:'{"text":"AFECTADO","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL APLICAR SOBRE SI MISMO TODOS LOS EFECTOS DE MINECRAFT","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:protection",lvl:10s},{id:"minecraft:fire_protection",lvl:10s},{id:"minecraft:blast_protection",lvl:10s},{id:"minecraft:projectile_protection",lvl:10s},{id:"minecraft:thorns",lvl:10s}]}
### Zapatos
* give @p netherite_boots 1 {display:{Name:'{"text":"FIRULAIS","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL CAPTURAR UN GHAST Y LLEVARLO AL SPAWN DEL OVERWORLD","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:protection",lvl:10s},{id:"minecraft:fire_protection",lvl:10s},{id:"minecraft:feather_falling",lvl:10s},{id:"minecraft:blast_protection",lvl:10s},{id:"minecraft:projectile_protection",lvl:10s},{id:"minecraft:thorns",lvl:10s},{id:"minecraft:depth_strider",lvl:10s},{id:"minecraft:soul_speed",lvl:10s}]}
### Espada
* give @p netherite_sword 1 {display:{Name:'{"text":"DEATH END","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL ASESINAR AL MENOS UNO DE CADA CRIATURA EXISTENTE","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:sharpness",lvl:10s},{id:"minecraft:smite",lvl:10s},{id:"minecraft:bane_of_arthropods",lvl:10s},{id:"minecraft:fire_aspect",lvl:10s},{id:"minecraft:looting",lvl:10s}]}
### Picos
* give @p netherite_pickaxe 1 {display:{Name:'{"text":"TOPO","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL HABER PICADO MIL BLOQUES DE ANCIENT DEBRIS","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:efficiency",lvl:10s},{id:"minecraft:fortune",lvl:10s}]}
* give @p netherite_pickaxe 1 {display:{Name:'{"text":"TOPO","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL HABER PICADO MIL BLOQUES DE ANCIENT DEBRIS","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:efficiency",lvl:10s},{id:"minecraft:silk_touch",lvl:1s}]}
### Hacha
* give @p netherite_axe 1 {display:{Name:'{"text":"TERMITA","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL TALAR MIL BLOQUES DE MADERA","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:efficiency",lvl:10s},{id:"minecraft:fortune",lvl:10s}]}
### Pala
* give @p netherite_shovel 1 {display:{Name:'{"text":"ALBAÑIL","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL ESCAVAR MIL BLOQUES DE ARENA DE ALMAS","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:efficiency",lvl:10s},{id:"minecraft:silk_touch",lvl:1s}]}
### Arco
* give @p bow 1 {display:{Name:'{"text":"HIDE TENTATION","color":"gold","bold":true}',Lore:['{"text":"SE OBTIENE AL ENCONTRAR UNA MANSIÓN DEL BOSQUE","color":"dark_purple","bold":true}']},HideFlags:4,Unbreakable:1b,Enchantments:[{id:"minecraft:power",lvl:10s},{id:"minecraft:punch",lvl:10s},{id:"minecraft:flame",lvl:10s},{id:"minecraft:infinity",lvl:1s}]}
## Minecraft comandos
### Corazones en el tab
* /scoreboard objectives setdisplay list health
* /scoreboard objectives setdisplay list health
### Rellenar suelo
* /fill ~ 62 ~ ~ 10 ~ minecraft:air
## Info
* Beacon: 64 64 36
* .
