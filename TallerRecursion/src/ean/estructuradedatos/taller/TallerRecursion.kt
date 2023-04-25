package ean.estructuradedatos.taller

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 18 de abril de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
               //Realizado por: Dina Tuesta y Gustavo Sandoval
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Halla el factorial del número entero n
 * n! = n * (n-1) * (n-2) * ... * 2 * 1
 */
fun factorial(n: Int): Int =
    when(n){
        1->1
        else-> factorial(n-1)*n
    }



/**
 * Halla el n-ésimo término de la serie de fibonacci
 */ //Recursión binaria
fun fibonacci(n: Int): Int =
    when(n){
        1,2->1
        else-> fibonacci(n-1) + fibonacci(n-2)
    }

/**
 * Permite determinar el término n,m del triángulo de Pascal
 * n = fila, m = término
 */
fun pascal(n: Int, m: Int): Int {
    if (m==1 || m==n+1) {
        return 1
    }
    return pascal (n-1,m) + pascal(n-1,m-1)
}
/**
 * Halla el valor de x^y =
 * si y es cero entonces retorne 1
 * sino retorne x multiplicado por elevar x a la y - 1
 */
fun elevar(x: Int, y: Int): Int =
    when(y){
        0->1
        else->x* elevar(x,y-1)
    }

/**
 * Halla la suma de todos los números enteros entre 1 y n
 */
fun sumatoria(n: Int): Int =
    when (n){
        1->1
        else-> sumatoria(n-1) + n
    }

/**
 * Halla la suma de los cuadrados de los números de 1 hasta n
 */
fun sumaCuadrados(n: Int): Int =
    when(n) {
        0->0
        else-> sumaCuadrados(n-1) + (n*n)
    }

/**
 * Hallar el valor de la sumatoria de 1/(2i+1) desde  1 hasta n
 */
fun serie(n: Int): Double =
    when(n) {
        1->1.0/3.0
        else-> serie(n-1) + 1.0/(2*n+1.0)
    }

/**
 * Hallar el valor de la sumatoria de 1 hasta n de i/(i^2+1)
 */
fun sumatoria2(n: Int): Double =
    when (n){
        1->1.0/2.0
        else-> sumatoria2(n-1) + n/((n*n)+1.0)
    }

/**
 * Permite saber la cantidad de digitos que posee un número entero positivo n
 */
fun contarDigitos(n: Int): Int =
    when(n) {
        in 0 .. 9->1 //Tiene un dígito
        else->{
            val resto= n / 10 //le quito el último dígito
            val c= contarDigitos(resto)
            c+1 //le sumo uno para tenerelos completos
        }
    }

/**
 * Permite saber el número de ceros que tiene un número.
 * Por ejemplo: 2020 tiene dos ceros.
 */
fun numeroDeCeros(n: Int): Int =
    if (n < 10) {
        if (n == 0) {
            1
        } else {
            0
        }
    } else {
        val ult=n%10
        val resto=n/10
        val c= numeroDeCeros(resto)
        if (ult == 0) {
            c + 1
        } else {
            c
        }
    }

/**
 * Permite hallar la suma de los dígitos de un número entero positivo n
 */
fun sumarDigitos(n: Int): Int =
    when(n){
        0->0
        in 0 .. 9->n
        else-> {
            val ult = n % 10
            val resto = n / 10
            val c = sumarDigitos(resto)
            c + ult
        }
    }

/**
 * Un número entero positivo en múltiplo de 3 si:
 *  - tiene una cifra y es 0, 3, 6, o 9
 *  - tiene más de una cifra y la suma de sus dígitos es múltiplo de 3 (recursion)
 *  - en cualquier otro caso, el número no es múltiplo de 3
 *
 *  - NO PUEDEN USAR LA OPERACIÓN MÓDULO (%) PARA SABER SI ES DIVISIBLE
 */
fun esMultiploDe3(n: Int): Boolean {
    if (n == 0 || n == 3 || n == 6 || n == 9) {
        return true
    } else if (n > 10) {
        val m = (sumarDigitos(n))
        if (esMultiploDe3(m)==true) {
            return true
        }
    }
    return false
}
/**
 * Cuenta el número de dígitos pares que tiene un número entero positivo >= 1
 */
fun cantidadDigitosPares(n: Int): Int =
    if (n < 10) {
        if (n == 0 || n==2 || n==4 || n == 6 || n==8 ) {
            1
        } else {
            0
        }
    } else {
        val ult=n%10
        val resto=n/10
        val c= cantidadDigitosPares(resto)
        if (ult == 0 || ult==2 || ult==4 || ult == 6 || ult==8) {
            c + 1
        } else {
            c
        }
    }


/**
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen los dígitos 1 y 0
 * Por ejemplo: el numero 100011110 es binario, pero 231 no lo es
 */
