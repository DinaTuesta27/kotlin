package bancos

import ean.colecciones.crearLista
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BancoTest {
    @Test
    fun pruebaAbrirCuenta() {
        val banco = Banco()

        assertEquals(0, banco.darCantidadClientes())
        assertTrue(banco.abrirCuenta(1, 21, true))
        assertTrue(banco.abrirCuenta(2, 17, true))
        assertTrue(banco.abrirCuenta(3, 23, false))
        assertEquals(3, banco.darCantidadClientes())
        assertFalse(banco.abrirCuenta(2, 34, false))
        assertEquals(3, banco.darCantidadClientes())
        assertTrue(banco.abrirCuenta(4, 34, false))
        assertEquals(4, banco.darCantidadClientes())
        println("Prueba superada ☺️")
    }

    @Test
    fun pruebaDepositar() {
        val banco = Banco()
        assertTrue(banco.abrirCuenta(1, 24, true))
        assertTrue(banco.abrirCuenta(2, 67, false))
        assertFalse(banco.abrirCuenta(2, 37, true))
        assertEquals(2, banco.darCantidadClientes())

        var clnt1 = banco.darCliente(1)
        assertNotNull(clnt1)
        assertEquals(1, clnt1!!.cedula)

        var clnt2 = banco.darCliente(2)
        assertNotNull(clnt2)
        assertEquals(2, clnt2!!.cedula)

        assertEquals(0, clnt1.darSaldo())
        assertEquals(0, clnt2.darSaldo())

        assertFalse(banco.depositarDineroCuentaCliente(1, -5_000))
        assertTrue(banco.depositarDineroCuentaCliente(2, 10_000))
        clnt1 = banco.darCliente(1)!!
        clnt2 = banco.darCliente(2)!!
        assertEquals(0, clnt1.darSaldo())
        assertEquals(10_000, clnt2.darSaldo())

        assertFalse(banco.depositarDineroCuentaCliente(2, -5_000))
        clnt2 = banco.darCliente(2)!!
        assertEquals(10_000, clnt2.darSaldo())
        assertTrue(banco.depositarDineroCuentaCliente(1, 25_000))
        assertTrue(banco.depositarDineroCuentaCliente(1, 35_000))
        assertFalse(banco.depositarDineroCuentaCliente(1, 0))
        clnt1 = banco.darCliente(1)!!
        assertEquals(60_000, clnt1.darSaldo())
        println("Deposita: prueba superada 👍🏼")
    }

    @Test
    fun pruebaRetirar() {
        val banco = Banco()
        assertTrue(banco.abrirCuenta(1, 24, true))
        assertTrue(banco.abrirCuenta(2, 67, false))

        banco.depositarDineroCuentaCliente(1, 50_000)
        banco.depositarDineroCuentaCliente(2, 300_000)

        assertFalse(banco.retirarDineroCuentaCliente(1, -50_000))
        assertEquals(50_000, banco.darSaldoCliente(1))
        assertFalse(banco.retirarDineroCuentaCliente(1, 0))
        assertEquals(50_000, banco.darSaldoCliente(1))
        assertTrue(banco.retirarDineroCuentaCliente(1, 30_000))
        assertEquals(20_000, banco.darSaldoCliente(1))
        assertFalse(banco.retirarDineroCuentaCliente(1, 100_000))
        assertEquals(20_000, banco.darSaldoCliente(1))
        assertTrue(banco.retirarDineroCuentaCliente(1, 20_000))
        assertEquals(0, banco.darSaldoCliente(1))

        assertEquals(300_000, banco.darSaldoCliente(2))
        assertTrue(banco.retirarDineroCuentaCliente(2, 200_000))
        assertEquals(100_000, banco.darSaldoCliente(2))
        assertFalse(banco.retirarDineroCuentaCliente(2, 0))
        assertEquals(100_000, banco.darSaldoCliente(2))
        assertTrue(banco.retirarDineroCuentaCliente(2, 200_000))
        assertEquals(-100_000, banco.darSaldoCliente(2))
        assertTrue(banco.retirarDineroCuentaCliente(2, 500_000))
        assertEquals(-600_000, banco.darSaldoCliente(2))
        assertFalse(banco.retirarDineroCuentaCliente(2, -100_000))
        assertEquals(-600_000, banco.darSaldoCliente(2))
        println("Pruebas de retirar: prueba superada 👍🏼")
    }

    @Test
    fun pruebaTransferir() {
        val banco = Banco()
        assertTrue(banco.abrirCuenta(1, 24, true))
        assertTrue(banco.abrirCuenta(2, 67, false))
        assertTrue(banco.abrirCuenta(3, 51, true))

        banco.depositarDineroCuentaCliente(1, 50_000)
        banco.depositarDineroCuentaCliente(2, 300_000)
        assertEquals(0, banco.darSaldoCliente(3))

        assertTrue(banco.transferirDineroEntreClientes(2, 1, 200_000))
        assertEquals(250_000, banco.darSaldoCliente(1))
        assertEquals(100_000, banco.darSaldoCliente(2))
        println("Transferir: Primera prueba superada!")

        assertFalse(banco.transferirDineroEntreClientes(3, 2, 50_000))
        assertEquals(100_000, banco.darSaldoCliente(2))
        assertEquals(0, banco.darSaldoCliente(3))

        assertFalse(banco.transferirDineroEntreClientes(2, 1, -20_000))
        assertEquals(250_000, banco.darSaldoCliente(1))
        assertEquals(100_000, banco.darSaldoCliente(2))

        assertFalse(banco.transferirDineroEntreClientes(2, 1, 0))
        assertEquals(250_000, banco.darSaldoCliente(1))
        assertEquals(100_000, banco.darSaldoCliente(2))

        assertTrue(banco.transferirDineroEntreClientes(2, 3, 500_000))
        assertEquals(250_000, banco.darSaldoCliente(1))
        assertEquals(-400_000, banco.darSaldoCliente(2))
        assertEquals(500_000, banco.darSaldoCliente(3))

        assertFalse(banco.transferirDineroEntreClientes(1, 3, 300_000))
        assertEquals(250_000, banco.darSaldoCliente(1))
        assertEquals(-400_000, banco.darSaldoCliente(2))
        assertEquals(500_000, banco.darSaldoCliente(3))

        assertTrue(banco.transferirDineroEntreClientes(2, 1, 50_000))
        assertEquals(300_000, banco.darSaldoCliente(1))
        assertEquals(-450_000, banco.darSaldoCliente(2))
        assertEquals(500_000, banco.darSaldoCliente(3))

        println("Transferir: segunda prueba superada 👍🏼")
    }

    private fun bancoDePrueba(): Banco {
        val banco = Banco()
        assertTrue(banco.abrirCuenta(1, 24, true))
        banco.depositarDineroCuentaCliente(1, 100_000)
        assertTrue(banco.abrirCuenta(2, 67, false))
        banco.depositarDineroCuentaCliente(2, 200_000)
        assertTrue(banco.abrirCuenta(3, 51, true))
        assertTrue(banco.abrirCuenta(4, 33, true))
        banco.depositarDineroCuentaCliente(4, 400_000)
        assertTrue(banco.abrirCuenta(5, 26, true))
        banco.depositarDineroCuentaCliente(5, 100_000)
        assertTrue(banco.abrirCuenta(6, 14, true))
        assertTrue(banco.abrirCuenta(7, 15, true))
        banco.depositarDineroCuentaCliente(7, 50_000)
        assertTrue(banco.abrirCuenta(8, 18, true))
        assertTrue(banco.abrirCuenta(9, 39, false))
        banco.depositarDineroCuentaCliente(9, 150_000)
        assertTrue(banco.abrirCuenta(0, 26, true))

        return banco
    }

    @Test
    fun pruebaCuentasAhorroSaldoPositivo() {
        val banco = bancoDePrueba()
        val lst = banco.cuentasAhorroSaldoPositivo()
        assertEquals(4, lst.tam)
        println("Cedulas: $lst")
        assertTrue(lst.contieneLista(crearLista(1, 4, 5, 7)))
        println("Prueba superada!")
    }

    @Test
    fun pruebaCuentaConMayorSaldo() {
        val banco = bancoDePrueba()
        val clnt1 = banco.cuentaConMayorSaldo("AHORROS")
        assertNotNull(clnt1)
        assertEquals(4, clnt1!!.cedula)
        assertEquals(400_000, clnt1.darSaldo())
        val clnt2 = banco.cuentaConMayorSaldo("CORRIENTE")
        assertEquals(2, clnt2!!.cedula)
        assertEquals(200_000, clnt2.darSaldo())

        val banco2 = Banco()
        assertTrue(banco2.abrirCuenta(1, 21, true))
        assertTrue(banco2.abrirCuenta(2, 17, true))
        val cltmax = banco2.cuentaConMayorSaldo("CORRIENTE")
        assertNull(cltmax)
        val cltaho = banco2.cuentaConMayorSaldo("AHORROS")
        assertNotNull(cltaho)
        assertTrue(cltaho!!.cedula == 1 || cltaho.cedula == 2)

        println("Prueba superada!")
    }

    @Test
    fun pruebaMenoresEdad() {
        val banco = bancoDePrueba()
        assertEquals(2, banco.menoresEdad())
        println("Prueba superada!!")
    }

    @Test
    fun pruebaDepositarIntereses() {
        val banco = bancoDePrueba()

        val s = banco.depositarIntereses(100_000)
        assertEquals(660_000, s)
        assertEquals(110_000, banco.darSaldoCliente(1))
        assertEquals(200_000, banco.darSaldoCliente(2))
        assertEquals(0, banco.darSaldoCliente(3))
        assertEquals(440_000, banco.darSaldoCliente(4))
        assertEquals(50_000, banco.darSaldoCliente(7))
        println("Prueba Superada!!!")
    }
}
