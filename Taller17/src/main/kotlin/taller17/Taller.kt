/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas
 * Basado en el Proyecto Cupi2 de Uniandes
 *
 * Taller de Ordenamiento
 * Fecha: 18 de mayo de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package taller17

import ean.colecciones.Lista
import ean.colecciones.listaVacia

/**
 * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
 * Complejidad: O(n^2)
 */
fun bubbleSort(a: Lista<Int>): Unit {
    val n = a.tam
    repeat(n){
        for (j in 0 until n -1) {
            if (a[j] > a[j+1]) {
                val aux = a[j+1]
                a[j+1] = a[j]
                a[j] = aux
            }
        }
    }
}

/**
 * Desarrolle la busqueda binaria del elemento en la lista a
 */
fun busquedaBinaria(a: Lista<Int>, elem: Int): Int {
    var ini = 0
    var fin = a.tam - 1
    while (ini <= fin) {
        val mitad = (ini + fin)/2
        when{
            a[mitad] == elem ->return mitad
            a[mitad] > elem -> fin = mitad -1
            a[mitad] < elem -> ini = mitad + 1
        }
    }
    return -1
}

/**
 * Información de un aspirante a un empleo en una bolsa de empleo
 */
data class Aspirante(val nombre: String,
                     val profesion: String,
                     val añosExperiencia: Int,
                     val edad: Int,
                     val telefono: String) : Comparable<Aspirante> {
    override fun compareTo(other: Aspirante): Int = this.nombre.compareTo(other.nombre)
}

/**
 * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra.
 * Si no se encuentra ningún aspirante con ese nombre se retorna -1.
 * Utilice la búsqueda lineal típica
 */
fun buscarAspirante(lista: Lista<Aspirante>, nombre: String): Int {
    //Busqueda lineal
    for (i in 0 until lista.tam) {
        if (lista[i].nombre == nombre) {
            return i
        }
    }
    //Si no existe el nombre
    return -1
}

/**
 * Busca un aspirante según su nombre, utilizando una búsqueda binaria.
 * Si no se encuentra ningún aspirante con ese nombre se retorna -1.
 * OJO: la lista de aspirantes ya está ordenada, puede confiar en eso
 */
fun buscarBinarioPorNombre(lista: Lista<Aspirante>, nombre: String): Int {
    var ini=0
    var fin= lista.tam - 1
    while (ini <= fin) {
        val mitad=(ini + fin)/2
        if (lista[mitad].nombre == nombre) {
            return mitad
        }
        //lista[mitad].nombre > nombre
        if (lista[mitad].nombre > nombre) {
            fin= mitad - 1
        }else {
            ini= mitad + 1
        }
    }
    //Si no existe
    return -1
}

/**
 * Ordena la lista de aspirantes por nombre usando el algoritmo de burbuja
 */
fun ordenarPorNombre(aspirantes: Lista<Aspirante>) {
    for (i in 0 until aspirantes.tam) {
        for (j in 0 until aspirantes.tam - 1) {
            if (aspirantes[j] > aspirantes[j+1]) {
                //se intercambian los datos
                val aux=aspirantes[j+1]
                aspirantes[j+1] = aspirantes[j]
                aspirantes[j] = aux
            }
        }
    }
}

/**
 * Ordena la lista de aspirantes por edad usando el algoritmo de selección
 */
fun ordenarPorEdad(aspirantes: Lista<Aspirante>) {
    for (i in 0 until aspirantes.tam) {
        var menor = aspirantes[i]
        var posMenor = i
        //Busca posición del menor de i en adelante
        for (j in i + 1 until aspirantes.tam) {
            if (aspirantes[j].edad < menor.edad) {
                menor = aspirantes[j]
                posMenor = j
            }
        }
        //Después de hallar la posición del menor, se intercambia con la pos de i
        val aux = aspirantes[i]
        aspirantes[i] = menor
        aspirantes[posMenor] = aux
    }
}

/**
 * Ordena la lista de aspirantes por profesión utilizando el algoritmo de inserción
 */
