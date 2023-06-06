package taller20

import ean.colecciones.Lista
import kotlin.math.pow

/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto Programación Funcional
 * @author Luis Cobo (lacobo@universidadean.edu.co)
 * Fecha: Mayo 31, 2023
  * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

// Esta clase guarda la información de una persona
data class Persona(val cedula: Int,
                   val edad: Int,
                   val genero: Char,  // 'H' para hombre y 'M' para mujer
                   val numeroDeHijos: Int,
                   val nivelEducativo: String, // PREESCOLAR, PRIMARIA, SECUNDARIA, UNIVERSITARIA
                   val estratoSocioeconomico: Int,
                   val ingresos: Int,
                   val peso: Int,    // en kilos
                   val altura: Int,  // en centímetros
                   val fuma: Boolean,
                   val usaLentes: Boolean,
                   val tieneCasaPropia: Boolean,
                   val tieneAutomovil: Boolean) {

    // Método interno para hallar el Indice de Masa Corporal = peso / (altura en metros)ˆ2
    fun IMC(): Double = peso.toDouble()/Math.pow(altura/100.0, 2.0)

    // A partir del IMC permite obtener la categoría del estado del peso, así:
    //    IMC                 Nivel de peso
    //    Por debajo de 18.5  Bajo peso
    //    [18.5, 25.0)        Normal
    //    [25.0 – 30)         Sobrepeso
    //    30.0 o más          Obesidad
    fun nivelDePeso(): String {
        if (IMC() < 18.5) {
            return "bajo peso"
        }else if (IMC() > 18.5 && IMC() <= 25.0) {
            return "normal"
        }else if (IMC() > 25.0 && IMC() <= 30) {
            return "sobrepeso"
        }else{
            return "obesidad"
        }
    }
}

/**
 * Ejercicio 1: Cuantos hombres hay en la lista que se recibe como parámetro
 */
fun ejercicio1(personas: Lista<Persona>): Int {
    val hombres= personas.filtrar { it.genero == 'H' }
    return hombres.tam
}

/**
 * Cuál es la cédula de los hombres obesos que nacieron hace más de 55 años
 */
fun ejercicio2(personas: Lista<Persona>): Lista<Int> {
    val nacimiento=personas.filtrar { it.edad > 55 && it.genero == 'H' }
    val obesos=nacimiento.filtrar { it.nivelDePeso() == "obesidad" }
    return obesos.transformar { it.cedula }
}

/**
 * De los estratos 2, 3 o 4, cuál tiene la mayor cantidad de mujeres fumadoras sin hijos
 */
fun ejercicio3(personas: Lista<Persona>): Int {
    val estrato2=personas.contar { it.genero == 'M' && it.fuma && it.numeroDeHijos == 0 && it.estratoSocioeconomico == 2}
    val estrato3=personas.contar { it.genero == 'M' && it.fuma && it.numeroDeHijos == 0 && it.estratoSocioeconomico == 3}
    val estrato4=personas.contar { it.genero == 'M' && it.fuma && it.numeroDeHijos == 0 && it.estratoSocioeconomico == 4}
    if (estrato2 >= estrato3 && estrato2 >= estrato4) {
        return 2
    }else if (estrato4 >= estrato2 && estrato4 >= estrato3) {
        return 4
    }else {
        return 3
    }
}

/**
 * Hallar la suma de los ingresos de las personas que tienen casa, usan lentes, no tienen automóvil y tienen el nivel
 * educativo que se pasa como parámetro
 */
fun ejercicio4(personas: Lista<Persona>, nivel: String): Int {
    val elem: (Persona) -> Int = { it.ingresos }
    val filtro=personas.filtrar { it.usaLentes && it.tieneCasaPropia && !it.tieneAutomovil && it.nivelEducativo == nivel}
    return filtro.sumar(elem)
}

/**
 * Determine si hay alguna mujer que tiene casa y automovil, pero con un ingreso inferior al que se pasa como parámetro
 */
fun ejercicio5(personas: Lista<Persona>, ingreso: Int): Boolean {
    val filt= personas.filtrar { it.genero == 'M' && it.tieneAutomovil && it.ingresos < ingreso}
    return filt.tam > 0
}

/**
 * Determine si todas las personas de la lista son hombres con sobrepeso y que nacieron en la última década del siglo XX
 */
fun ejercicio6(personas: Lista<Persona>): Boolean {
    if(personas.todosLosElementosCumplenCon { it.genero == 'H'
                && it.nivelDePeso() == "sobrepeso" && it.edad >= 24  && it.edad <= 33 }){
        return true
    }
    return false
}

/**
 * Encuentre y retorne las cédulas de aquellas mujeres con un nivel de estudio
 * universitario que tienen un peso superior al peso de la persona cuya cédula
 * se recibe como parámetro
 */
fun ejercicio7(personas: Lista<Persona>, cedula: Int): Lista<Int> {
    val mujerCedula= personas.encontrarElPrimeroQueCumple { it.cedula == cedula}
    val mujUni= personas.filtrar { it.genero == 'M' && it.nivelEducativo == "UNIVERSITARIA" && it.peso > mujerCedula!!.peso}
    return mujUni.transformar { it.cedula }
}

/**
 * Determine si la persona más alta de la lista es hombre de peso normal que usa lentes
 */
fun ejercicio8(personas: Lista<Persona>): Boolean {
    val hom= personas.filtrar { it.nivelDePeso() == "normal" && it.usaLentes}
    val esHoM= hom.encontrarMayor { it.altura }
    return esHoM!!.genero == 'H'
}

/**
 * Determine si el promedio de ingresos de hombres con nivel educativo universitario
 * es superior al promedio de ingresos de las mujeres con nivel educativo universitario
 */
fun ejercicio9(personas: Lista<Persona>): Boolean {
    val elem: (Persona) -> Int = {it.ingresos}

    //Prom Mujeres
    val mujeresUni=personas.filtrar { it.nivelEducativo == "UNIVERSITARIA" && it.genero == 'M'}
    val promMujeresIngresos=(mujeresUni.sumar(elem)).toDouble()/mujeresUni.tam

    //Prom Hombres
    val hombresUni=personas.filtrar { it.nivelEducativo == "UNIVERSITARIA" && it.genero == 'H'}
    val promHombresIngresos=(hombresUni.sumar(elem)).toDouble()/hombresUni.tam

    //Los promedios DEBEN IR EN DOUBLE
    return promHombresIngresos > promMujeresIngresos
}
