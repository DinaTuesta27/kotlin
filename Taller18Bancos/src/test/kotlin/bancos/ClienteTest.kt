package bancos

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClienteTest {
    @Test
    fun pruebaGeneral() {
        val clnt1 = Cliente(1, 24, true)
        val clnt2 = Cliente(2, 67, false)

        assertEquals(0, clnt1.darSaldo())
        assertEquals(0, clnt2.darSaldo())

        assertFalse(clnt1.depositar(-5_000))
        assertTrue(clnt2.depositar(10_000))
        assertEquals(0, clnt1.darSaldo())
        assertEquals(10_000, clnt2.darSaldo())

        assertFalse(clnt2.depositar(-5_000))
        assertEquals(10_000, clnt2.darSaldo())
        assertTrue(clnt1.depositar(25_000))
        assertTrue(clnt1.depositar(35_000))
        assertFalse(clnt1.depositar(0))
        assertEquals(60_000, clnt1.darSaldo())
        println("Operaciones de depositar: prueba superada 👍🏼")

        assertFalse(clnt2.retirar(-50_000))
        assertFalse(clnt1.retirar(0))
        assertTrue(clnt1.retirar(24_000))
        assertEquals(36_000, clnt1.darSaldo())
        assertFalse(clnt1.retirar(100_000))
        assertEquals(36_000, clnt1.darSaldo())
        assertTrue(clnt2.retirar(3_000))
        assertEquals(7_000, clnt2.darSaldo())
        assertTrue(clnt2.retirar(10_000))
        assertEquals(-3_000, clnt2.darSaldo())
        assertTrue(clnt2.retirar(5_000))
        assertEquals(-8_000, clnt2.darSaldo())
        println("Operaciones de retirar: prueba superada 👍🏼")
    }
}