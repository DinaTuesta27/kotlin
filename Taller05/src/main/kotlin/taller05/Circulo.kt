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

import kotlin.math.PI
import kotlin.math.pow

/**
 * Ejercicio 1: Escriba la clase Círculo tal como se presenta en el diagrama de clases.
 * Clase para manejar un círculo
 */
class Circulo( private val radio: Double) {
    /**
     * Determina el área del circulo = PI por radio al cuadrado
     */
    fun area(): Double = PI * radio.pow(2)


    /**
     * Determinar la longitud de la circunferencia = 2 PI * radio
     */
    fun longitudCircunferencia(): Double = 2* PI* radio
}

