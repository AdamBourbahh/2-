
/* ***************************************** */
/**
 * @file juego.h, clase dedicada al control del juego.
 * @brief Clase que representa el 3 en raya.
 * @author Adam Bourbahh Romero
 * @date Septiembre 2025
 * 
 */
#ifndef __JUEGO__H__
#define __JUEGO__H__

/* ***************************************** */

#include "tablero.h"
#include "jugador.h"


class Juego3Raya {
  private:
  /**
   * @brief Representa los objetos jugadores que van a formar parte del juego.
   * 
   */
    Jugador jug1, jug2;
    /**
     * @brief Representa el objeto tablero sobre el que va a desarrollarse el juego.
     * 
     */
    Tablero tab;
    /**
     * @brief Entero que controla a quien le toca jugar.
     * 
     */
    int turno;

  public:
    /**
     * @brief Constructor de la clase juego
     * 
     * @param t El tablero sobre el que se va a jugar
     * @param j1 El primer jugador
     * @param j2 El segundo jugador
     */
    Juego3Raya(const Tablero &t, const Jugador &j1, const Jugador &j2);
    /**
     * @brief DEstructor de la clase juego
     * 
     */
    ~Juego3Raya()  { };   

    /**
     * @brief Inicializa el juego, poniendo todo lo necesario para comenzar a jugar.
     * 
     */
    void NuevoJuego();
    /**
     * @brief Realiza el turno del jugador al que le toca jugar.
     * 
     */
    void JugarTurno();      

    /**
     * @brief Funcion que permite obtener el tablero del juego.
     *  
     *  @return referencia constante al tablero del juego.
     */
    const Tablero &ElTablero() const { return tab; };

    /**
     * @brief funcion que permite acceder a los jugadores del juego.
     * 
     * @param n El n�mero del jugador (0 o 1)
     * @return referencia constante al jugador.
     */
    const Jugador &ElJugador(int n) const;

    /**
     * @brief funcion que permite saber si el juego ha terminado
     * 
     * @return true si el juego ha terminado, false en caso contrario.
     */
    bool HemosAcabado() const;

    /**
     * @brief funcion que nos dice a quien le toca jugar.
     * 
     * @return atributo turno que indica a quien le toca jugar.
     */
    int AQuienLeToca() const  { return turno; };

    /**
     * @brief funcion que nos dice quien ha ganado el juego.
     * 
     * @return  entero que cuando es 0 indica que ha ganado el jugador 1,
     *          cuando es 1 indica que ha ganado el jugador 2,  
     *        y -1 indica que no ha ganado nadie (empate o juego no acabado). 
     */
    int QuienGana() const;
};

/* ***************************************** */

#endif
