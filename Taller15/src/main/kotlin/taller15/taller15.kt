/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Faculta de Ingeniería
 *
 * Taller Árboles Binarios
 * Fecha: 25 de abril de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller15

import ean.collections.IBinTree
import ean.collections.IList
import ean.collections.Lists
import ean.utils.maxAmong

/**
 * Informar si un elemento se encuentra presente en un árbol binario
 */
fun <T> estaArbin(a: IBinTree<T>, elem: T): Boolean =
    if (a.isEmpty) //si está vacío
        false
    else {
        val raiz = a.root
        (raiz==elem || estaArbin(a.left, elem) || estaArbin(a.right, elem))
    }

/**
 * Permite obtener el número de vocales que hay en el árbol
 */
fun contarVocales(arbol: IBinTree<String>): Int =
    if (arbol.isEmpty) {
        0
    }else{
        val raiz=arbol.root.toLowerCase()
        var cont= contarVocales(arbol.left) + contarVocales(arbol.right)
        if (raiz=="a" || raiz=="e" || raiz=="i" || raiz=="o" || raiz=="u") {
            cont++
        }
        cont
    }

/**
 * Permite determinar cuantos elementos en el árbol son de dos dígitos y la suma de ambos dígitos es 7
 */
fun contarArbol(a: IBinTree<Int>): Int =
    if (a.isEmpty) //si está vacío
        0
    else {
        val raiz = a.root
        var cont = contarArbol(a.left) + contarArbol(a.right)
        if (raiz in 10..99 && raiz / 10 + raiz % 10 == 7) {
            cont++
        }
        cont
    }
/**
 * Determinar la suma de los elementos pares del árbol
 */
fun sumaPares(arbol: IBinTree<Int>): Int =
    if (arbol.isEmpty) //si está vacío
        0
    else {
        val raiz = arbol.root
        //Primero la suma
        var cont = sumaPares(arbol.left) + sumaPares(arbol.right)
        if (raiz%2==0) {
            cont += raiz
        }
        cont
    }

/**
 * Permite conocer el porcentaje (entre 0 y 100) de pares en el árbol
 */
fun porcentajePares(a: IBinTree<Int>): Double { //No es recursivo sacar porcentaje
    fun contarPares(a: IBinTree<Int>): Double {
        if (a.isEmpty) //si está vacío
            return 0.0
        else {
            val raiz = a.root
            //Primero la suma
            var cont = contarPares(a.left) + contarPares(a.right)
            if (raiz%2==0) {
                return cont + 1
            }
            return cont
        }
    }
    return contarPares(a) / peso(a).toDouble() * 100.0
}

/**
 * Obtener una lista con aquellos elementos del árbol que sean múltiplos de 6
 */
fun multiplosDeSeis(arbol: IBinTree<Int>): List<Int> {
    if (arbol.isEmpty) {
        return listOf() // o emptyList
    } else {
        val raiz= arbol.root
        val resul= multiplosDeSeis(arbol.left) + multiplosDeSeis(arbol.right) // el + no suma sino pega los datos
        if (raiz%6==0) {
            return resul + raiz // se suma un número a la lista no alrevés
            //Result= list   raiz= int
            // listOf(raiz) para sumar
        }
        return resul
    }
}

/**
 *   Calcular el peso de un árbol binario (Tamaño)
 */
fun <T> peso(a: IBinTree<T>): Int {
    if (a.isEmpty) {
        return 0
    }else{
        val raiz=a.root
        var p= peso(a.left) + peso(a.right)
        return p+1
    }
}

/**
 * Esta función externa, NO ES RECURSIVA, y permite saber si el árbol a es una hoja o no.
 * Un árbol a es una hoja si no es vacio y el árbol izquierdo de a si es vacío y el árbol
 * derecho de a también es vacío. En cualquier otro caso, el árbol no es una hoja.
 */
fun <T> esUnaHoja(a: IBinTree<T>): Boolean =
    if (a.isEmpty) {
        false
    }else{
        if(a.left.isEmpty && a.right.isEmpty) {
            true
        }else{
            false
        }
    }
   //Revisar
