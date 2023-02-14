/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 *
 * Unidad de Estudios: Estructura de Datos
 * Pruebas del Taller: 01
 * Fecha: 1 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller01

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.Math.toRadians

class Taller01KtTest {

    @Test
    fun pruebaEjercicio01() {
        var res = ejercicio01(80.0, 70.0, 20.0)
        assertEquals(69.0, res, 0.01)
        res = ejercicio01(30.0, 45.0, 85.0)
        assertEquals(43.0, res, 0.01)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio02() {
        var res = ejercicio02(78.5)
        assertEquals(37.68, res, 0.01)
        res = ejercicio02(277.1)
        assertEquals(133.008, res, 0.001)
        res = ejercicio02(1678.25)
        assertEquals(805.56, res, 0.001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio03() {
        var res = ejercicio03(3.0, 4.0)
        assertEquals(49.0, res, 0.01)
        res = ejercicio03(-5.0, 8.0)
        assertEquals(9.0, res, 0.01)
        res = ejercicio03(4.75, 2.15)
        assertEquals(47.61, res, 0.01)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio04() {
        var res = ejercicio04(3.0, 4.0)
        assertEquals(Pair(12.0, 14.0), res)
        res = ejercicio04(18.0, 73.0)
        assertEquals(Pair(1314.0, 182.0), res)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio05() {
        var res = ejercicio05(2, 10, 60)
        assertEquals(1, res)
        res = ejercicio05(20, 38, 30)
        assertEquals(3, res)
        res = ejercicio05(75, 166, 20)
        assertEquals(16, res)
        res = ejercicio05(70, 20, 40)
        assertEquals(4, res)
        res = ejercicio05(70, 21, 40)
        assertEquals(5, res)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio06() {
        var res = ejercicio06(4.0, toRadians(30.0))
        assertEquals(8.0, res, 0.01)
        res  = ejercicio06(3.0, toRadians(45.0))
        assertEquals(4.2426, res, 0.0001)
        res = ejercicio06(12.0, toRadians(33.333333))
        assertEquals(21.8377, res, 0.0001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio07() {
        var res = ejercicio07(1_000_000.0)
        assertEquals(Triple(400000.0, 150000.0, 450000.0), res)
        res = ejercicio07(200_000.0)
        assertEquals(Triple(80000.0, 30000.0, 90000.0), res)
        res = ejercicio07(75_000.0)
        assertEquals(Triple(30000.0, 11250.0, 33750.0), res)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio08() {
        var res = ejercicio08(10.0, 8.0)
        var p = res.first
        var h = res.second
        var A = res.third
        assertEquals(28.0, p)
        assertEquals(9.1651, h, 0.0001)
        assertEquals(36.6606, A, 0.0001)

        res = ejercicio08(38.0, 12.0)
        p = res.first
        h = res.second
        A = res.third
        assertEquals(88.0, p)
        assertEquals(37.5233, h, 0.0001)
        assertEquals(225.1399, A, 0.0001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio09() {
        assertEquals(314.1592, ejercicio09(10.0), 0.0001)
        assertEquals(63.6172, ejercicio09(4.5), 0.0001)
        assertEquals(1385.4423, ejercicio09(21.0), 0.0001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio10() {
        assertEquals(43.9822, ejercicio10(2.5, 4.5), 0.0001)
        assertEquals(251.3274, ejercicio10(8.0, 12.0), 0.0001)
        assertEquals(1711.6339, ejercicio10(15.1, 27.8), 0.0001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio11() {
        assertEquals(33 to 20, ejercicio11(25, 4, 20))
        assertEquals(8 to 20, ejercicio11(10, 5, 10))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio12() {
        assertEquals("Juan",
            ejercicio12("Pedro", 15,
                "Juan", 18,
                "Sandra", 12))
        assertEquals("Diana",
            ejercicio12("Diana", 54,
                "Beatriz", 50,
                "Eliana", 45))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio13() {
        assertEquals(Pair(100002.5, 2100052.5), ejercicio13(2_000_050.0))
        assertEquals(Pair(25000.0, 275000.0), ejercicio13(250_000.0))
        assertEquals(Pair(73760.0, 995760.0), ejercicio13(922_000.0))
        assertEquals(Pair(200.0, 2200.0), ejercicio13(2_000.0))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEjercicio14() {
        assertFalse(ejercicio14(1900))
        assertTrue(ejercicio14(1904))
        assertFalse(ejercicio14(1983))
        assertTrue(ejercicio14(2000))
        assertFalse(ejercicio14(2023))
        assertTrue(ejercicio14(2024))
        assertFalse(ejercicio14(2100))
        assertTrue(ejercicio14(2104))
        println("Prueba superada 👍")
    }
}