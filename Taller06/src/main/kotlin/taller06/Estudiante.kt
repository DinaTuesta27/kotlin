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

class Estudiante(
    val codigo: Int = 1001001001,       // Código del estudiante.
    val nombre: String = "Juliana",     // Nombre del estudiante.
    val apellido: String = "Ramírez"    // Apellido del estudiante.
) {
    // -----------------------------------------------------------------
    // Atributos Adicionales
    // -----------------------------------------------------------------
    var cursos: List<Curso> = emptyList()

    // -----------------------------------------------------------------
    // Métodos Contadores
    // -----------------------------------------------------------------

    /**
     * Determine cuántos cursos tienen un número de créditos par
     */
    fun cursosCodigoPar(): Int {
        var contador=0
        //Recorrer la lista de cursos
        for (curso in this.cursos){
            if(curso.creditos %2==0){
                contador ++
            }
        }
        //Al final, retornar el contador
        return contador

        /* segunda manera
        var cont=0
        for(i in 0<= until <cursos.size){
            val curso:Curso=cursos[i]
            if(curso.creditos%2==0){
                cont++
                }
        }
        tercera manera
        cursos.forEach {
        val curso:Curso=it
        if(curso.creditos%2==0){
                cont++
                }
        }
        * */
    }

    /**
     * Determinar y retornar el número de cursos de pregrado que están
     * calificados y cuya carrera sea Sistemas o Ciencia
     */
    fun ejercicio02(): Int {
        var contador=0
        //Recorrer la lista de cursos
        for (curso in this.cursos){
            if(curso.dePostgrado==false && curso.estaCalificado()==true && curso.carrera=="Sistemas" || curso.carrera=="Ciencia"){
                contador ++
            }
        }
        return contador
    }

    /**
     * Determinar y retornar la cantidad de cursos del estudiante que
     * ** pertenecen a la carrera** que se recibe como parámetro y tienen
     * un número de créditos entre 2 y 4.
     */
    fun ejercicio03(carrera: String): Int {
        var contador=0
        for (curso in cursos){
            if (curso.carrera==carrera && curso.creditos>=2 && curso.creditos<=4) {
                contador++
            }

        }
        return contador

    }

    /**
     * Determinar y retornar cuántos cursos que están calificados
     * fueron aprobados por el estudiante
     */
    fun ejercicio04(): Int {
        var contador=0
        //Recorrer la lista de cursos
        for (curso in this.cursos){
            if(curso.aproboCurso()==true && curso.estaCalificado()==true){
                contador ++
            }
        }
        //Al final, retornar el contador
        return contador
    }

    /**
     * Determine y retorne cuantos cursos de pregrado que pertenecen
     * a la carrera que se pasa como parámetro, están calificados
     * y tienen una nota por encima de 20, pero por debajo de 60.
     */
    fun ejercicio05(carrera: String): Int {
        var contador=0
        for (curso in cursos){
            if (curso.dePostgrado==false && curso.carrera==carrera &&
                curso.estaCalificado()==true && curso.darNota()>20.0 && curso.darNota()<60.0) {
                contador++
            }
        }
        return contador
    }

    /**
     * Halle la suma de los créditos de todos los cursos que tiene
     * el estudiante
     */
    fun ejercicio06(): Int {
        var contador=0
        for (curso in this.cursos){
            if (curso.creditos<=4) {
                //Para sumar todos los créditos
                contador+=curso.creditos
            }

        }
        return contador
    }

    /**
     * Halle la suma de los créditos de aquellos cursos
     * que están calificados y que pertenecen a la carrera
     * que se pasa como parámetro y que fueron aprobados
     */
    fun ejercicio07(carrera: String): Int {
        var contador=0
        for (curso in this.cursos){
            if (curso.carrera==carrera && curso.estaCalificado()==true && curso.aproboCurso()==true) {
                //Para sumar todos los créditos
                contador+=curso.creditos
            }

        }
        return contador
    }

    /**
     * Obtener el promedio normal de las notas de
     * aquellos cursos que han sido calificados
     */
    fun ejercicio08(): Double {
        var contador=0
        var notas=0.0
        for (curso in this.cursos){
            if (curso.estaCalificado()==true) {
                //Para sumar todos los créditos
                contador++
                notas+=curso.darNota()
            }

        }
        return notas/contador
    }

    /**
     * Calcula el promedio ponderado del estudiante de los cursos que tienen
     * nota asignada. Para hallar el promedio ponderado debe sumarse la
     * multiplicacion de la nota por los creditos y dividirlo por la suma
     * de los créditos. Ojo: SOLO LOS QUE TIENEN NOTA
     */
    fun ejercicio09(): Double {
        var contador=0
        var notas=0.0
        for (curso in this.cursos){
            if (curso.estaCalificado()==true) {
                //Para sumar todos los créditos
                contador+=curso.creditos
                notas+=curso.darNota()*curso.creditos
            }

        }
        return notas/contador
    }

    /**
     * Determine y retorne el porcentaje de cursos aprobados
     * del estudiante. Debe ser un número entre 0 y 100
     */
    fun ejercicio10(): Double {
        var contador=0
        var total=0
        var porcentaje=0.0
        for (curso in this.cursos){
            total++
            if (curso.aproboCurso()==true) {
                contador++
                porcentaje=contador*100.0/total
            }

        }
        return porcentaje
    }
    //también para evitar usar el total se puede escribir:
    //porcentaje=contador*100.0/cursos.size.toDouble()

    /**
     * Obtener y retornar el curso que tiene el código que
     * se pasa como parámetro. Si no existe el código en la
     * lista, deberá retornarse null
     */
    fun ejercicio11(codigo: String): Curso? {
        //el signo: ? en el dato de salida es para retornar un null
        for (curso in this.cursos){
            if (curso.codigo==codigo) {
                return curso
            }
        }
        //el null sólo se regresa fuera del for
        return null
    }

    /**
     * Escriba un método que retorne el código del
     * primer curso que pertenezca a la carrera que
     * se recibe como parámetro y que tiene el número
     * de créditos que se recibe también como parámetro.
     * Si no existe ese curso, deberá retornarse la
     * cadena vacía ("")
     */
    fun ejercicio12(carrera: String, creditos: Int): String {
        for (curso in this.cursos){
            if (curso.carrera==carrera && curso.creditos==creditos) {
                //Para devolver una cadena
                return "${curso.codigo}"
            }
        }
        return ""
    }
    /**
     * EL PARADIGMA DEL MAYOR.
     * Sirve para hallar el menor también.
     * Retorne la nota más alta de la lista.
     * */
    fun notasMasAlta():Double{
        var masAlta:Double= cursos[0].darNota()// la nota del primer curso //Double.MIN_VALUE
        for(curso in cursos){
            if(curso.darNota()>masAlta){
                masAlta=curso.darNota()
            }
        }
        return masAlta
    }
}