/**
 * Esta función externa y genérica recursiva y cuenta el número de hojas. La definición
 * recursiva sería la siguiente:
 * - Si el árbol es vacío, no hay hojas
 * - Sino Si el árbol es una hoja, entonces hay 1 hoja
 * - Sino el número total de hojas que hay en el árbol es el número de hojas del árbol izquierdo más
 *        el número de hojas del árbol derecho.
 */
fun <T> contarHojas(a: IBinTree<T>): Int =
    //Revisar
    if (a.isEmpty) {
        0
    }else if (esUnaHoja(a)==true) {
        1
    }else {
        var cont= contarHojas(a.left) + contarHojas(a.right)
        cont
    }

/**
 * Permite obtener la altura de un árbol binario
 */
fun <T> altura(a: IBinTree<T>): Int =
    if (a.isEmpty) {
        0
    }else{
        val izq= altura(a.left)
        val der= altura(a.right)
        if (izq>der) {
            izq+1
        }else{
            der+1
        }
    }

/**
 * Imprime el árbol binario a en preorden
 */
fun <T> preorden(a: IBinTree<T>): Unit {
    if (!a.isEmpty) {
        println(a.root) //raiz
        preorden(a.left) //Izq
        preorden(a.right) // Der
    }
}

/**
 * Imprime el árbol binario a en postorden
 */
fun <T> postorden(a: IBinTree<T>): Unit {
    if (!a.isEmpty) {
        postorden(a.left) //Izq
        postorden(a.right) //Der
        println(a.root)  //Raiz
    }
}

/**
 * Imprime el árbol binario a en inorden
 */
fun <T> inorden(a: IBinTree<T>) {
    if (!a.isEmpty) {
        inorden(a.left) //Izq
        println(a.root) //Raiz
        inorden(a.right) //Der
    }
}

/**
 * Ayuda a determinar el nivel en que se encuentra un elemento. El algoritmo es el siguiente:
 * si el árbol está vacío, el nivel del elemento es -1
 * sino si el elemento es igual a la raíz del árbol a, el nivel del elemento es cero
 * sino si el elemento esta en el árbol izquierdo de a,
 *    el nivel del elemento es 1 + el nivel del elemento en el árbol izquierdo
 * sino si el elemento esta en el árbol derecho de a,
 *    el nivel del elemento es 1 + el nivel del elemento en el árbol derecho
 * sino
 *    retorne -1
 */
fun <T> nivelElementoArbol(a: IBinTree<T>, elem: T): Int =
    if (a.isEmpty) {
        -1
    }else if (elem == a.root) {
        0
    }else if (estaArbin(a.left,elem)==true) {
        1 + nivelElementoArbol(a.left,elem)
    }else if (estaArbin(a.right, elem)) {
        1 + nivelElementoArbol(a.right, elem)
    }else{
        -1
    }

/**
 * Obtiene el elemento padre del elemento e. Para hallar el papá tenemos el siguiente algoritmo
 * Si el árbol está vacío, el papá es nulo
 * sino si la raíz del árbol es igual al elemento, el papá es nulo también
 * sino si el izquierdo de a no es vacío y la raiz del izquierdo de a es igual al elemento, retorne la raiz de a
 * sino si el derecho de a no es vacío y la raiz del derecho de a es igual al elemento, retorne la raiz de a
 * sino si el elemento está en el árbol izquierdo de a, halle el papá del elemento e en el izquierdo de a
 * sino si el elemento está en el árbol derecho de a, halle el papá del elemento e en el árbol derecho de a
 * sino, retorne nulo.
 */
fun <T> padre(a: IBinTree<T>, e: T): T? =
    if (a.isEmpty) {
        null
    }else if (e == a.root) {
        null
    }else if (!a.left.isEmpty && a.left.root==e) {
        a.root
    }else if (!a.right.isEmpty && a.right.root==e) {
        a.root
    }else if (estaArbin(a.left, e)==true) {
        padre(a.left,e)
    }else if (estaArbin(a.right, e) == true) {
        padre(a.right, e)
    } else {
        null
    }