fun ordenarPorAñosDeExperiencia(aspirantes: Lista<Aspirante>) {
    for (i in 1 until aspirantes.tam) {
        for (j in 0 until aspirantes.tam - 1) {
            //elem: elemento que se pasa de la zona desordenada a la ordenada
            val elem= aspirantes[i].añosExperiencia
            var j= i-1
            // reemplazar los elementos a la derecha y ordenarlos con el elem
            while (j >= 0 && elem < aspirantes[j].añosExperiencia) {
                aspirantes[j+1] = aspirantes[j]
                j--
            }
            //Guardar el elemento en el lugar que le corresponde
            //elem=aspirantes[i]
            aspirantes[j+1]=aspirantes[i]
        }
    }
}

/**
 * Ordena la lista de aspirantes por profesión usando el algoritmo de ordenamiento shell sort
 */
fun ordenarPorProfesion(aspirantes: Lista<Aspirante>) {
    val n=aspirantes.tam
    var salto = n
    var ordenado:Boolean
    while (salto > 1) {
        salto /= 2
        do {
            ordenado = true
            for (j in 0 until n - salto) {
                val k= j + salto
                if (aspirantes[j].profesion > aspirantes[k].profesion) {
                    val temp = aspirantes[j]
                    aspirantes[j] = aspirantes[k]
                    aspirantes[k] = temp
                    ordenado = false
                }
            }

        } while(!ordenado)
    }
}

/**
 * Ordena la lista de aspirantes por nombre utilizando el algoritmo de ordenamiento merge sort
 */
fun ordenarPorNombreConMergeSort(a: Lista<Aspirante>) {
    /**
     * Obtiene los elementos de la lista ubicados en la mitad inferior de la misma
     * es decir, en las posiciones desde la cero hasta la mitad de la lista
     */
    fun obtenerMitadInferior(lista: Lista<Aspirante>): Lista<Aspirante> {
        val nuevl= listaVacia<Aspirante>()
        // de 0 hasta la mitad.
        for (i in 0 until lista.tam/2) {
            nuevl.agregarAlFinal(lista[i])
        }
        return nuevl
    }

    /**
     * Obtiene los elementos de la lista ubicados en la mitad superior de la misma
     * es decir, en las posiciones desde la mitad + 1 hasta el final de la lista
     */
    fun obtenerMitadSuperior(lista: Lista<Aspirante>): Lista<Aspirante> {
        val list= listaVacia<Aspirante>()
        //desde la mitad hasta el final de la lista
        //a la mitad se le suma 1 para que pase al siguiente y no vuelva a tomar el de la mitad
        for (i in (list.tam/2)+1 until lista.tam) {
            list.agregarAlFinal(lista[i])
        }
        return list
    }

    /**
     * Retorna la mezcla ordenada de las listas a y b, usando el nombre como criterio
     */
    fun mezclarListas(a: Lista<Aspirante>, b: Lista<Aspirante>): Lista<Aspirante> {
        var i=0
        var j=0
        //Lista
        val m= listaVacia<Aspirante>()
        while (i < a.tam && j < b.tam) {
            if (a[i].nombre <= b[j].nombre) {
                // agregar al final de la lista al menor
                m.agregarAlFinal(a[i])
                i++
            }else{
                m.agregarAlFinal(b[j])
                j++
            }
        }
        while (i < a.tam) {
            m.agregarAlFinal(a[i])
            i++
        }
        while (j < b.tam) {
            m.agregarAlFinal(b[j])
            j++
        }
        return m
    }

    //------------------------------------------------------------------------------
    // Función Principal del MergeSort
    //------------------------------------------------------------------------------
    if (a.tam >= 2) {
        if (a.tam == 2) {
            if (a[0].nombre > a[1].nombre) {
                //aunque se busque con el nombre el intercambio
                //permanece normal
                val temp = a[0]
                a[0] = a[1]
                a[1] = temp
            }
        }
        else {
            // Algoritmo MergeSort.

            // 1. Particione la lista en dos mitades
            val p: Lista<Aspirante> = obtenerMitadInferior(a)
            val q: Lista<Aspirante> = obtenerMitadSuperior(a)

            // 2. ordene cada mitad usando mergesort
            ordenarPorNombreConMergeSort(p)
            ordenarPorNombreConMergeSort(q)

            // 3. Mezcle las dos listas ordenadas y copielas a la lista de resultado
            val resultado = mezclarListas(p, q)
            a.limpiar()
            a.agregarLista(resultado)
        }
    }
}

