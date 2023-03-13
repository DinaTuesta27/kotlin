/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralpacientes.mundo

// -----------------------------------------------------------------
// Constantes
// -----------------------------------------------------------------

/**
 * Constante para representar a un Hombre
 */
const val HOMBRE = 1

/**
 * Constante para representar a una mujer
 */
const val MUJER = 2

/**
 * Esta clase representa un paciente del hospital <br>
 */
class Paciente(
    val codigo: Int,        // El código del paciente
    val nombre: String,     // El nombre del paciente
    val clinica: String,    // La clínica a la que asiste el paciente
    val sexo: Int,          // El sexo del paciente
    var informacionMedica: String // La información médica del paciente
) {
    /**
     * Retorna una cadena con la información del paciente
     */
    override fun toString(): String {
        return "[ $codigo ]: $nombre"
    }
}