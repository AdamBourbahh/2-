# @file Weapon.rb
# @brief Clase que modela un arma del juego.
# @author Alumno
# @date 2025-10-13
# Documentación en formato YARD.

require_relative 'Dice'

module Irrgarten
  # Representa un arma con una cierta potencia y un número limitado de usos.
  class Weapon
    # Construye un arma.
    # @param p [Integer] potencia del arma.
    # @param e [Integer] usos disponibles inicialmente.
    def initialize(p, e)
      @power = p
      @uses = e
    end

    # Realiza un ataque si quedan usos.
    # @return [Integer] la potencia del arma si hay usos; 0 en caso contrario.
    def attack
      salida = 0
      if (@uses > 0)
        salida = @power
        @uses -= 1
      end
      return salida
    end

    # Representación en cadena del arma.
    # @return [String] con el formato "W[power,uses]".
    def to_s
      return "W[" + @power.to_s + "," + @uses.to_s + "]"
    end

    # Decide si el arma debe descartarse en función de los usos restantes.
    # @return [Boolean] true si se descarta, false en caso contrario.
    def discard
      dado = Dice.new
      return dado.discardElement(@uses)
    end
  end
end
