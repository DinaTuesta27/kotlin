/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Empleados
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package empleado.mundo

/**
 * Clase para representar una fecha.
 */
class Fecha(
    /**
     * Día de la fecha.
     */
    private val dia: Int,
    /**
     * Mes de la fecha.
     */
    private val mes: Int,
    /**
     * Año de la fecha.
     */
    private val año: Int
) {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------


    /**
     * Retorna el día de la fecha.
     * @return Día de la fecha.
     */
    fun darDia(): Int {
        return this.dia // Hay que cambiar esto. Retornar el dia
    }

    /**
     * Retorna el mes de la fecha.
     * @return Mes de la fecha.
     */
    fun darMes(): Int {
        return this.mes // Hay que cambiar esto. Retornar el mes
    }

    /**
     * Retorna el año de la fecha.
     * @return Año de la fecha.
     */
    fun darAño(): Int {
        return año   // Hay que cambiar esto. Retornar el año.
    }

    /**
     * Retorna la diferencia en meses que hay entre dos fechas.
     * @param pFecha Fecha contra la que se está comparando. pFecha != null.
     * @return Diferencia en meses de la fechas.
     */
    fun darDiferenciaEnMeses(pFecha: Fecha): Int {
        var diferencia = 0

        diferencia = (this.año - pFecha.año) * 12 + (this.mes - pFecha.mes)
        if (this.dia < pFecha.dia)
            diferencia--

        return diferencia
    }

    /**
     * Retorna una cadena que representa la fecha.
     * @return Cadena con la información de la fecha, sigue el formato dia-mes-año.
     */
    override fun toString(): String {
        return "$dia/$mes/$año"
    }

}
