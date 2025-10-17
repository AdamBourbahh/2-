# @file Shield.rb
# @brief Clase que modela un escudo del juego.
# @author Alumno
# @date 2025-10-13
# Documentación en formato YARD.

require_relative 'Dice'

module Irrgarten
  # Representa un escudo con cierta protección y usos limitados.
  class Shield
    # Construye un escudo.
    # @param p [Integer] capacidad de protección del escudo.
    # @param e [Integer] usos disponibles inicialmente.
    def initialize(p, e)
      @protection = p
      @uses = e
    end

    # Proporciona protección si quedan usos.
    # @return [Integer] la protección del escudo si hay usos; 0 en caso contrario.
    def protect
      salida = 0
      if (@uses > 0)
        salida = @protection
        @uses -= 1
      end
      return salida
    end

    # Representación en cadena del escudo.
    # @return [String] con el formato "S[protection,uses]".
    def to_s
      return "S[" + @protection.to_s + "," + @uses.to_s + "]"
    end

    # Decide si el escudo debe descartarse según los usos restantes.
    # @return [Boolean] true si se descarta, false en otro caso.
    def discard
      dado = Dice.new
      return dado.discardElement(@uses)
    end

  end
end