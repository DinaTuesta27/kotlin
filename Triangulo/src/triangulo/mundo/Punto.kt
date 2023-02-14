/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Triangulo
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package triangulo.mundo

/**
 * Clase que representa un punto del triángulo.
 */
class Punto(
    /**
     * Coordenada X del punto.
     */
    private var x: Double,
    /**
     * Coordenada Y del punto.
     */
    private var y: Double
) {
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna la coordenada X del punto.
     * @return Coordenada X del punto.
     */
    fun darX(): Double {
        return x
    }

    /**
     * Retorna la coordenada Y del punto.
     * @return Coordenada Y del punto.
     */
    fun darY(): Double {
        return y
    }

    /**
     * Cambia la coordenada X del punto.
     * @param pX Coordenada X del punto. pX >= 0.
     */
    fun cambiarX(pX: Double) {
        x = pX
    }

    /**
     * Cambia la coordenada Y del punto.
     * @param pY Coordenada Y del punto. pY >= 0.
     */
    fun cambiarY(pY: Double) {
        y = pY
    }

}
