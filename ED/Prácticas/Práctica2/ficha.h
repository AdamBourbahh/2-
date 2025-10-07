
#ifndef __FICHA__H__
#define __FICHA__H__

/* ***************************************** */

#include <iostream>

/* ***************************************** */

/**
 * @brief Tipo enumerado para representar los distintos
 * estados de las fichas del juego
 * 
 */
enum Ficha {
    /**
     * @brief Representa una casilla/ficha vacía.
     * 
     */
    BLANCO, 
    /**
     * @brief Representa una ficha marcada con círculo.
     * 
     */
    CIRCULO, 
    /**
     * @brief Representa una ficha marcada con cruz.
     * 
     */
    CRUZ
    };

/* ***************************************** */
/**
 * @brief Sobrecarga del operador de salida para que funcione sobre
 * tipo fichas. 
 * @param salida Representa el flujo de salida.
 * @param fic Representa la ficha a mostrar.
 * @return Devuelve el flujo de salida del tipo Ficha. 
 */
std::ostream& operator<<(std::ostream &salida, const Ficha &fic);

/* ***************************************** */

#endif
