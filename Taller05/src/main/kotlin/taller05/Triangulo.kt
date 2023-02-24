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

/**
 * Ejercicio 4: La clase Triángulo
Escriba la clase Triángulo tal como se presenta en el diagrama de clases.
 */
class Triangulo(val base: Double, val altura: Double) {
    fun area(): Double = base*altura/2
}

