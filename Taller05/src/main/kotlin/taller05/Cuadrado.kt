/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Geometría
 * Autor: Universidad EAN - 07 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller05

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Ejercicio 2: La clase Cuadrado
 * Escriba la clase Cuadrado tal como se presenta en el diagrama de clases
 */
class Cuadrado(private val lado: Double) {
    fun area(): Double =  lado*lado
    fun diagonal(): Double = sqrt(lado.pow(2)+lado.pow(2))
    fun perimetro(): Double = 4*lado
}