/**
 * Ordene la lista de aspirantes por nombre utilizando el algoritmo de ordenamiento quick sort
 */
fun ordenarPorNombreConQuickSort(lista: Lista<Aspirante>) {
    /**
     * Obtener los aspirantes que tengan un nombre inferior al pivote en la lista a
     */
    fun menoresAlPivote(a: Lista<Aspirante>, pivote: Aspirante): Lista<Aspirante> {
        val result= listaVacia<Aspirante>()
        for (i in 0 until a.tam) {
            if (lista[i].nombre < pivote.nombre) {
                result.agregarAlPrincipio(lista[i])
            }
        }
        return result
    }

    /**
     * Obtener los aspirantes que tengan un nombre superior al pivote en la lista a
     */
    fun mayoresAlPivote(a: Lista<Aspirante>, pivote: Aspirante): Lista<Aspirante> {
        val result= listaVacia<Aspirante>()
        for (i in 0 until a.tam) {
            if (lista[i].nombre > pivote.nombre) {
                result.agregarAlFinal(lista[i])
            }
        }
        return result
    }

    //-----------------------------------------------------------------
    // Función Principal
    //-----------------------------------------------------------------
    if (lista.tam >= 2) {
        if (lista.tam == 2) {
            if (lista[0] > lista[1]) {
                // intercambie los elementos a[0] y a[1]"
                val temp = lista[0]
                lista[0] = lista[1]
                lista[1] = temp
            }
        }
        else {
            // Algoritmo QuickSort

            // 1. Obtener el pivote, en este caso puede ser el nombre del primer elemento
            val pivote = lista[0]

            // 2. Obtener los menores y los mayores al pivote
            val mayores = mayoresAlPivote(lista, pivote)
            val menores = menoresAlPivote(lista, pivote)

            // 3. Ordene estas dos ultimas listas usando el quicksort
            ordenarPorNombreConQuickSort(mayores)
            ordenarPorNombreConQuickSort(menores)

            // 4. Ahora pegamos los pedazos junto con el pivote
            lista.limpiar()
            lista.agregarLista(menores)
            lista.agregarAlFinal(pivote)
            lista.agregarLista(mayores)
        }
    }
}

/**
 * Se retornó la posición donde se encuentra el aspirante más joven.
 * Si no hay aspirantes en la lista se retornó -1
 */
fun buscarAspiranteMasJoven(aspirantes: Lista<Aspirante>): Int {
    //Buscar Posición en lista
    if (aspirantes.tam == 0) {
        return -1
    } else {
        var posMenorFinal=0
        for (i in 0 until aspirantes.tam) {
            var menor = aspirantes[i]
            var posMenor = i
            //Busca posición del menor de i en adelante
            for (j in i + 1 until aspirantes.tam) {
                if (aspirantes[j].edad < menor.edad) {
                    menor = aspirantes[j]
                    posMenor = j
                    posMenorFinal=posMenor
                }
            }
        }
            return posMenorFinal
    }
}

/**
 * Se retornó la posición donde se encuentra el aspirante con mayor experiencia.
 * Si no hay aspirantes en la bolsa se retornó -1
 */
fun buscarAspiranteMayorExperiencia(aspirantes: Lista<Aspirante>): Int {
    if (aspirantes.tam == 0) {
        return -1
    } else {
        var posMayorExp=0
        for (i in 0 until aspirantes.tam) {
            var mayor = aspirantes[i]
            var posMayor = i
            //Busca posición del menor de i en adelante
            for (j in i + 1 until aspirantes.tam) {
                if (aspirantes[j].añosExperiencia > mayor.añosExperiencia) {
                    mayor = aspirantes[j]
                    posMayor = j
                    posMayorExp=posMayor
                }
            }
        }
        return posMayorExp
    }
}