package Taller

import kotlin.math.ceil

fun techoDeLaDivisión(a:Int, b:Int): Int=
    ceil(a/b.toDouble()).toInt()
    //En este caso capacidad se vuelve double y al final se vuelve int

fun hallarTuristas(turistas: Int, capacidad: Int, valor: Int): Pair <Int,Int>{
    val viajes= techoDeLaDivisión(turistas,capacidad)
    val costoTotal=viajes * valor
    return viajes to costoTotal //El to es para regresar dos elementos. Igual Pair
}
