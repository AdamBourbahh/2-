# @file GameState.rb
# @brief Estructura inmutable con el estado observable del juego.
# @author Alumno
# @date 2025-10-13
# Documentación en formato YARD.

module Irrgarten
  # Contiene la información pública del estado del juego para mostrar o depurar.
  class GameState
    # Construye un estado de juego.
    # @param lab [Object] representación del laberinto actual.
    # @param pl [Array<String>] nombres o identificadores de jugadores.
    # @param m [Array<String>] nombres o identificadores de monstruos.
    # @param curr [Integer] índice del jugador actual.
    # @param winn [Object, nil] ganador si lo hay, o nil.
    # @param lg [String] mensaje de log.
    def initialize(lab , pl, m, curr, winn, lg)
      @labyrinth = lab
      @players = pl
      @monsters = m
      @currentPlayer = curr
      @winner = winn
      @log = lg
    end

    # @return [Object] laberinto asociado.
    def labyrinth
      return @labyrinth
    end

    # @return [Array<String>] jugadores.
    def players
      return @players
    end

    # @return [Array<String>] monstruos.
    def monsters
      return @monsters
    end

    # @return [Integer] índice del jugador actual.
    def currentPlayer
      return @currentPlayer
    end

    # @return [Object, nil] ganador si lo hay.
    def winner
      return @winner
    end

    # @return [String] último mensaje de registro.
    def log
      return @log
    end

  end
end