fun esNumeroBinario(n: Int): Boolean {
    if (n==0 ||n==1){
        return true
    }
    if (n%10 > 1) {
        return false
    }
    return esNumeroBinario(n/10)
}

/**
 * Permite saber si el número dado posee el dígito indicado
 */
fun poseeDigito(n: Int, digito: Int): Boolean {
    /*
    si el numero n posee un solo digito, entonces
       si n y el digito son iguales -> retorne true sino retorne false
    sino si el número n tiene más de un dígito, entonces
       si el ultimo dígito del número n es igual al dígito, entonces
         listo, lo encontramos, retorne true
       sino
         halle el resto de n
         mire si el resto de n posee el dígito indicado
     */
    if (n in 0 .. 9) {
        return n == digito
    }else {
        val ult = n % 10
        if (ult == digito) {
            return true
        } else {
            val sobra = n / 10
            return poseeDigito(sobra, digito)
        }
    }
}

/**
 * Retorna el dígito más grande que hace parte del número n
 * Ejemplo: el dígito más grande del númer 381704 es el 8
 * si el número tiene un solo dígito, el digito más grande es el numero
 * sino
 *    halle el resto y el último
 *    halla el digito mas grande del resto
 *    retorne el mayor entre el último y el dígito más grande del resto
 */
fun digitoMasGrande(n: Int): Int {
    if (contarDigitos(n) == 1) {
        return n
    } else {
        val ult=n%10
        val resto=n/10
        var digitoMasGrande=digitoMasGrande(resto)
        if (digitoMasGrande>ult) {
            return digitoMasGrande
        }
        return ult
    }
}

/**
 * Halla el máximo común divisor entre m y n, utilizando el método de
 * Euclides.
 */
fun mcd(m: Int, n: Int): Int =
    when(n) {
        0->m
        else-> mcd(n,m%n)
    }

/**
 * Imprimir cada elemento de la lista, pero de manera recursiva
 */
fun <T> imprimirLista(lista: List<T>) {
    if (lista.isEmpty()) { //si está vacía
        println()
    } else {
        val prim = lista.first()
        val resto=lista.subList(1,lista.size)//Desde la posición uno hasta la última
        println(prim) //Imprimir
        imprimirLista(resto)
    }
}

/**
 * Obtiene recursivamente la lista de los dígitos del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 */
fun digitos(n: Int): List<Int> {
    if (n in 0 .. 9) {
        return listOf(n)
    }else{
        val ult=n%10
        val resto=n/10
        var lst= digitos(resto)
        lst += ult
        return lst
    }
}

/**
 * Dado un número entero positivo >= 0, retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = List(1, 1, 0, 0, 1, 1, 1, 1, 1, 1)
 */
fun convertirDecimalBinario(n: Int): List<Int> {
    if (n > 1) {
        val ult = n % 2
        val resto = n / 2
        var deci = convertirDecimalBinario(resto)
        deci += ult
        return deci
    }else if (n == 0) {
        return listOf(0)
    }
        return listOf(1)
}
/**
 * Determina cuantas palabras en la lista son verbos.
 * Recursivamente.
 */
fun contarVerbos(palabras: List<String>): Int {
    if (palabras.isEmpty()) { //si está vacía
        return 0
    } else {
        var prim= palabras.first() //se toma el primer elemento
        val resto= palabras.subList(1,palabras.size) //que "recora" la lista desde el 1 hasta el final
        var sonVerbos= contarVerbos(resto) //que obtenga los verbos del resto
        if (prim.endsWith("ar") || prim.endsWith("er") || prim.endsWith("ir")) {
            sonVerbos += 1 // si el prim es un verbo que lo sume al resto
        }
        return sonVerbos
    }
}
/**
 * Recursion con listas: Hallar la suma de los números pares de la lista que se recibe
 * como parámetro.
 * Ejemplo: sumarParesLista([40, 21, 8, 31, 6]) == 54
 */
fun sumarParesLista(lista: List<Int>): Int {
    if (lista.isEmpty()) { //si está vacía
        return 0
    } else {
        val prim= lista.first()
        val resto= lista.subList(1,lista.size)
        var sum= sumarParesLista(resto)
        if (prim%2==0){
            sum+=prim
        }
        return sum
    }
}

/**
 * Recursión con listas: construir una función recursiva que retorne la posición del elemento en la lista
 * Si la lista está vacía, retorne -1. No se puede usar indexOf o lastIndexOf
 */
fun buscarElementoEnUnaLista(lista: List<Int>, elem: Int): Int {
    if (lista.isEmpty()) { //si está vacía
        return -1
    } else {
        var prim= lista.first()
        val resto= lista.subList(1,lista.size)
        var busc= buscarElementoEnUnaLista(resto,elem)
        if (prim == elem) {
            return 0
        }else if (busc == -1) {
            return -1
        } else {
            return busc + 1
        }
    }
}

