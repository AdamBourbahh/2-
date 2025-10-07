
#ifndef __TABLERO__H__
#define __TABLERO__H__

/* ***************************************** */

#include <iostream>
#include "ficha.h"

/* ***************************************** */
/**
 * @brief Clase que representa el tablero de juego.
 * 
 */
class Tablero {

  private:
  /**
   * @brief Matriz que representa el tablero de juego.
   * 
   */
    Ficha tab[3][3];
    /**
     * @brief  Entero que representa el numero de fichas que hay en el tablero.
     *
     * 
     */
    int numfichas;        

    /**
     * @brief Copia el contenido del tablero orig en el tablero actual.
     * 
     * @param orig 
     */
    void copia_tablero(const Tablero &orig);

    /**
     * @brief Función que sirve para comprobar si hay 3 en raya de un color determinado.
     * 
     * @param fic 
     * @return bool que indica si hay 3 en raya del color fic
     */
    bool hay3raya(const Ficha &fic) const;

  public:
   /**
    * @brief Constructor por defecto.
    * 
    */
    Tablero();                                  
    /**
     * @brief Destructor de la clase Tablero.
     * 
     */
    ~Tablero() { };                             
    /**
     * @brief Constructor de copia.
     * 
     * @param orig El tablero que se va a copiar
     */
    Tablero(const Tablero &orig);               
    /**
     * @brief Sobrecarga del operador de asignación.
     * 
     * @param orig El tablero que se va a copiar
     * @return Tablero& Referencia al tablero actual
     */
    Tablero& operator=(const Tablero &orig);    

    /**
     * @brief Pone en blanco todas las casillas del tablero. 
     * 
     */
    void PonerEnBlanco();    

    /**
     * @brief Pone una ficha de color fic en la fila f y la columna c.
     * 
     * @param f representa la fila
     * @param c representa la columna
     * @param fic representa la ficha a poner
     * @return bool Devuelve true si la operaci�n ha tenido exito y false en caso contrario (en caso de intentarlo
     * casillas ya usadas).
     */
    bool PonFicha(int f, int c, const Ficha &fic);

    /**
     * @brief Función que nos dice que ficha hay en la fila f-columna c.
     * 
     * @param f representa la fila
     * @param c representa la columna
     * @return Ficha Devuelve la ficha que hay en esa casilla (BLANCO si no hay ficha).
     */
    Ficha QueFichaHay(int f, int c) const;

    /**
     * @brief Función que comprueba si hay 3 en raya de algún color.
     * 
     * @return Ficha Devuelve CIRCULO si hay 3 en raya de círculos, 
     *         CRUZ si hay 3 en raya de cruces 
     *         y BLANCO si no hay 3 en raya.
     */
    Ficha Busca3Raya() const;

    /**
     * @brief Función que devuelve el número de fichas que hay puestas en el tablero.
     * 
     * @return int número de fichas que hay en el tablero.
     */
    int CuantasFichas() const { return numfichas; };

};
/**
 * @brief Sobrecarga del operador de salida para mostrar el tablero.
 * 
 * @param salida flujo de salida
 * @param tab tablero a mostrar
 * @return std::ostream& flujo de salida que muestra el tablero.
 */
std::ostream& operator<<(std::ostream &salida, const Tablero &tab);

/* ***************************************** */

#endif
