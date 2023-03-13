/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Listas en Kotlin
 * Autor: Universidad EAN - 23 de febrero de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller07

import kotlin.math.pow

/**
 * Información que mantenemos de una persona
 */
data class Persona(
    val cedula: Int,
    val edad: Int,
    val genero: String,             // "M" para masculino, "F" para Femenino
    val hijos: Int,
    val nivelEducativo: String,     // PRIMARIA, SECUNDARIA, PREGRADO, POSTGRADO
    val estrato: Int,
    val ingresos: Int,
    val peso: Int,                  // Peso en kilos
    val altura: Int,                // altura en centímetros
    val fuma: Boolean,
    val tieneLentes: Boolean,
    val tieneCasa: Boolean,
    val tieneAutomovil: Boolean
) {
    /**
     * Este método obtiene el año de nacimiento de la persona en el 2023
     */
    fun añoNacimiento(): Int = 2023-edad

    /**
     * Método que retorna el impuesto que debe pagar la persona.
     * Si la persona es de estrato 1 o 2, este impuesto corresponde al 5% de los ingresos
     * Para los otros estratos corresponde a la décima parte del ingreso más 10 mil pesos
     * multiplicado por el estrato
     */
    fun impuesto(): Double {
        if(estrato==1 || estrato==2) {
            return ingresos * 0.05
        }
        return (ingresos*0.10)+(10_000*estrato)
    }
}

//-----------------------------------------------------------------------------
// Operaciones a llevar a cabo
//-----------------------------------------------------------------------------

fun contarMujeresConAutomovil(personas: List<Persona>): Int {
    var cont = 0;
    for (mujer in personas){
        if (mujer.genero=="F" && mujer.tieneAutomovil==true) {
            cont++
        }
    }
    return cont
}

/**
 * Contar el número de personas que pesan entre 60 y 80 kilos
 */
fun ejercicio1a(personas: List<Persona>): Int {
    var cont=0
    for (persona in personas){
        if(persona.peso>=60 && persona.peso<=80) {
            cont++
        }
    }
    return cont
}

/**
 * Determinar si la cantidad de mujeres es superior a la cantidad de hombres
 * El método deberá retornar true si hay más mujeres que hombres y false
 * en caso contrario.
 */
fun ejercicio1b(personas: List<Persona>): Boolean {
    var muj=0
    var hom=0
    for(gen in personas){
        if (gen.genero=="M") {
            hom++
        }
        if(gen.genero=="F") {
            muj++
        }
    }
    if(muj>hom)
        return true
    return false
}

/**
 * Encontrar la suma de los ingresos de aquellas personas
 * que no fuman y que sean mayores de 50 años de edad
 */
fun ejercicio2a(personas: List<Persona>): Int {
    var sum=0
    for (pers in personas){
        if(pers.fuma==false && pers.edad>50) {
            sum += pers.ingresos
        }
    }
    return sum
}

/**
 * Escriba una función que retorne la suma de los pesos
 * de las personas de genero femenino, cuyo cédula es par
 * y no tiene hijos
 */
fun ejercicio2b(personas: List<Persona>): Int {
    var sum=0
    for(pers in personas){
        if(pers.genero=="F" && pers.cedula%2==0 && pers.hijos==0) {
            sum += pers.peso
        }
    }
    return sum
}

/**
 * Escriba una función que retorne el promedio de edad
 * de los hombres que se ganan entre 2 y 3 millones
 */
fun ejercicio3a(personas: List<Persona>): Double {
    var prom=0
    var cont=0
    for (pers in personas){
        if(pers.genero=="M" && pers.ingresos>=2_000_000 && pers.ingresos<=3_000_000) {
            //cuando sean operaciones largas, mejor poner las llaves en los if
            cont++
            prom += pers.edad
        }
    }
    return prom.toDouble()/cont.toDouble()
}

/**
 * ¿Cual es el promedio de ingresos de aquellas personas que tienen una
 * altura inferior a 170 centímetros, y que pesan entre 80 y 90 kilos
 * y no fuman ni usan lentes y cuyo nivel educativo sea igual al que
 * se pasa como parámetro
 */
fun ejercicio3b(personas: List<Persona>, nivel: String): Double {
    var cont=0
    var prom=0
    for (pers in personas){
        if(pers.altura<170 && pers.peso>=80 && pers.peso<=90 && pers.fuma==false
            && pers.tieneLentes==false && pers.nivelEducativo==nivel) {
            cont++
            prom += pers.ingresos
        }
    }
    return prom/cont.toDouble()
}

/**
 * Cuál es el porcentaje de mujeres que viven en estrato 1, 2 o 3 y que tienen casa
 */
fun ejercicio3c(personas: List<Persona>): Double {
    var cont=0
    for(pers in personas){
        if(pers.genero=="F" && pers.estrato>=1 && pers.estrato<=3 && pers.tieneCasa==true){
            cont++
        }
    }
    return cont*100.0/personas.size.toDouble()
    //porcentaje=contador*100.0/total
}

