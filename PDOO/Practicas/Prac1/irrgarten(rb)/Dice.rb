# @file Dice.rb
# @brief Utilidad de generación aleatoria para el juego (tiradas de dados y recompensas).
# @author Alumno
# @date 2025-10-13
# Documentación en formato YARD.

module Irrgarten
  # Clase de apoyo para generar valores aleatorios del juego.
  class Dice
    # Número máximo de usos de armas/escudos considerados para descarte.
    @@MAX_USES = 5
    # Valor máximo (no incluido) para inteligencia inicial.
    @@MAX_INTELLIGENCE = 10.0
    # Valor máximo (no incluido) para fuerza inicial.
    @@MAX_STRENGTH = 10.0
    # Probabilidad de resurrección de un jugador.
    @@RESURRECT_PROB = 0.3
    # Máximo (no incluido) de armas como recompensa.
    @@WEAPONS_REWARD = 2
    # Máximo (no incluido) de escudos como recompensa.
    @@SHIELDS_REWARD = 3
    # Máximo (no incluido) de salud como recompensa.
    @@HEALTH_REWARD = 5
    # Máximo (no incluido) de potencia de arma.
    @@MAX_ATTACK = 3
    # Máximo (no incluido) de protección de escudo.
    @@MAX_SHIELD = 2
    # Generador aleatorio.
    @@GENERATOR = Random.new

    # Obtiene una posición aleatoria en [0, max).
    # @param max [Integer] límite superior exclusivo.
    # @return [Integer]
    def randomPos(max)
      return @@GENERATOR.rand(max)
    end

    # Elige al jugador inicial en [0, nplayers).
    # @param nplayers [Integer]
    # @return [Integer]
    def whoStarts(nplayers)
      return @@GENERATOR.rand(nplayers)
    end

    # Inteligencia aleatoria en [0, MAX_INTELLIGENCE).
    # @return [Float]
    def randomIntelligence
      return @@GENERATOR.rand(@@MAX_INTELLIGENCE)
    end

    # Fuerza aleatoria en [0, MAX_STRENGTH).
    # @return [Float]
    def randomStrength
      return @@GENERATOR.rand(@@MAX_STRENGTH)
    end

    # Decide si un jugador resucita.
    # @return [Boolean]
    def resurrectPlayer
      return @@GENERATOR.rand() <= @@RESURRECT_PROB
    end

    # Número de armas como recompensa en [0, @@WEAPONS_REWARD).
    # @return [Integer]
    def weaponsReward
      return @@GENERATOR.rand(@@WEAPONS_REWARD)
    end

    # Número de escudos como recompensa en [0, @@SHIELDS_REWARD).
    # @return [Integer]
    def shieldsReward
      return @@GENERATOR.rand(@@SHIELDS_REWARD)
    end

    # Salud como recompensa en [0, @@HEALTH_REWARD).
    # @return [Integer]
    def healthReward
      return @@GENERATOR.rand(@@HEALTH_REWARD)
    end

    # Potencia de arma en [0, @@MAX_ATTACK).
    # @return [Integer]
    def weaponPower
      return @@GENERATOR.rand(@@MAX_ATTACK)
    end

    # Protección de escudo en [0, @@MAX_SHIELD).
    # @return [Integer]
    def shieldPower
      return @@GENERATOR.rand(@@MAX_SHIELD)
    end

    # Usos restantes en [0, @@MAX_USES).
    # @return [Integer]
    def usesLeft
      return @@GENERATOR.rand(@@MAX_USES)
    end

    # Intensidad de una acción en [0, competence).
    # @param competence [Integer] tope exclusivo.
    # @return [Integer]
    def intensity(competence)
      return @@GENERATOR.rand(competence)
    end

    # Determina si se descarta un elemento según sus usos restantes.
    # @param usesLeft [Integer] usos restantes del elemento.
    # @return [Boolean] true si se descarta.
    def discardElement(usesLeft)
      prob_descarte = 1.0 - (usesLeft.to_f / @@MAX_USES)
      return @@GENERATOR.rand() <= prob_descarte
    end
  end
end