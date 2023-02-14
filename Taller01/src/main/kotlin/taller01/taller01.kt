/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 *
 * Unidad de Estudios: Estructura de Datos
 * Taller: 01
 * Fecha: 1 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller01

import kotlin.math.*

/* Ejercicio 01 */
fun ejercicio01(primerCorte: Double, segundoCorte: Double, pruebasObjetivas: Double): Double {
    return((primerCorte*0.4)+(segundoCorte*0.5)+pruebasObjetivas*0.1)
}

/* Ejercicio 02 */
fun ejercicio02(metros: Double): Double {
    return(((metros*24.0)/100.0)*2)
}

/* Ejercicio 03 */
fun ejercicio03(x: Double, y: Double): Double {
    //Para el elevado
    return(Math.pow(x,2.0)+2*x*y+Math.pow(y,2.0))
}

/* Ejercicio 04 */
fun ejercicio04(base: Double, altura: Double): Pair<Double, Double> {
    //El pair se usa para colocar dos respuestas en una sola línea
    return Pair (base*altura,2*base+2*altura)
}

/* Ejercicio 05 */
fun ejercicio05(gordos: Int, flacos: Int, numSillasBus: Int): Int {
    var sillaEstudiantes=((gordos*2)+flacos)
    var Redondeo= Math.ceilDiv(sillaEstudiantes,numSillasBus)
    return(Redondeo)

}

/* Ejercicio 06 */
fun ejercicio06(x: Double, alfa: Double): Double {
    return(x/sin(alfa))
}

/* Ejercicio 07 */
fun ejercicio07(sueldo: Double): Triple<Double, Double, Double> {
    var dineroRestante=sueldo-(sueldo*0.4)+sueldo-(sueldo*0.15)
    return Triple((sueldo*0.4),(sueldo*0.15),dineroRestante-sueldo )
}

/* Ejercicio 08 */
fun ejercicio08(a: Double, b: Double): Triple<Double, Double, Double> {
    var p=b+2*a
    var h=sqrt(Math.pow(a,2.0)-(Math.pow(b,2.0))/4)
    var A=(b*sqrt(Math.pow(a,2.0)-(Math.pow(b,2.0))/4))/2
    return Triple(p, h, A)
}

/* Ejercicio 09 */
fun ejercicio09(r: Double): Double {
    //Área circulo
    return(PI*Math.pow(r,2.0))
}

/* Ejercicio 10 */
fun ejercicio10(r: Double, R: Double): Double {
    return(PI*Math.pow(R,2.0)-PI*Math.pow(r,2.0))
}

/* Ejercicio 11 */
fun ejercicio11(n: Int, m: Int, k: Int): Pair<Int, Int> {
    var horas=((n*m)*k)/60
    var minutos=(n*m)*k
    var minutosRestantes=minutos-(horas*60)
    return Pair (horas,minutosRestantes)
}

/* Ejercicio 12 */
fun ejercicio12(nombreHermano1: String, edadHermano1: Int,
                nombreHermano2: String, edadHermano2: Int,
                nombreHermano3: String, edadHermano3: Int): String {
    var nom1=nombreHermano1
    var nom2=nombreHermano2
    var nom3=nombreHermano3
    var nombre=" "
    if(edadHermano1>edadHermano2 && edadHermano1>edadHermano3) {
        nombre=nom1
    }else if(edadHermano2>edadHermano1 && edadHermano2>edadHermano3){
        nombre=nom2
    }else if(edadHermano3>edadHermano1 && edadHermano3>edadHermano2){
        nombre=nom3
    }
    return(nombre)
}

/* Ejercicio 13 */
fun ejercicio13(salario: Double): Pair<Double, Double> {
    var ValorAumento=0.0
    var NuevoSalario=0.0
    if(salario<800_000.0){
        ValorAumento=(salario*0.10)
        NuevoSalario=ValorAumento+salario
    }else if(800_000.0<=salario && salario<=1_200_000.0){
        ValorAumento=(salario*0.08)
        NuevoSalario=ValorAumento+salario
    }else if(salario>1_200_000.0){
        ValorAumento=(salario*0.05)
        NuevoSalario=ValorAumento+salario
    }
    return Pair(ValorAumento,NuevoSalario)
}

/* Ejercicio 14 */
fun ejercicio14(año: Int): Boolean {
    var Bisiesto=true
    var NoBisiesto=false
    var respuesta: Boolean
    if(año%4==0 && (año%100!=0 || año%400==0)){
        respuesta=Bisiesto
    }else{
        respuesta=NoBisiesto
    }
    return (respuesta)
}