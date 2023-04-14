package taller11

/**
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad EAN (Bogotá - Colombia)
* Departamento de Sistemas
* Faculta de Ingeniería
*
* Proyecto Taller de Pilas
* Autor: Universidad EAN - Marzo 23, 2022
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

import ean.collections.*


/**
 * A partir de una pila de palabras, retornar cuántas de esas
 * palabras son verbos. La pila original no debe verse modificada
 */
fun contarVerbos(palabras: IStack<String>): Int {
    //Toca crear una copia de la original y trabajar en la copia
    val copia=palabras.copy()
    var contador=0
    //Recorrer la copia
    //Mientras no esté vacia
    while (!copia.isEmpty) {
        val pal= copia.peek().toLowerCase()//este to Lower es para poner las palabras en minusculas
        if (pal.endsWith("ar") ||pal.endsWith("er") ||pal.endsWith("ir")) {
            contador++
        }
        copia.pop()
    }
    return contador
}

/**
 * Ejercicio 02
 * Función para sumar los números pares de tres cifras que hay en una
 * pila de enteros. La pila original no debe verse modificada.
 */
fun sumarParesTresCifras(pila: IStack<Int>): Int {
    val copia=pila.copy()
    var cont=0
    while (!copia.isEmpty) {
        val pal=copia.peek()
        if (pal>=100 && pal<=999) {
            if (pal%2==0) {
                cont+=pal
            }
        }
        copia.pop()
    }
    return cont
}

/**
 * Ejercicio 03
 * Función para determinar cuál es el número más grande de dos cifras que hay
 * en una pila de números. Si no existe ningún número de dos cifras, retorne
 * null. La pila original no debe verse modificada.
 */
fun mayorDeDosCifras(pila: IStack<Int>): Int? {
    val copia=pila.copy()
    var Mayor=0
    while (!copia.isEmpty) {
        var mas=copia.peek()
        if (mas>=10 && mas<=99 && mas>Mayor) {
                    Mayor=mas
        }
        copia.pop()
    }
    if (Mayor==0) {
        return null
    }
        return Mayor
}

/**
 * Ejercicio 01
 * Obtener y retornar el fondo de la pila. La pila original no debe verse
 * modificada.
 */ //Función genérica por la T
fun <T> obtenerFondo(pila: IStack<T>): T {
    //Crear una copia
    val copia=pila.copy()
    //Creamos una pila vacía
    val temp=TLinkedStack<T>()
    //Recorremos la copia
    while (!copia.isEmpty) {
        //Obtengo el elemento en el tope
        val elem=copia.peek()
        //Obtengo el elemento de la pila temporal
        temp.push(elem)
        //Elimino el elemento de la copia
        copia.pop()
    }
    //Retornamos el fondo de la pila
    return temp.peek()

}

/**
 * Ejercicio 04
 * Hacer una función externa que permita guardar un elemento en el fondo
 * de la pila. GEnérica. La pila original si debe verse modificada.
 */
fun <T> guardarEnElFondo(p: IStack<T>, elem: T) {
    val pilaV=TLinkedStack<T>()
    while (!p.isEmpty){
        val ele=p.peek()
        pilaV.push(ele)
        p.pop()
    }
    return p.push(elem)

}

/**
 * Ejercicio 05
 * Función genérica para obtener el tamaño de una pila. La pila
 * original no debe verse modificada.
 */
fun <T> tamPila(p: IStack<T>) : Int {
    val copia=p.copy()
    val temp=TLinkedStack<T>()
    var contador=0
    while (!copia.isEmpty) {
        contador++
        val elem=copia.peek()
        temp.push(elem)
        copia.pop()
    }
    return contador
}

/**
 * Ejercicio 06
 * Función genérica que permite Invertir una pila en otra.
 * Recibe la pila y retorna la pila, pero invertida.
 * Solo puede usarse las operaciones de las pilas, no listas.
 */
fun <T> invertirPila(pila: IStack<T>): IStack<T> {
    val pilaV=TLinkedStack<T>()
    val pilaV2=TLinkedStack<T>()
    while (!pila.isEmpty) {
        val elem=pila.peek()
        pilaV.push(elem)
        pila.pop()
    }
    while (!pilaV.isEmpty) {
        val elem2=pilaV.peek()
        pilaV2.push(elem2)
        pilaV.pop()
    }
    while (!pilaV2.isEmpty) {
        val elem3=pilaV2.peek()
        pila.push(elem3)
        pilaV2.pop()
    }
    return pila

}


/**
 * Ejercicio 07
 * Función genérica que copia una pila en otra.
 * La función recibe la pila y retorna la copia.
 * No debe usarse el método copy de la pila ni listas.
 * La pila original no debe verse modificada.
 */
fun <T> copiarPila(pila: IStack<T>): IStack<T> {
    val copia=TLinkedStack<T>()
    val temp= invertirPila(pila)
    while (!temp.isEmpty) {
        val elem=temp.peek()
        copia.push(elem)
        temp.pop()
    }
    return copia
}


/**
 * Ejercicio 08
 * Función genérica que recibe una pila y un elemento y que elimina de la
 * pila todas las ocurrencias del elemento que se recibe como parámetro.
 * No debe retornar nada.
 */