/**
 * Esta función recursiva, es muy parecida al algoritmo de hallar el papá,
 * pero buscando al hermano. Es posible que el elemento no tenga hermano.
 */
fun <T> hermanoElementoArbol(a: IBinTree<T>, elem: T): T? {
    if (a.isEmpty) {
        return null
    }else if (elem == a.root) {
        return null
    }else if (!a.left.isEmpty && a.left.root==elem && !a.right.isEmpty) {
        return a.right.root
    }else if (!a.right.isEmpty && a.right.root==elem && !a.left.isEmpty) {
        return a.left.root
    }else if (estaArbin(a.left, elem)==true) {
        return hermanoElementoArbol(a.left,elem)
    }else if (estaArbin(a.right, elem) == true) {
        return hermanoElementoArbol(a.right, elem)
    } else {
        return null
    }
}

/**
 *  Calcular cuantas veces aparece un elemento en un arbol
 */
fun <T> contarNumVecesApareceElemento(a: IBinTree<T>, e: T): Int =
    if (a.isEmpty) {
        0
    }else{
        val raiz= a.root
        var cont= contarNumVecesApareceElemento(a.left, e) + contarNumVecesApareceElemento(a.right,e)
        if (raiz==e) {
            cont++
        }
        cont
    }

/**
 * Calcular el menor de un árbol binario. El Algoritmo es el siguiente
 * Si el árbol está vacío, digamos que el menor es un número grande, por ejemplo Int.MAX_VALUE
 * sino hay que retornar el menor entre la raíz, el menor del árbol izquierdo y el menor del árbol derecho
 */
fun menorArbol(arbol: IBinTree<Int>): Int =
    if (arbol.isEmpty) {
        Int.MAX_VALUE
    }else{
        val menorIzq= menorArbol(arbol.left)
        val menorDer= menorArbol(arbol.right)
        val raiz= arbol.root
        minOf(menorIzq, menorDer, raiz) //el minOf saca el menor de los tres elementos.
    }

/**
 * Retorna true si todas las palabras que están en el árbol
 * son verbos. Falso, si hay al menos una palabra que no sea un verbo.
 * Los árboles vacíos son verbales.
 */
fun verbal(arbol: IBinTree<String>): Boolean {
    if (arbol.isEmpty) {
        return false
    }else{
        val raiz=arbol.root
        var izq= verbal(arbol.left)
        var der= verbal(arbol.right)
        if (raiz.endsWith("ar") || raiz.endsWith("er") || raiz.endsWith("ir") || izq || der) {
            return true
        }
        return der
    }
}

/**
 * Un árbol binario es "digital" si cada elemento del árbol
 * tienen un solo dígito. Esta función retorna true si el
 * árbol es digital y false si no lo es. Los árboles vacíos
 * son digitales.
 */
fun digital(arbol: IBinTree<Int>): Boolean {
    if (arbol.isEmpty) {
        return true
    }else{
        val raiz=arbol.root
        var arb= digital(arbol.left)
        var arb2= digital(arbol.right)
        if ((raiz<10) && arb==arb2) {
            return true
        }else {
            return false
        }
    }
}
//Revisar
/**
 * Retornar la palabra más larga del árbol binario.
 * Si el árbol es vacío, la palabra más larga es vacía ""
 */
fun palabraMasLarga(palabras: IBinTree<String>): String {
    if (palabras.isEmpty) {
        return ""
    }else{
        val raiz=palabras.root
        var cont= palabraMasLarga(palabras.left)
        var cont2= palabraMasLarga(palabras.right)
        if (raiz.length>cont.length && raiz.length> cont2.length) {
            return raiz
        }else if (cont.length>raiz.length && cont.length>cont2.length) {
            return cont
        }
        return cont2
    }
}

/**
 * Especificación de la clase Producto
 */
data class Producto(val nombre: String, val precio: Double)

