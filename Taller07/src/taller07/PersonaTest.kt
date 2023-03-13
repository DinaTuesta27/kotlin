package taller07

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.FileReader
import java.io.Reader

class PersonaTest {
    // Atributos globales
    private val personas: MutableList<Persona> = mutableListOf()

    @BeforeEach
    fun setUp() {
        // Vamos a leer los archivos
        try {
            val datos: Reader = FileReader("./data/Personas.csv")
            val registros = CSVParser(datos, CSVFormat.DEFAULT.withHeader())
            for (registro in registros) {
                val cedula = registro["\uFEFFCédula"].toInt()
                val edad = registro["Edad"].toInt()
                val genero = if (registro["Genero"] == "0") "M" else "F"
                val hijos = registro["No de hijos"].toInt()
                val educacion = when (registro["Nivel Educativo"]) {
                    "1" -> "PRIMARIA"
                    "2" -> "SECUNDARIA"
                    "3" -> "PREGRADO"
                    "4" -> "POSTGRADO"
                    else -> "NINGUNO"
                }
                val estrato = registro["Estrato Socio"].toInt()
                val ingresos = registro["Ingresos"].toInt()
                val peso = registro["Peso"].toInt()
                val talla = registro["Talla"].toInt()
                val fuma = registro["Fuma"] == "1"
                val lentes = registro["Lentes"] == "1"
                val casa = registro["Casa propia"] == "1"
                val automovil = registro["Automovil"] == "1"
                val persona = Persona(
                    cedula,
                    edad,
                    genero,
                    hijos,
                    educacion,
                    estrato,
                    ingresos,
                    peso,
                    talla,
                    fuma,
                    lentes,
                    casa,
                    automovil
                )
                personas.add(persona)
            }
        }
        catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    @Test
    fun pruebaImpuestoPersona() {
        assertEquals(153600.0, personas[0].impuesto())
        assertEquals(282000.0, personas[1].impuesto())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContarMujeresConAutomovil() {
        assertEquals(142, contarMujeresConAutomovil(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio1a() {
        assertEquals(264, ejercicio1a(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio1b() {
        assertTrue { !ejercicio1b(personas) }
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio2a() {
        assertEquals(161_844_000, ejercicio2a(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio2b() {
        assertEquals(2636,  ejercicio2b(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3a() {
        assertEquals(40.8333, ejercicio3a(personas), 1e-4)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3b() {
        assertEquals(2_954_500.0, ejercicio3b(personas, "POSTGRADO"))
        assertEquals(2_199_000.0, ejercicio3b(personas, "PREGRADO"))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3c() {
        assertEquals(19.2678, ejercicio3c(personas), 1e-4)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaIMC() {
        assertEquals(18.1018, imc(personas[0]), 1e-4)
        assertEquals(22.7583, imc(personas[500]), 1E-4)
        assertEquals(33.0236, imc(personas[100]), 1E-4)
        assertEquals(25.5296, imc(personas[200]), 1E-4)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaNivelPeso() {
        assertEquals("Bajo peso", nivelPeso(personas[0]))
        assertEquals("Normal", nivelPeso(personas[500]))
        assertEquals("Obesidad", nivelPeso(personas[100]))
        assertEquals("Sobrepeso", nivelPeso(personas[200]))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3d() {
        assertEquals(40.70175, ejercicio3d(personas), 1e-5)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio4a() {
        assertEquals(1_085_422_030, ejercicio4a(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio4b() {
        assertEquals(1_099_918_021, ejercicio4b(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio05() {
        val lista = ejercicio05(personas)
        val expectedList = listOf<Int>(1853351201, 1689759974, 1472647510, 1097889222, 1025592419, 1256431417, 1987223851, 1850374094)
        assertEquals(lista.size, expectedList.size)
        assertEquals(setOf(lista), setOf(expectedList))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio05b() {
        val lista = ejercicio05b(personas)
        val cedulas = lista.map { it.cedula }
        val resp = listOf(1627524855, 1446673697, 1898711229, 1818187758, 1437152907, 1595097180)
        assertEquals(cedulas.size, resp.size)
        assertEquals(setOf(resp), setOf(cedulas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio06() {
        val rsp = ejercicio06(personas)
        assertEquals(3, rsp)
        println("Prueba superada ✔")
    }
}