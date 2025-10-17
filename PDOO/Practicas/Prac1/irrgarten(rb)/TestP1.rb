# @file TestP1.rb
# @brief Banco de pruebas (humo) para las clases principales del proyecto.
# Ejecuta con: ruby TestP1.rb
# Autoría y fecha: Alumno, 2025-10-13.

# Requerir archivos del proyecto
require_relative 'Weapon'
require_relative 'Shield'
require_relative 'GameState'
require_relative 'Directions'
require_relative 'GameCharacter'
require_relative 'Orientations'

# Usar el espacio de nombres del módulo Irrgarten
include Irrgarten

puts '--- Irrgarten: Prueba básica (humo) ---'

# Crear y mostrar un par de objetos
w1 = Weapon.new(3, 2)
s1 = Shield.new(2, 1)

puts "Arma (to_s): #{w1}  -> Esperado: W[3,2]"
puts "Escudo (to_s): #{s1} -> Esperado: S[2,1]"

# Mostrar algunas constantes (direcciones, orientaciones y tipo de personaje)
puts "Dirección LEFT: #{Directions::LEFT}"
puts "Orientación VERTICAL: #{Orientations::VERTICAL}"
puts "GameCharacter PLAYER: #{GameCharacter::PLAYER}"

# Construir un estado de juego y mostrar sus campos
labyrinth = 'Laberinto-Demo-1'
players = ['Alicia', 'Beto']
monsters = ['Orco']
current = 0
winner = 0
log = 'Juego inicializado.'

state = GameState.new(labyrinth, players, monsters, current, winner, log)

puts '--- GameState (getters) ---'
puts "Labyrinth: #{state.labyrinth} (== #{labyrinth})"
puts "Players:   #{state.players} (== #{players})"
puts "Monsters:  #{state.monsters} (== #{monsters})"
puts "Current:   #{state.currentPlayer} (== #{current})"
puts "Winner:    #{state.winner.inspect} (== #{winner.inspect})"
puts "Log:       #{state.log} (== #{log})"

# ---------------- Pruebas específicas: Weapon ----------------
w2 = Weapon.new(4, 2)
puts '\n--- Pruebas de Weapon ---'
puts "Inicial: #{w2} (esperado W[4,2])"
resultado1 = w2.attack
resultado2 = w2.attack
resultado3 = w2.attack # sin usos ya
puts "Ataque 1: #{resultado1} (== 4)"
puts "Ataque 2: #{resultado2} (== 4)"
puts "Ataque 3 (sin usos): #{resultado3} (== 0)"
puts "Estado tras ataques: #{w2} (esperado W[4,0])"
# descarte probabilístico; se muestra el resultado (true/false)
descarta_w2 = w2.discard
puts "Descartar arma (probabilístico, depende de usos=0): #{descarta_w2}"

# ---------------- Pruebas específicas: Shield ----------------
s2 = Shield.new(3, 3)
puts '\n--- Pruebas de Shield ---'
puts "Inicial: #{s2} (esperado S[3,3])"
prot1 = s2.protect
prot2 = s2.protect
prot3 = s2.protect
prot4 = s2.protect # sin usos
puts "Protect 1: #{prot1} (== 3)"
puts "Protect 2: #{prot2} (== 3)"
puts "Protect 3: #{prot3} (== 3)"
puts "Protect 4 (sin usos): #{prot4} (== 0)"
puts "Estado tras proteger: #{s2} (esperado S[3,0])"
descarta_s2 = s2.discard
puts "Descartar escudo (probabilístico, depende de usos=0): #{descarta_s2}"

# ---------------- Pruebas específicas: Dice ----------------
require_relative 'Dice'
d = Dice.new
puts '\n--- Pruebas de Dice ---'
# Rangos y ejemplos (no deterministas)
puts "whoStarts(5) -> #{d.whoStarts(5)} (rango 0..4)"
puts "randomPos(10) -> #{d.randomPos(10)} (rango 0..9)"
ri = d.randomIntelligence
rs = d.randomStrength
puts "randomIntelligence -> #{ri} (rango [0.0, 10.0))"
puts "randomStrength -> #{rs} (rango [0.0, 10.0))"
puts "weaponsReward -> #{d.weaponsReward} (rango 0..#{1})" # MAX=2 -> 0..1
puts "shieldsReward -> #{d.shieldsReward} (rango 0..#{2})"  # MAX=3 -> 0..2
puts "healthReward -> #{d.healthReward} (rango 0..#{4})"   # MAX=5 -> 0..4
puts "weaponPower -> #{d.weaponPower} (rango 0..#{2})"     # MAX=3 -> 0..2
puts "shieldPower -> #{d.shieldPower} (rango 0..#{1})"     # MAX=2 -> 0..1
puts "usesLeft -> #{d.usesLeft} (rango 0..#{4})"           # MAX_USES=5 -> 0..4
puts "intensity(7) -> #{d.intensity(7)} (rango 0..6)"
# Probar discardElement con distintos usos
[0, 1, 3, 5].each do |u|
  intentos = 10
  descartes = (1..intentos).count { d.discardElement(u) }
  puts "discardElement(uses=#{u}) -> true en #{descartes}/#{intentos} intentos (prob. aprox. #{((1.0 - u.to_f/5)*100).round}%)"
end

puts '\n--- Fin de la prueba ---'