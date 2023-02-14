package taller02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumeroComplejoTest {
    @Test
    fun prueba1() {
        val num1 = NumeroComplejo(3.0, 4.0)
        assertEquals(5.0, num1.valorAbsoluto(), 0.1)
        println("Prueba superada")
    }

    @Test
    fun prueba2() {
        val numc = NumeroComplejo(5.0, 4.0)
        assertEquals(0.67474, numc.argumento(), 1e-5)
        println("Prueba superada")
    }

    @Test
    fun prueba3() {
        var num = NumeroComplejo(-3.0, -2.0)
        var inv = num.inverso()
        assertEquals(-0.23, inv.parteReal, 1e-2)
        assertEquals(0.15, inv.parteImaginaria, 1e-2)

        num = NumeroComplejo(2.0, 1.0)
        inv = num.inverso()
        assertEquals(0.4, inv.parteReal)
        assertEquals(-0.2, inv.parteImaginaria)

        println("Prueba superada")
    }

    @Test
    fun prueba5() {
        val num = NumeroComplejo(3.0, 4.0)
        num.productoPorEscalar(-5.0)
        assertEquals(-15.0, num.parteReal)
        assertEquals(-20.0, num.parteImaginaria)
        println("Prueba superada")
    }

    @Test
    fun prueba4() {
        val a = NumeroComplejo(3.0, 4.0)
        val b = NumeroComplejo(-1.0, 8.1)
        val c = sumarNumComplejos(a, b)
        assertEquals(2.0, c.parteReal)
        assertEquals(12.1, c.parteImaginaria)
        println("Prueba superada")
    }
}