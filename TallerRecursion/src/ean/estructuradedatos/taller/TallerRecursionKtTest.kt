package ean.estructuradedatos.taller
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 18 de abril de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IList
import ean.collections.TList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TallerRecursionKtTest {

    @Test
    fun pruebaFactorial() {
        assertEquals(120, factorial(5))
        assertEquals(3628800, factorial(10))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaFibonacci() {
        assertEquals(89, fibonacci(11))
        assertEquals(75_025, fibonacci(25))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaElevar() {
        assertEquals(1024, elevar(2, 10))
        assertEquals(1_000_000, elevar(10, 6))
        println("Prueba superada 👍")
    }

    // Probar el triángulo de Pascal
    @Test
    fun pruebaPascal() {
        assertEquals(3, pascal(3,2))
        assertEquals(6, pascal(4,3))
        assertEquals(120, pascal(10, 8))
        assertEquals(5005, pascal(15, 7))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumatoria() {
        assertEquals(55, sumatoria(10))
        assertEquals(5050, sumatoria(100))
        assertEquals(500500, sumatoria(1000))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumaCuadrados() {
        assertEquals(1240, sumaCuadrados(15))
        assertEquals(9455, sumaCuadrados(30))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSerie() {
        assertEquals(3.4361, serie(1000), 0.0001)
        assertEquals(4.5869, serie(10_000), 0.0001)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumatoria2() {
        assertEquals(6.8136, sumatoria2(1_000), 1e-4)
        assertEquals(9.1157, sumatoria2(10_000), 1e-4)
        println("Prueba superada!")
    }

    @Test
    fun pruebaContarDigitos() {
        assertEquals(7, contarDigitos(1_215_677))
        assertEquals(1, contarDigitos(1))
        assertEquals(9, contarDigitos(865_711_981))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaNumeroDeCeros() {
        assertEquals(2, numeroDeCeros(2020))
        assertEquals(0, numeroDeCeros(19_278))
        assertEquals(6, numeroDeCeros(1_000_000))
        assertEquals(5, numeroDeCeros(10_100_001))
        assertEquals(1, numeroDeCeros(0))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumarDigitos() {
        assertEquals(15, sumarDigitos(5712))
        assertEquals(10, sumarDigitos(1234))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaEsMultiploDeTres() {
        assertTrue(esMultiploDe3(19_533))
        assertTrue(esMultiploDe3(27))
        assertTrue(esMultiploDe3(810))
        assertTrue(esMultiploDe3(333))
        assertFalse(esMultiploDe3(2_933))
        assertFalse(esMultiploDe3(1))
        assertFalse(esMultiploDe3(2))
        assertFalse(esMultiploDe3(17))
        assertFalse(esMultiploDe3(22))
        assertFalse(esMultiploDe3(32))
        println("Prueba superada 👍")
    }

    @Test
    fun probarCantidadDigitosPares() {
        assertEquals(4, cantidadDigitosPares(816_425))
        assertEquals(0, cantidadDigitosPares(73_911))
        assertEquals(6, cantidadDigitosPares(4_816_420))
        println("Prueba superada 👍")
    }

    @Test
    fun probarEsNumeroBinario() {
        assertTrue(esNumeroBinario(11))
        assertTrue(esNumeroBinario(1000110))
        assertFalse(esNumeroBinario(410))
        println("Prueba superada 👍")
    }

    @Test
    fun probarPoseeDigito() {
        assertTrue(poseeDigito(67_810, 7))
        assertTrue(poseeDigito(8_576, 8))
        assertFalse(poseeDigito(98_175, 4))
        println("Prueba superada 👍")
    }

    @Test
    fun probarDigitoMasGrande() {
        assertEquals(9, digitoMasGrande(17_928))
        assertEquals(1, digitoMasGrande(1_000))
        assertEquals(6, digitoMasGrande(26_403))
    }

    @Test
    fun pruebaMCD() {
        assertEquals(6, mcd(270, 192))
        assertEquals(8, mcd(72, 16))
        assertEquals(16, mcd(848, 656))
        println("Prueba superada 👍")
    }

    @Test
    fun probarImprimirLista() {
        imprimirLista(listOf(3, 1, 8, 6, 4, 2))
    }

    @Test
    fun probarDigitos() {
        assertEquals(listOf(3, 4, 2, 1, 9), digitos(34_219))
        assertEquals(listOf(8), digitos(8))
        assertEquals(listOf(2, 0, 0, 1, 3, 6), digitos(200_136))
        println("Prueba superada 👍")
    }

    @Test
    fun probarconvertirDecimalBinario() {
        assertEquals(listOf(1, 1, 1, 1), convertirDecimalBinario(15))
        assertEquals(listOf(1, 0, 0, 1, 1, 0, 1), convertirDecimalBinario(77))
        assertEquals(listOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), convertirDecimalBinario(1024))
        assertEquals(listOf(1, 1, 0, 1, 1, 0, 1, 0, 0, 1), convertirDecimalBinario(873))
        assertEquals(listOf(1, 0, 0, 0), convertirDecimalBinario(8))
        println("Prueba superada 👍")
    }

    @Test
    fun probarContarVerbos() {
        val pals = listOf("comer", "ando", "andar", "partir", "suma", "sumar", "reir", "ir", "dono", "poder")
        assertEquals(7, contarVerbos(pals))
        assertEquals(0, contarVerbos(listOf("nada", "come", "papa")))
        println("Prueba superada 👍")
    }

    @Test
    fun probarSumarParesLista() {
        assertEquals(30, sumarParesLista(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)))
        assertEquals(0, sumarParesLista(listOf(11, 21, 31, 41, 51, 61, 71)))
        assertEquals(34, sumarParesLista(listOf(4, 10, 12, 11, 15, 8)))
        println("Prueba superada 👍")
    }

    @Test
    fun probarbuscarElementoEnUnaLista() {
        assertEquals(2, buscarElementoEnUnaLista(listOf(40, 12, 18, 57, 1, 198, 43, 33, 12), 18))
        assertEquals(6, buscarElementoEnUnaLista(listOf(40, 12, 18, 57, 1, 198, 43, 33, 12), 43))
        assertEquals(-1, buscarElementoEnUnaLista(listOf(40, 12, 18, 57, 1, 198, 43, 33, 12), 6))
        println("Prueba superada 👍")
    }

    @Test
    fun probarConvertirListaDigitosNumero() {
        assertEquals(45_186, convertirListaDigitosNumero(listOf(4, 5, 1, 8, 6)))
        assertEquals(8, convertirListaDigitosNumero(listOf(8)))
        assertEquals(371_811, convertirListaDigitosNumero(listOf(3, 7, 1, 8, 1, 1)))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarExisteElemento() {
        assertTrue(existeElemento(listOf("hola", "casa", "tierra", "rojo", "azul"), "casa"))
        assertFalse(existeElemento(listOf("hola", "casa", "tierra", "rojo", "azul"), "perro"))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarInvertirLista() {
        val lst: List<Char> = listOf('p', 'a', 'r', 'c', 'o', 's')
        val inv: List<Char> = listOf('s', 'o', 'c', 'r', 'a', 'p')
        assertEquals(inv, invertirLista(lst))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarPalindrome() {
        assertTrue(esPalindrome("dabalearrozalazorraelabad"))
        assertTrue(esPalindrome("ablewasIereIsawelba"))
        assertFalse(esPalindrome("palindrome"))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarMayorDeUnaLista() {
        val lst: List<Int> = listOf(17, 8, -4, 30, 18, 180, 6, 2, 20)

        assertEquals(180, mayorDeUnaLista(lst))
        println("Prueba superada ☺️")
    }

    @Test
    fun probarPuntosPrimerCuadrante() {
        val lp: List<Punto> = listOf(Punto(3, 4), Punto(2, -1), Punto(-5, -10), Punto(5, 6), Punto (-2, 2))
        assertEquals(2, puntosPrimerCuadrante(lp).size)
        println("Prueba superada ☺️")
    }

    @Test
    fun probarPuntoMasLejano() {
        val lp: List<Punto> = listOf(Punto(3, 4), Punto(2, -1), Punto(-5, -10), Punto(5, 6), Punto (-2, 2))
        assertEquals(Punto(-5, -10), puntoMasLejano(lp))
        assertNull(puntoMasLejano(listOf()))
        println("Prueba superada ☺️")
    }
}