/**
 * Traduce los diversos dígitos de la lista a un número entero
 * Ejemplo: convertirListaDigitosNumero([3, 4, 1, 7, 9]) == 34179
 */
fun convertirListaDigitosNumero(digitos: List<Int>): Int {
    if (digitos.isEmpty()) {
        return 0
    } else {
        val ult = digitos.last()
        val resto = digitos.subList(0, digitos.size - 1) //para llegar antes del último
        return ult + 10 * convertirListaDigitosNumero(resto) // es para mover el valor en el que esta hasta el último
    }
}

/**
 * Función genérica y recursiva que permite saber si un elemento está dentro
 * de la lista. No debe usarse la función indexOf o contains. Debe ser
 * recursiva. Para buscar un elemento hay que tener en cuenta
 * - si la lista está vacía, el elemento no está
 * - si el primero de la lista es igual al elemento, retornamos true (el elemento está)
 * - sino es igual al primero, entonces hay que ver si el elemento está en el resto de la lista
 */
fun <T> existeElemento(lista: List<T>, elem: T): Boolean {
    if (lista.isEmpty()) { //si está vacía
        return false
    } else {
        var prim= lista.first()
        val resto= lista.subList(1,lista.size)
        var exis= existeElemento(resto,elem)
        if (prim == elem) {
            return true
        }else if (exis == true) {
            return true
        } else {
            return false
        }
    }
}

/** Escribir una función recursiva que, sin usar pilas ni colas
 * ni ninguna otra lista, obtenga la misma lista, pero invertida
 */
fun invertirLista(lista: List<Char>): List<Char> {
    if (lista.isEmpty()) {
        return lista
    } else {
        val ult = lista.last()
        val resto = lista.subList(0, lista.size - 1) //toma del primero hasta el anterior al último
        return listOf(ult) + invertirLista(resto)
    }
}

/**
 * Una palabra es palíndrome si se lee igual de izquierda a derecha y de derecha
 * a izquierda. Esta función recibe la palabra (sin espacios) y de forma recursiva
 * determina si la palabra es palíndrome.
 */
fun esPalindrome(palabra: String): Boolean =
    if (palabra.length <= 1) {
        true
    } else {
        val primera = palabra.first()
        val ultima = palabra.last()
        if (primera == ultima) {
            esPalindrome(palabra.substring(1, palabra.length - 1))// substring invierte las letras desde la pos 1 hasta la anterior a la última
        } else {
            false
        }
    }

/**
 * Recursividad con listas. Escriba una función recursiva
 * Obtiene el número más grande de la lista. Si la lista está vacía retorne el número
 * entero más pequeño.
 */
fun mayorDeUnaLista(lista: List<Int>): Int {
    if (lista.isEmpty()) {
        return Int.MIN_VALUE
    } else {
        val prim = lista.first()
        val resto = lista.subList(1, lista.size)
        val mayorResto = mayorDeUnaLista(resto)
        if (prim > mayorResto) {
            return prim
        } else {
            return mayorResto
        }
    }
}


/**
 * Una clase auxiliar
 */
data class Punto(val x: Int, val y: Int) {
    fun distanciaAlOrigen(): Double = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
}

/**
 * Recursivamente, obtener una lista con aquellos puntos que están en el origen o
 * que hacen parte del primer cuadrante.
 */
fun puntosPrimerCuadrante(puntos: List<Punto>): List<Punto> {
    if (puntos.isEmpty()) {
        return listOf()
    } else {
        val prim=puntos.first()
        val resto = puntos.subList(1, puntos.size)
        var c= puntosPrimerCuadrante(resto)
        if (prim.x >= 0 && prim.y >= 0) {
            return listOf(prim) + c
        } else {
            return c
        }
    }
}

/**
 * Recursivamente, obtiene el punto que está más lejano del origen.
 * Si la lista esta vacía, retorne null
 * Si la lista tiene un solo elemento, retorne ese elemento
 * si la lista tiene más de un elemento, tome el primer elemento y
 * compárelo con el punto más lejano del resto de la lista.
 */
fun puntoMasLejano(puntos: List<Punto>): Punto? {
    if (puntos.isEmpty()) {
        return null
    } else if(puntos.size==1) {
        return puntos[0]
    }else{
        val prim=puntos.first()
        val resto = puntos.subList(1, puntos.size)
        var m= puntoMasLejano(resto)
        if (m==null) {
            return null
        } else {
            if (prim.distanciaAlOrigen() > m.distanciaAlOrigen()) {
                return prim
            } else {
                return m
            }
        }
    }

}