/**
 * Retorna el producto más caro del árbol de productos.
 * Si el árbol está vacío, retorna null
 * Sino, retorna el producto más caro entre el arbol izquierdo, el derecho y la raíz
 * Hay que tener en cuenta cuando el más caro de algún árbol es nulo.
 */
fun productoMasCaro(a: IBinTree<Producto>): Producto? {
    if (a.isEmpty) {
        return null
    }else{
        val raiz=a.root
        val pro= productoMasCaro(a.left)
        val pro2= productoMasCaro(a.right)
        if (pro != null && pro2 != null) {
            if (raiz.precio > pro!!.precio && raiz.precio > pro2!!.precio) {
                return raiz
            } else if (raiz.precio < pro!!.precio && pro.precio > pro2!!.precio) {
                return pro
            } else {
                return pro2
            }
        } else {
            return raiz
        }
    }
}

/**
 * Halla el promedio de precios de todos los productos del árbol
 */
fun promedioPrecios(a: IBinTree<Producto>): Double {
    fun contarPrecios(a: IBinTree<Producto>): Double {
        if (a.isEmpty) //si está vacío
            return 0.0
        else {
            val raiz = a.root
            //Primero la suma
            var cont = contarPrecios(a.left) + contarPrecios(a.right)
            if (cont != null) {
                return cont + raiz.precio
            }
            return raiz.precio
        }
    }
    return contarPrecios(a) / peso(a).toDouble()
}

/**
 * Obtiene una lista con los nombres de los productos que tienen un precio
 * inferior al promedio de precios de todos los productos del árbol
 */
fun productosInferiorPromedio(a: IBinTree<Producto>): List<String> {
    // Obtiene una lista con los nombres de productos con precio inferior al que se pasa por parámetro
    fun productosInferiorPrecio(a: IBinTree<Producto>, precio: Double): List<String> {
        if (a.isEmpty)
            return listOf()
        else {
            val raiz = a.root
            var cont = productosInferiorPrecio(a.left, precio) + productosInferiorPrecio(a.right, precio)
            if (raiz.precio < precio) {
                return listOf(raiz.nombre) + cont // cont + raiz.nombre
            }
            return cont
        }
    }
    // -------------------------------------------------------------
    val promedio = promedioPrecios(a)
    return productosInferiorPrecio(a, promedio)
}

/**
 * Obtiene el precio del producto que tiene el nombre dado
 * Si el árbol es vacío, deberá retornar null.
 */
fun encontrarPrecioProducto(prods: IBinTree<Producto>, nomProducto: String): Double? {
    if (prods.isEmpty) {
        return null
    }else if (prods.root.nombre == nomProducto) {
        return prods.root.precio
    }else{
        var rest= encontrarPrecioProducto(prods.left, nomProducto)
        var rest2= encontrarPrecioProducto(prods.right, nomProducto)
        if (rest != null) {
            return rest
        }else{
            return rest2
        }
    }
}

/**
 * Determina la cantidad de productos cuyo nombre comienzan con la letra
 * que se pasa como parámetro.
 */
fun contarProductosNombreComienzanConLetra(prods: IBinTree<Producto>, letra: Char): Int {
    if (prods.isEmpty) {
        return 0
    }else{
        val raiz= prods.root
        var cont= contarProductosNombreComienzanConLetra(prods.left,letra) + contarProductosNombreComienzanConLetra(prods.right,letra)
        if (raiz.nombre.first()==letra) {
            return 1 + cont
        }else{
            return cont
        }
    }
}

/**
 * Un árbol de producto es un inventario correcto si todos
 * los elementos del árbol de productos tienen un precio superior a 100.0
 * Los árboles vacíos son un inventario correcto
 */
fun inventarioCorrecto(prods: IBinTree<Producto>): Boolean {
    if (prods.isEmpty) {
        return true
    }else{
        val raiz= prods.root
        var resto= inventarioCorrecto(prods.left)
        var resto2= inventarioCorrecto(prods.right)
        if (raiz.precio > 100.0 && resto && resto2) {
            return true
        }
        return false
    }
}
