package taller17

import ean.colecciones.Lista
import ean.colecciones.crearLista
import ean.colecciones.listaVacia
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.util.*

class Talle17Test {
    private fun cargarAspirantes(): Lista<Aspirante> {
        val archivo: String = "./data/aspirantes.dat"
        val bolsa: Lista<Aspirante> = listaVacia()
        try {
            val fis = FileInputStream(File(archivo))
            val properties = Properties()
            properties.load(fis)

            var dato: String
            var nombre: String
            var profesion: String
            var experiencia: Int
            var edad: Int
            var telefono: String

            dato = "total.aspirantes"
            var aux = properties.getProperty(dato)
            val cantidad = aux.toInt()

            for (cont in 1..cantidad) {
                // Carga un aspirante
                dato = "aspirante${cont}.nombre"
                nombre = properties.getProperty(dato);

                dato = "aspirante${cont}.profesion";
                profesion = properties.getProperty(dato);

                dato = "aspirante${cont}.experiencia";
                aux = properties.getProperty(dato);
                experiencia = Integer.parseInt(aux);

                dato = "aspirante${cont}.edad";
                aux = properties.getProperty(dato);
                edad = Integer.parseInt(aux);

                dato = "aspirante${cont}.telefono";
                telefono = properties.getProperty(dato);

                val aspirante = Aspirante(nombre, profesion, experiencia, edad, telefono)
                bolsa.agregarAlFinal(aspirante)
            }
            fis.close()
        }
        catch (e: FileNotFoundException) {
            println("No se encontró el archivo con la información de los aspirantes")
        }
        catch (e: IOException) {
            println("El archivo con los aspirantes no tiene el formato adecuado")
        }
        return bolsa
    }

    private fun <T : Comparable<T>> estaOrdenada(lista: Lista<T>): Boolean {
        for (i in 0 until lista.tam - 1) {
            if (lista[i] > lista[i + 1]) {
                return false
            }
        }
        return true
    }

    private fun <T> estaOrdenada(lista: Lista<T>, comp: Comparator<T>): Boolean {
        for (i in 0 until lista.tam - 1) {
            if (comp.compare(lista[i], lista[i + 1]) > 0) {
                return false
            }
        }
        return true
    }

    //-----------------------------------------------------------------------------------
    // Pruebas iniciales
    //-----------------------------------------------------------------------------------
    @Test
    fun pruebaBurbuja() {
        val lista = crearLista(11, 8, 1, 4, 21, 32, 6, 14, 9, 2)
        assertFalse(estaOrdenada(lista))
        bubbleSort(lista)
        assertTrue(estaOrdenada(lista))
        println(lista)
        print("Prueba superada ✔")
    }

    @Test
    fun pruebaBusquedaBinaria() {
        val lista = crearLista(11, 8, 1, 4, 21, 32, 6, 14, 9, 2)
        bubbleSort(lista)

        assertEquals(0, busquedaBinaria(lista, 1))
        assertEquals(9, busquedaBinaria(lista, 32))
        assertEquals(5, busquedaBinaria(lista, 9))
        assertEquals(-1, busquedaBinaria(lista, 20))

        println("Prueba superada ✔")
    }


    //-----------------------------------------------------------------------------------
    // Pruebas de los diversos algoritmos
    //-----------------------------------------------------------------------------------

    @Test
    fun pruebaBuscarAspirante() {
        val bolsa = cargarAspirantes()

        assertEquals(5, buscarAspirante(bolsa, "Ana Rojas"))
        assertEquals(8, buscarAspirante(bolsa, "Manuel Calvo"))
        assertEquals(-1, buscarAspirante(bolsa, "Radamel Falcao"))

        println("Prueba superada ✔")
    }

    @Test
    fun pruebaOrdenarPorNombre() {
        val bolsa = cargarAspirantes()
        ordenarPorNombre(bolsa)
        assertTrue(estaOrdenada(bolsa, compareBy<Aspirante>(Aspirante::nombre)))
        for (i in bolsa.indices) {
            val a = bolsa[i]
            println("${i + 1}. - ${a.nombre}")
        }
    }

    @Test
    fun pruebaOrdenarPorEdad() {
        val bolsa = cargarAspirantes()
        ordenarPorEdad(bolsa)
        assertTrue(estaOrdenada(bolsa, compareBy<Aspirante>(Aspirante::edad)))
        for (i in bolsa.indices) {
            val a = bolsa[i]
            println("${i + 1}. - ${a.nombre}")
        }
    }

    @Test
    fun pruebaOrdenarPorAñosDeExperiencia() {
        val bolsa = cargarAspirantes()
        ordenarPorAñosDeExperiencia(bolsa)
        assertTrue(estaOrdenada(bolsa, compareBy<Aspirante>(Aspirante::añosExperiencia)))
        for (i in bolsa.indices) {
            val a = bolsa[i]
            println("${i + 1}. - ${a.nombre}")
        }
    }

    @Test
    fun pruebaOrdenarPorProfesion() {
        val bolsa = cargarAspirantes()
        ordenarPorProfesion(bolsa)
        assertTrue(estaOrdenada(bolsa, compareBy<Aspirante>(Aspirante::profesion)))
        for (i in bolsa.indices) {
            val a = bolsa[i]
            println("${i + 1}. - ${a.nombre}")
        }
    }

    @Test
    fun pruebaMergeSort() {
        val bolsa = cargarAspirantes()
        ordenarPorNombreConMergeSort(bolsa)
        assertTrue(estaOrdenada(bolsa, compareBy<Aspirante>(Aspirante::nombre)))
        for (i in bolsa.indices) {
            val a = bolsa[i]
            println("${i + 1}. - ${a.nombre}")
        }
    }

    @Test
    fun pruebaQuickSort() {
        val bolsa = cargarAspirantes()
        ordenarPorNombreConQuickSort(bolsa)
        assertTrue(estaOrdenada(bolsa, compareBy<Aspirante>(Aspirante::nombre)))
        for (i in bolsa.indices) {
            val a = bolsa[i]
            println("${i + 1}. - ${a.nombre}")
        }
    }


    @Test
    fun pruebaBuscarAspirante2() {
         val bolsa = cargarAspirantes()
         ordenarPorNombre(bolsa)
         assertEquals(0, buscarBinarioPorNombre(bolsa, "Ana Rojas"))
         assertEquals(5, buscarBinarioPorNombre(bolsa, "Manuel Calvo"))
         assertEquals(-1, buscarBinarioPorNombre(bolsa, "Radamel Falcao"))
         println("Prueba superada ✔")
    }

    @Test
    fun pruebaBuscarAspiranteMasJoven() {
        val bolsa = cargarAspirantes()

        val masJoven = buscarAspiranteMasJoven(bolsa)
        assertEquals(5, masJoven)
        assertEquals(-1, buscarAspiranteMasJoven(listaVacia()))

        println("Prueba superada ✔")
    }

    @Test
    fun pruebabuscarAspiranteMayorExperiencia() {
        val bolsa = cargarAspirantes()

        val masExperimentado = buscarAspiranteMayorExperiencia(bolsa)
        assertEquals(8, masExperimentado)
        assertEquals(-1, buscarAspiranteMayorExperiencia(listaVacia()))

        println("Prueba superada ✔")
    }
}