/**
 * Hallar el indice de masa corporal de una persona
 * Este indice se halla p / h^2, donde p es el peso en kilos, y h es la altura
 * en metros.
 */
fun imc(persona: Persona): Double  {
    var p=persona.peso
    var h=persona.altura
    return p/(h*0.01).toDouble().pow(2)
}

/**
 * El nivel de peso de una persona depende del imc de esa persona
 * de acuerdo a la siguiente:
 * nivel = "Bajo peso" cuando el imc está por debajo de 18.5
 * nivel = "Normal" cuando el imc está entre 18.5 y 24.9
 * nivel = "Sobrepeso" cuando el imc está entre 25.0 y 29.9
 * nivel = "Obesidad" cuando el imc es 30.0 o superior
 * Escriba una función que halle el nivel de peso de una persona
 * USE LA FUNCIÓN IMC HECHA ANTERIORMENTE
 */
fun nivelPeso(p: Persona): String {
    var n= imc(p)
    if (n<18.5)
        return "Bajo peso"
    if (n>=18.5 && n<=25.0)
        return "Normal"
    if (n>=25.0 && n<=30.0)
        return "Sobrepeso"
    return "Obesidad"
}

/**
 * Halle el promedio de edad de los hombres obesos
 */
fun ejercicio3d(personas: List<Persona>): Double {
    var cont=0
    var prom=0
    for (pers in personas){
        if(pers.genero=="M" && nivelPeso(pers)=="Obesidad") {
            cont++
            prom+=pers.edad
        }
    }
    return prom/cont.toDouble()
}

/**
 * Hallar la cédula de la mujer más alta
 */
fun ejercicio4a(personas: List<Persona>): Int {
    var mayorAltura=0
    var cedulaMujerMasAlta=0

    for (pers in personas){
        if(pers.genero=="F") {
            if (pers.altura > mayorAltura) {
                mayorAltura = pers.altura
                cedulaMujerMasAlta = pers.cedula
            }
        }
    }
    return cedulaMujerMasAlta
}

/**
 * Escriba una función que retorne la cédula del hombre
 * mayor de 30 años que tiene los ingresos más bajos
 */
fun ejercicio4b(personas: List<Persona>): Int {
    var ingresosMasBajos:Double=personas[0].ingresos.toDouble()
    var cedulaHombreMenorIngreso=0

    for (pers in personas){
        if (pers.genero=="M" && pers.edad>30){
            if (pers.ingresos<ingresosMasBajos) {
                ingresosMasBajos=pers.ingresos.toDouble()
                cedulaHombreMenorIngreso=pers.cedula
            }
        }
    }
    return cedulaHombreMenorIngreso
}

/**
 * Escriba una función que retorne la lista de las
 * cédulas de aquellas mujeres que no tienen casa
 * no tienen hijos y tienen un nivel de peso normal
 */
fun ejercicio05(personas: List<Persona>): List<Int> {
    var resultado = mutableListOf<Int>()

    for (pers in personas){
        if (pers.genero=="F" && pers.tieneCasa==false && pers.hijos==0 && nivelPeso(pers)=="Normal"){
            resultado.add(pers.cedula)
        }
    }

    return resultado
}

/**
 * Escriba una función que retorne una lista con las personas
 * que pagan menos de 250 mil pesos en impuesto pero que tiene
 * carro y que viven en estrato 4 y tienen un pregrado o un
 * postgrado
 */
fun ejercicio05b(personas: List<Persona>): List<Persona> {
    var resul= mutableListOf<Persona>()
    for(pers in personas){
        if (pers.impuesto()<=250_000 && pers.tieneAutomovil==true && pers.estrato==4
            && (pers.nivelEducativo=="PREGRADO" || pers.nivelEducativo=="POSTGRADO")){
            resul.add(pers)
        }
    }
    return resul
}

/**
 * Escriba una función que retorne cuál de los 4 estratos tiene la mayor
 * cantidad de hombres.
 */

fun ejercicio06(personas: List<Persona>): Int {
    var cont1=0
    var cont2=0
    var cont3=0
    var cont4=0
    var estrato=0
    for (pers in personas){
        if (pers.genero=="M"){
            if(pers.estrato==1) {
                cont1++
            }
            if (pers.estrato==2){
                cont2++
            }
            if (pers.estrato==3){
                cont3++
            }
            if (pers.estrato==4){
                cont3++
            }
        }
        if(cont1>cont2 && cont1>cont3 && cont1>cont4) {
            estrato = 1
        }
        if(cont2>cont1 && cont2>cont3 && cont2>cont4) {
            estrato = 2
        }
        if(cont3>cont2 && cont3>cont1 && cont3>cont4) {
            estrato = 3
        }
        if(cont4>cont2 && cont4>cont3 && cont4>cont1) {
            estrato = 4
        }
    }
    return estrato
}

