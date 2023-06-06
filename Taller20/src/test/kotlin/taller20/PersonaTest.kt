package taller20

import ean.colecciones.Lista
import ean.colecciones.crearLista
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.FileInputStream

class PersonaTest {
    // función para leer el archivo de personas
    private fun leerArchivoPersonas(): Lista<Persona> {
        val reader = FileInputStream("./data/Personas.csv").bufferedReader()
        val header = reader.readLine()
        val lista = reader.lineSequence()
            .filter { it.isNotBlank() }
            .map {
                val linea = it.split(',', ignoreCase = false, limit = 13)
                Persona(linea[0].trim().toInt(), linea[1].trim().toInt(), if (linea[2] == "0") 'H' else 'M',
                    linea[3].trim().toInt(),
                    when (linea[4]) {
                        "1" -> "PREESCOLAR"
                        "2" -> "PRIMARIA"
                        "3" -> "SECUNDARIA"
                        "4" -> "UNIVERSITARIA"
                        else -> "POSGRADO"
                    },
                    linea[5].trim().toInt(),
                    linea[6].trim().toInt(),
                    linea[7].trim().toInt(),
                    linea[8].trim().toInt(),
                    linea[9].trim() == "1",
                    linea[10].trim() == "1",
                    linea[11].trim() == "1",
                    linea[12].trim() == "1")
            }.toList()
        val resp = crearLista<Persona>()
        for (pers in lista) {
            resp.agregarAlFinal(pers)
        }
        return resp
    }

    private fun <T> similares(a: Lista<T>, b: Lista<T>): Boolean {
        if (a.tam != b.tam) {
            return false
        }
        return a.contieneLista(b)
    }

    @Test
    fun pruebaClasePersonas() {
        val personas = leerArchivoPersonas()
        assertEquals(18.1018, personas[0].IMC(), 1e-4)
        assertEquals("bajo peso", personas[0].nivelDePeso().lowercase())
        assertEquals(31.0476, personas[262].IMC(), 1e-4)
        assertEquals("obesidad", personas[262].nivelDePeso().lowercase())
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio1() {
        val personas = leerArchivoPersonas()
        assertEquals(262, ejercicio1(personas))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio2() {
        val personas = leerArchivoPersonas()
        val cedulas = ejercicio2(personas).ordenar { it }
        assertEquals(cedulas.tam, 3)
        assertEquals(1538042950, cedulas[0])
        assertEquals(1762165104, cedulas[1])
        assertEquals(1839033016, cedulas[2])
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio3() {
        val personas = leerArchivoPersonas()
        assertEquals(2, ejercicio3(personas))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio4() {
        val personas = leerArchivoPersonas()
        assertEquals(71011000, ejercicio4(personas, "PRIMARIA"))
        assertEquals(46193000, ejercicio4(personas, "SECUNDARIA"))
        assertEquals(65012000, ejercicio4(personas, "UNIVERSITARIA"))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio5() {
        val personas = leerArchivoPersonas()
        assertFalse(ejercicio5(personas, 1_000_000))
        assertTrue(ejercicio5(personas, 2_000_000))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio6() {
        val personas = leerArchivoPersonas()
        assertFalse(ejercicio6(personas))
        val mujeres = personas.filtrar { it.genero == 'M' }
        assertFalse(ejercicio6(mujeres))
        val hombres = personas.filtrar { it.genero == 'H' && it.nivelDePeso().lowercase() == "sobrepeso" }
        assertFalse(ejercicio6(hombres))
        val otros = hombres.filtrar { it.edad <= 33 }
        assertFalse(ejercicio6(otros))
        val final = otros.filtrar { it.edad >= 24 }
        assertTrue(ejercicio6(final))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio7() {
        val personas = leerArchivoPersonas()
        var res1 = ejercicio7(personas, personas[350].cedula)
        var resp = crearLista(1972303058, 1914652979, 1574512933, 1477645257, 1511863977, 1711493602)
        assertTrue(similares(resp, res1))
        println("Primera prueba superada 👍🏼")

        res1 = ejercicio7(personas, personas[100].cedula)
        resp = crearLista(1972303058, 1914652979, 1574512933, 1477645257, 1511863977, 1711493602, 1370607441)
        assertTrue(similares(resp, res1))

        println("Segunda prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio8() {
        val personas = leerArchivoPersonas()
        assertFalse(ejercicio8(personas))
        var lst1 = personas.filtrar { it.usaLentes }
        assertFalse(ejercicio8(lst1))
        lst1 = lst1.filtrar { it.genero == 'H' }
        assertTrue(ejercicio8(lst1))
        println("Prueba superada 👍🏼")
    }

    @Test
    fun pruebaEjercicio9() {
        val personas = leerArchivoPersonas()
        assertTrue(ejercicio9(personas))
        val otros = personas.filtrar { it.ingresos < 1_000_000 }
        assertFalse(ejercicio9(otros))
        println("Prueba superada 👍🏼")
    }

}