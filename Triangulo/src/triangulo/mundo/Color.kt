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
 * Clase que representa un color.
 */
class Color(
    /**
     * Componente rojo del RGB (Red).
     */
    private var rojo: Int,
    /**
     * Componente verde del RGB (Green).
     */
    private var verde: Int,
    /**
     * Componente azul del RBG (Blue).
     */
    private var azul: Int
) {

    /**
     * Devuelve la valor del componente rojo (R) en el color.
     * @return Valor del componente rojo.
     */
    fun darRojo(): Int {
        return rojo
    }

    /**
     * Devuelve la valor del componente verde (G) en el color.
     * @return Valor del componente verde.
     */
    fun darVerde(): Int {
        return verde
    }

    /**
     * Devuelve la valor del componente azul (B) en el color.
     * @return Valor del componente azul.
     */
    fun darAzul(): Int {
        return azul
    }

    /**
     * Cambia el valor del componente rojo (R) en el color.
     * @param pRojo Nuevo valor rojo del RGB. pRojo >= 0.
     */
    fun cambiarRojo(pRojo: Int) {
        rojo = pRojo
    }

    /**
     * Cambia el valor del componente verde (G) en el color.
     * @param pVerde Nuevo valor verde del RGB. pVerde >= 0.
     */
    fun cambiarVerde(pVerde: Int) {
        verde = pVerde
    }

    /**
     * Cambia el valor del componente azul (B) en el color.
     * @param pAzul Nuevo valor azul del RGB. pAzul >= 0.
     */
    fun cambiarAzul(pAzul: Int) {
        azul = pAzul
    }

}