fun <T> eliminarElementoPila(pila: IStack<T>, elem: T) {
    val temp=TLinkedStack<T>()
    while (!pila.isEmpty) {
        val elem2=pila.peek()
        if (elem!=elem2) {
            temp.push(elem2)
        }
        pila.pop()
    }
    while (!temp.isEmpty) {
        val elem3=temp.peek()
        pila.push(elem3)
        temp.pop()
    }
}

/**
 * Ejercicio 09
 * Invertir una lista de números utilizando una pila. La función no retorna,
 * debe modificar la lista
 */
fun invertirLista(list: MutableList<Int>) {
    val pila:IStack<Int> = TLinkedStack() //Una pila vacía
    while (list.isNotEmpty()) {
        val elem= list[0]
        pila.push(elem)
        list.remove(elem)
    }
    while (!pila.isEmpty) {
        val elem2 = pila.peek()
        list.add(elem2)
        pila.pop()
    }
}


/**
 * Ejercicio 10
 * Usar una pila de letras para Determinar si una frase es palindrome o no
 * Retorne true si la frase es palíndrome y false si no lo es.
 */
fun palindrome(frase: String): Boolean {
    //Para tomar las letras de la pila
    val pila:IStack<Char> = TLinkedStack()
    //Para ingresar las letras a la pila
    for (letras in frase) {
        //queda la palabra alreves
        pila.push(letras)
    }

    var nuevaFrase=""
    while (!pila.isEmpty) {
        val elem=pila.peek()
        //Agregar las letras de la pila y volverlo un String
        nuevaFrase += elem
        pila.pop()
    }
    if (frase==nuevaFrase) {
        return true
    }
    return false
}

/**
 * Ejercicio 11
 * Determinar si dos pilas son iguales.
 * Retorne true si son idénticas o false si no es así
 * Las pilas no deben ser modificadas.
 */
fun <T> igualesPilas(pila1: IStack<T>, pila2: IStack<T>): Boolean {
    val copia1=pila1.copy()
    val pilaV=TLinkedStack<T>()
    val copia2=pila2.copy()
    val pilaV2=TLinkedStack<T>()
    while (!copia1.isEmpty && !copia2.isEmpty) {
        val elem=copia1.peek()
        val elem1=copia2.peek()
        if (elem == elem1) {
            pilaV.push(elem)
            pilaV2.push(elem1)
        } else {
            return false
        }
        copia1.pop()
        copia2.pop()
    }
    return true
}

/**
 * Escriba una función que reemplace cada aparición del elemento
 * oldItem por el elemento newItem en la pila.
 */
fun reemplazarElementoPila(pila: IStack<Int>, oldItem: Int, newItem: Int) {
    val pilaV:IStack<Int> = TLinkedStack()
    while (!pila.isEmpty) {
        val elem=pila.peek()
        if (elem == oldItem) {
            pilaV.push(newItem)
        } else {
            pilaV.push(elem)
        }
        pila.pop()
    }
    //Devolver los elementos a la lista original
    while (!pilaV.isEmpty) {
        pila.push(pilaV.peek())
        pilaV.pop()
    }
}

// Una clase que representa perros
data class Perro(val nombre: String, val raza: String, val edad: Int)

/**
 * Escriba una función que reciba una pila de perros y que retorne
 * una lista con los nombres de aquellos perros que tengan un nombre
 * que termine en vocal y cuya edad sea inferior a la edad que se
 * pasa como parámetro. La pila original no debe verse modificada.
 */
fun perrosMenoresEdad(perros: IStack<Perro>, edad: Int): List<String> {
    val dog=perros.copy()
    var dogList= mutableListOf<Perro>()
    var resultado=mutableListOf<String>()
    while (!dog.isEmpty) {
        val elem=dog.peek()
        dogList.add(elem)
        dog.pop()
    }
    for (p in dogList) {
        if (p.nombre.last()=='a' || p.nombre.last()=='e' || p.nombre.last()=='i'
            || p.nombre.last()=='o' || p.nombre.last()=='u'){
            if (p.edad<edad) {
                resultado.add(p.nombre)
            }
        }
    }
    return resultado
}

/**
 * Escriba esta función que reciba una pila de perros y que retorne
 * el perro más joven que pertenece a la raza que se pasa como
 * parámetro. La pila original no debe verse modificada, no puede
 * usarse listas ni funciones de orden superior. Si no hay perros
 * de esa raza, deberá retornarse null.
 */
fun perroMasJoven(perros: IStack<Perro>, raza: String): Perro? {
    val dogCopia=perros.copy()
    val dogV:IStack<Perro> = TLinkedStack()
    var MasJoven=Int.MAX_VALUE
    var doggy:Perro?=null
    while (!dogCopia.isEmpty) {
        val elem=dogCopia.peek()
        if (elem.raza == raza) {
            dogV.push(elem)
        }
        dogCopia.pop()
    }
    while (!dogV.isEmpty) {
        val elem2=dogV.peek()
        if (elem2.edad <= MasJoven) {
            MasJoven = elem2.edad
            doggy = elem2
        }
        dogV.pop()
    }
    return doggy
}
