/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Objetos Comparadores
 * Autor: EAN - 2 de mayo de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package taller16

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// Pruebas de comparadores
internal class PruebaComparadores {
    // Atributos de pruebas
    private val prod1: Producto = Producto("papa", 450.0, 5)
    private val prod2: Producto = Producto("arroz", 1300.0, 100)
    private val prod3: Producto = Producto("jamón", 7100.0, 20)
    private val prod4: Producto = Producto("arroz", 1200.5, 80)

    @Test
    fun pruebasCompararSuperHéroes() {
        val superman = SuperHéroe("Superman", 100, "Tierra 1")
        val batman1 = SuperHéroe("Batman", 43, "Tierra 1")
        val batman2 = SuperHéroe("Batman", 38, "Tierra 2")
        val arrow = SuperHéroe("Green Arrow", 21, "Tierra 1")
        val mujerMaravilla = SuperHéroe("Mujer Maravilla", 81, "Tierra 1")
        val vegeta = SuperHéroe("Vegeta", 21, "Capsule")

        // Pruebas
        assertTrue(superman > batman1)
        assertTrue(batman1 != batman2)
        assertTrue(arrow < mujerMaravilla)
        assertTrue(mujerMaravilla < vegeta )
        assertTrue(vegeta > superman)
    }

    // ------------------------------------------------------------------------------------

    // Pruebas de las clases Productos
    @Test
    fun prueba1() {
        assertTrue(prod1 < prod2)
        assertTrue(prod3 > prod3)
    }

    @Test
    fun prueba2() {
        val cmp = ComparadorDeProductosPorNombre()
        assertTrue(cmp.compare(prod1, prod2) > 0)
    }

    @Test
    fun prueba3() {
        assertTrue(ComparadorPorNombreYPrecio.compare(prod2, prod3) < 0 )
        assertTrue(ComparadorPorNombreYPrecio.compare(prod2, prod4) > 0)
    }

    @Test
    fun prueba4() {
        assertTrue(ComparadorPorCantidad.compare(prod1, prod2) < 0)
        assertTrue(ComparadorPorCantidad.compare(prod2, prod3) > 0)
    }

    @Test
    fun pruebaReloj1() {
        val r1 = Reloj()
        val r2 = Reloj(14, 21, 9)

        println(r1.toAMPMString())

        assertEquals("14:21:09", r2.toString())
        assertEquals("02:21:09 PM", r2.toAMPMString())
    }

    @Test
    fun pruebaReloj2() {
        val r1 = Reloj()
        val r2 = Reloj(14, 21, 9)
        val r3 = Reloj(14, 21, 59)
        val r4 = Reloj(14, 21, 59)
        val mn = Reloj(23, 59, 59)
        val cero = Reloj(0, 0, 0)
        val md = Reloj(12, 0, 0)

        assertTrue(r1 < mn)
        assertTrue(r3 == r4)
        assertNotSame(r3, r4)

        assertTrue(r3 > r2)

        r4.avanzarUnSegundo()
        assertTrue(r4 == Reloj(14, 22, 0))

        r2.avanzarUnSegundo()
        assertTrue(r2.hora == 14 && r2.minutos == 21 && r2.segundos == 10)

        assert(md < mn)

        md.retrocederUnSegundo()
        assertTrue(md.hora == 11 && md.minutos == 59 && md.segundos == 59)

        assertTrue(mn > cero)
        mn.avanzarUnSegundo()
        assertTrue(mn == cero)
        cero.retrocederUnSegundo()
        assertTrue(mn < cero)

        println("Prueba superada ✔")
    }
}