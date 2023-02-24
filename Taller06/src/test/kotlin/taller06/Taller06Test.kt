package taller06

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Taller06Test {
    private lateinit var e: Estudiante

    @BeforeEach
    fun setupTest() {
        e = Estudiante()
        e.cursos = listOf(
            Curso("VFP0012", "Algoritmos", "Sistemas", false, 3),
            Curso("ABC123", "Matematicas", "Ciencias", false, 4),
            Curso("HIS101", "Historia", "Sociales", false, 2),
            Curso("GEO100", "Geografia", "Sociales", false, 4),
            Curso("EAN001", "Emprendimiento", "Sociales", true, 1),
            Curso("EAN002", "Comunicacion", "Lenguas", false, 3),
            Curso("LAN001", "Ingles", "Lenguas", false, 3),
            Curso("CSC001", "Programacion", "Sistemas", false, 4),
            Curso("CSC002", "Bases de Datos", "Sistemas", true, 3),
            Curso("HIS102", "Cultura", "Sociales", false, 2),
            Curso("MAT004", "Geometria", "Ciencias", false, 4),
            Curso("FIS101", "Fisica", "Ciencias", false, 3),
            Curso("MAT008", "Aritmetica", "Ciencias", false, 4),
            Curso("FRA188", "Frances", "Lenguas", false, 3)
        )
        val notas = listOf(43.0, 0.0, 77.0, 84.0, 61.0, 91.5, 0.0, 58.0, 10.0, 90.0, 62.0, 83.0, 21.0, 65.0)
        e.cursos.forEachIndexed { i, curso ->
            curso.asignarNota(notas[i])
        }
    }

    @Test
    fun pruebaCurso() {
        val curso1 = Curso("VFP0012", "Algoritmos", "Sistemas", false, 3)
        val curso2 = Curso("AFP0012", "Calculo", "Matematica", false, 3)
        val curso3 = Curso("EST0110", "Bioestadistica", "Biologia", false, 4)
        val curso4 = Curso("ALG1100", "Metodologia", "Logistica", true, 3)

        assertEquals("Algoritmos", curso1.nombre)
        assertFalse(curso2.estaCalificado())
        println("Primera parte de la prueba superada 👍")

        curso3.asignarNota(0.5)
        assertFalse(curso3.estaCalificado())
        assertEquals(0.0, curso3.darNota())
        curso3.asignarNota(71.0)
        assertTrue(curso3.estaCalificado())
        println("Segunda parte de la prueba superada 👍")

        curso2.asignarNota(61.5)
        curso1.asignarNota(44.2)
        curso4.asignarNota(66.7)
        assertTrue(curso2.aproboCurso())
        assertFalse(curso1.aproboCurso())
        assertTrue(curso4.estaCalificado())
        assertFalse(curso4.aproboCurso())
        curso4.asignarNota(81.1)
        assertTrue(curso4.aproboCurso())
        println("Tercera parte de la prueba superada 👍")
    }

    @Test
    fun pruebaCursosCodigoPar() {
        assertEquals(7, e.cursosCodigoPar())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio02() {
        assertEquals(2, e.ejercicio02())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio03() {
        assertEquals(3, e.ejercicio03("Sistemas"))
        assertEquals(4, e.ejercicio03("Ciencias"))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio04() {
        assertEquals(7, e.ejercicio04())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio05() {
        assertEquals(1, e.ejercicio05("Ciencias"))
        assertEquals(0, e.ejercicio05("Lenguas"))
        assertEquals(2, e.ejercicio05("Sistemas"))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio06() {
        assertEquals(43, e.ejercicio06())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio07() {
        assertEquals(7, e.ejercicio07("Ciencias"))
        assertEquals(8, e.ejercicio07("Sociales"))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio08() {
        assertEquals(62.125, e.ejercicio08())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio09() {
        assertEquals(60.3472, e.ejercicio09(), 1e-4)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio10() {
        assertEquals(50.0, e.ejercicio10())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio11() {
        var curso = e.ejercicio11("EAN001")
        assertNotNull(curso)
        assertEquals("Emprendimiento", curso!!.nombre)

        curso = e.ejercicio11("CSC001")
        assertNotNull(curso)
        assertEquals("Programacion", curso!!.nombre)
        assertEquals("Sistemas", curso!!.carrera)

        curso = e.ejercicio11("EAN0XX")
        assertNull(curso)

        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio12() {
        assertEquals("", e.ejercicio12("Lenguas", 2))
        assertEquals("FIS101", e.ejercicio12("Ciencias", 3))
        assertEquals("GEO100", e.ejercicio12("Sociales", 4))
        println("Prueba superada 👍")
    }

}