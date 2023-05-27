/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Unidad de Estudios: Estructura de Datos
 * Faculta de Ingeniería
 *
 * Proyecto Banco
 * Fecha: Mayo 23, 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package bancos

import ean.colecciones.Diccionario
import ean.colecciones.Lista
import ean.colecciones.diccionarioVacio
import ean.colecciones.listaVacia

/**
 * Clase que representa un Banco.
 */
class Banco() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Diccionario con los diversos clientes del banco
     */
    private val clientes: Diccionario<Int, Cliente> = diccionarioVacio()

    // -----------------------------------------------------------------
    // Metodos
    // -----------------------------------------------------------------

    /**
     * Permite obtener el número de clientes que hay en el banco
     */
    fun darCantidadClientes(): Int {
        return clientes.tam
    }

    /**
     * Método para agregar un cliente al Banco
     * No pueden haber dos clientes con la misma cédula. Si el cliente ya
     * existe, se retorna false.
     * Si no existe la cédula del cliente, se crea el objeto Cliente con
     * los datos de entrada, y se agrega el nuevo cliente al diccionario.
     * Tenga en cuenta que la llave es la cédula
     */
    fun abrirCuenta(cedula: Int, edad: Int, deAhorros: Boolean): Boolean {
        if (clientes.llaves.contains(cedula)) {
            return false
        }else{
            //Agregar al diccionario
            val cliente= Cliente(cedula,edad,deAhorros)
            clientes[cedula]=cliente
            return true
        }
    }

    /**
     * Permite obtener la información del cliente que tiene la cédula
     * NO PUEDE HABER UN FOR para encontrar el cliente!
     * Si no hay un cliente con esa cédula, se retorna null
     */
    fun darCliente(cedula: Int): Cliente? {
        if (!clientes.llaves.contains(cedula)) {
            return null
        }else{
            //Retorna al cliente que tiene la cédula
            return clientes[cedula]
        }
    }

    /**
     * Obtiene el saldo de la cuenta del cliente que tiene
     * la cédula dada.
     * Prerrequisito: La cédula existe en el banco
     */
    fun darSaldoCliente(cedula: Int): Int {
        return clientes[cedula]!!.darSaldo()
    }

    /**
     * Deposita un dinero en la cuenta del cliente con la cedula dada.
     * Si no existe un cliente con esa cédula se debe retornar false
     * Debe tener las consideraciones establecidas en el enunciado
     * de retirar de la clase Cliente. Se retorna true si se pudo
     * hacer el depósito y false si no fue posible.
     */
    fun depositarDineroCuentaCliente(cedulaCliente: Int, dinero: Int): Boolean {
        if (!clientes.llaves.contains(cedulaCliente)) {
            return false
        }else{
            if (dinero > 0) {
                //al cliente con la cédula se le deposita el dinero
                clientes[cedulaCliente]!!.depositar(dinero)
                    return true
            }else{
                return false
            }
        }
    }

    /**
     * Retira un dinero de la cuenta del cliente con la cédula dada
     * OJO: Si no existe el cliente con cédula dada, se retorna false
     * Debe usarse el método retirar de la clase Cliente.
     */
    fun retirarDineroCuentaCliente(cedulaCliente: Int, dinero: Int): Boolean {
        //No existe
        if (!clientes.llaves.contains(cedulaCliente)) {
            return false
        }else{
            if (dinero > 0) {
                //al cliente con la cédula se le retira el dinero
                return clientes[cedulaCliente]!!.retirar(dinero)
            }else{
                return false
            }
        }
    }

    /**
     * Esta operación transfiere dinero de una cuenta de origen a una cuenta de destino.
     * Una transferencia consiste en retirar dinero del origen y depositarlo en el destino.
     * A tener en cuenta: se debe retornar false y no debe haber cambio en los saldos de
     * las cuentas si ocurre alguna de los siguientes casos
     * - los clientes de origen o de destino no existen
     * - El dinero es cero o negativo
     * - Si la cuenta de origen es de ahorros y el saldo no es suficiente para retirar el dinero
     * En cualquier otro caso se debe hacer la transferencia y retornar true
     */
    fun transferirDineroEntreClientes(clienteOrigen: Int, clienteDestino: Int, dinero: Int): Boolean {
        //Si no existen
        if (!clientes.llaves.contains(clienteOrigen) || !clientes.llaves.contains(clienteDestino) || dinero<=0) {
            return false
        }else{
            //Cuenta corriente
            if (clientes[clienteOrigen]!!.deAhorros==false) {
                clientes[clienteDestino]!!.depositar(dinero)
                clientes[clienteOrigen]!!.retirar(dinero)
                return true
            }else{
                //Cuenta ahorros
                if(clientes[clienteOrigen]!!.darSaldo() >= dinero) {
                    clientes[clienteDestino]!!.depositar(dinero)
                    clientes[clienteOrigen]!!.retirar(dinero)
                    return true
                }
            }
            return false
        }
    }

    /**
     * Obtener la lista de las cedulas de aquellos
     * clientes que tengan cuentas de ahorros con
     * algún dinero en la cuenta.
     */
    fun cuentasAhorroSaldoPositivo(): Lista<Int> {
        var clientesSaldoPositivo= listaVacia<Int>()
        for (c in clientes.llaves) {
            //se crea una variable para la llave del diccionario
            val client=clientes[c]!!
            if (client.deAhorros == true && client.darSaldo() > 0) {
                clientesSaldoPositivo.agregarAlFinal(client.cedula)
            }
        }
        return clientesSaldoPositivo
    }

    /**
     * Obtiene el cliente que tiene una cuenta del tipo dado con
     * el saldo más grande. tipo puede ser CORRIENTE para cuentas
     * corrientes y AHORROS para cuenta de ahorros. Debe retornarse
     * null si no hay cuenta en el banco con el tipo dado.
     */
    fun cuentaConMayorSaldo(tipo: String): Cliente? {
        var Mayorcliente:Cliente?=null
        //el mayor empieza en Min. Value por los saldos en negativo.
        var mayor=Int.MIN_VALUE
        for (c in clientes.llaves) {
            val clie=clientes[c]!!
            val reemp=clie.darSaldo()
            if (tipo=="CORRIENTE" ) {
                if (reemp > mayor && clie.deAhorros==false) {
                    mayor = reemp
                    Mayorcliente = clientes[c]
                }
            }
            else if(tipo=="AHORROS") {
                if (reemp > mayor && clie.deAhorros) {
                    mayor = reemp
                    Mayorcliente = clientes[c]
                }
            }else{
            return null
            }
        }
        return Mayorcliente

    }
    /**
     * Obtener la cantidad de clientes menores de edad que
     * hay en el banco.
     */
    fun menoresEdad(): Int {
        var cont=0
        for (c in clientes.llaves) {
            val client=clientes[c]!!
            if (client.edad < 18) {
                cont++
            }
        }
        return cont
    }

    /**
     * Deposita en las cuentas de ahorro el interés mensual siempre y cuando
     * tengan el saldo mínimo que se pasa como dato de entrada.
     * Este interés corresponde a un 10% del saldo actual.
     * Retorne la suma de los saldos de las cuentas a quienes
     * se le depositó los intereses
     */
    fun depositarIntereses(saldoMinimo: Int): Int {
        var sum=0
        for (c in clientes.llaves) {
            val cli=clientes[c]!!
            if ( cli.deAhorros==true && cli.darSaldo() >= saldoMinimo) {
                //saldo actual más el 10%
                val porcenSaldo=(cli.darSaldo()*0.10)
                cli.depositar(porcenSaldo.toInt())
                sum+=cli.darSaldo()
            }
        }
        return sum
    }

}