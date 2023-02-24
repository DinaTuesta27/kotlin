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
 * Ejercicio 3: La clase Rectángulo
 * Escriba la clase Rectángulo tal como se presenta en el diagrama de clases
 */
class Rectangulo(val base: Double, val altura: Double) {
    fun area(): Double = base*altura
    fun diagonal(): Double = sqrt(base.pow(2)+altura.pow(2))
    fun perimetro():Double = 2*(altura+base)
}

