
#ifndef __JUGADOR__H__
#define __JUGADOR__H__

/* ***************************************** */

#include <iostream>
#include <string>
#include "ficha.h"
#include "tablero.h"

/* ***************************************** */
/**
 * @brief Clase que representa a un jugador en el juego.
 * 
 */

class Jugador {
  private:
    /**
     * @brief Nombre del jugador
     * 
     */
    std::string nombre; 
    /**    
     * @brief Color de la ficha del jugador
     * 
     */
    Ficha fic;   
    /**
     * @brief Nivel de inteligencia del jugador (0: humano, 1: CPU básica)
     * 
     */           
    int nivel;              

    /**
     * @brief Implementa la estrategia de juego del nivel 0 (humano).
     * 
     * @param tab tablero actual
     * @param fil fila de la jugada
     * @param col columna de la jugada
     */
    void piensa_nivel_0(const Tablero &tab, int &fil, int &col) const;
    /**
     * @brief Implementa la estrategia de juego del nivel 1 (CPU básica).
     * 
     * @param tab tablero actual
     * @param fil fila de la jugada
     * @param col columna de la jugada
     */
    void piensa_nivel_1(const Tablero &tab, int &fil, int &col) const;

  public:
    /**
     * @brief Constructor de la clase Jugador, no puede ser por defecto.
     * 
     * @param n Nombre del jugador
     * @param f tipo de la ficha del jugador
     * @param ni Nivel de inteligencia del jugador (0: humano, 1: CPU básica).
     */
    Jugador(const std::string &n, const Ficha &f, int ni);
    /**
     * @brief Destructor de la clase Jugador.
     * 
     */
    ~Jugador() { };
    /**
     * @brief Obtiene el nombre del jugador.
     * 
     * @return std::string 
     */
    std::string Nombre() const         { return nombre; };

    /**
     * @brief Obtiene el color de la ficha del jugador.
     * 
     * @return Ficha 
     */
    Ficha Color() const                { return fic; };

    /**
     * @brief Dice que jugada va a hacer el jugador, en funcion de su nivel
     * 
     * @param tab El tablero actual del juego
     * @param fil Referencia donde se devuelve la fila de la jugada
     * @param col Referencia donde se devuelve la columna de la jugada
     */
    void PiensaJugada(const Tablero &tab, int &fil, int &col) const;
};

/* ***************************************** */

  /**
   * @brief sobrecarga del operador de salida para que soporte objetos de la clase Jugador.
   * 
   *
   * 
   * @param salida referencia a objeto flujo de salida
   * @param jug objeto jugador a mostrar
   * @return std::ostream& flujo de salida
   */
std::ostream& operator<<(std::ostream &salida, const Jugador &jug);

/* ***************************************** */

#endif
