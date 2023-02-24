/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * <p>
 * Estructura de Datos - Taller 06
 * Ejercicio: El Estudiante
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller06

/**
 * Curso del estudiante
 */
class Curso(
    var codigo: String,         // Código del curso.
    var nombre: String,         // Nombre del curso.
    var carrera: String,        // carrera a la que pertenece el curso
    var dePostgrado: Boolean,   // true si es un curso de postgrado y false si no
    var creditos: Int           // Cantidad de créditos del curso
) {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private var nota: Double = 0.0  // Nota del estudiante en el curso

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Asigna a la nota del curso, la nueva nota que se pasa como parámetro.
     * El cambio de nota solo se debe hacer si la nueva nota está entre 1 y 100
     */
    fun asignarNota(nuevaNota: Double) {
        //if(nuevaNota in 1.0...100.0)
        if(nuevaNota>=1.0 && nuevaNota<=100.0)
            nota=nuevaNota
    }

    /**
     * Obtiene la nota del estudiante en el curso
     */
    fun darNota() = nota

    /**
     * Indica si el curso ya ha sido calificado (La nota no es cero)
     * Retorna true si el curso ya tiene nota, false de lo contrario
     */
    fun estaCalificado(): Boolean {
        //Una forma más fácil de un if
        return nota in 1.0..100.0
    }

    /**
     * Indica si el estudiante aprobó el curso. Tenga en cuenta que si
     * el curso es de postgrado, se aprueba el cursos si la nota es
     * superior o igual a 70.0. Si el curso no es postgrado, el curso
     * se aprueba si la nota es superior o igual a 60.0. En cualquier
     * otro caso se reprueba el curso.
     */
    fun aproboCurso(): Boolean {
        return when{
            dePostgrado->return nota>=70.0
            else->nota>=60.0
        }
        }


    // Para permitir la impresión del curso
    override fun toString(): String {
        return "Curso(codigo='$codigo', nombre='$nombre', carrera='$carrera', dePostgrado=$dePostgrado, creditos=$creditos, nota=$nota)"
    }


}