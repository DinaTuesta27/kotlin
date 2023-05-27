/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Unidad de Estudios: Estructura de Datos
 * Faculta de Ingeniería
 *
 * Proyecto Banco
 * Fecha: 23 de mayo de 2025
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package bancos

class Cliente(val cedula: Int, val edad: Int, val deAhorros: Boolean) {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El saldo en la cuenta del cliente
     */
    private var saldo: Int = 0

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Aumenta el saldo de la cuenta del cliente en el valor especificado.
     * Si el valor es negativo o cero, no debe modificarse el saldo y se retorna false
     * En cualquier otro caso, se incrementa el saldo en el valor y se retorna true
     */
    fun depositar(valor: Int): Boolean {
        if (valor <= 0) {
            return false
        }else{
            saldo+=valor
            return true
        }
    }

    /**
     * Disminuye el saldo de la cuenta en el valor especificado.
     * Si el valor es negativo o cero, no se sigue y se retorna false inmediatamente
     * Aquí se presentan dos casos:
     * En las cuentas de ahorros (deAhorros == true), no se retirar un valor superior al saldo,
     *   y en ese caso, se retorna false y no se modifica el saldo. Si el saldo es superior al
     *   valor, se disminuye el saldo en el valor y se retorna true
     * En las cuentas corrientes (deAhorros == false), siempre se disminuye el saldo en el valor
     * y se retorna true en toda circunstancia
     */
    fun retirar(valor: Int): Boolean {
        if (valor <= 0) {
            return false
        }else if (deAhorros == true) {
            if (saldo >= valor) {
                saldo-=valor
                return true
            }else{
                return false
            }
        }else{
            saldo-=valor
            return true
        }
    }

    /**
     * Permite obtener el saldo de la cuenta
     */
    fun darSaldo(): Int {
        return saldo
    }

    /**
     * Convierte a String el objeto cliente actual
     */
    override fun toString(): String {
        return "Cliente(cedula=$cedula, edad=$edad, ${if (deAhorros)  "AHORROS" else "CORRIENTE"}, saldo=$saldo)"
    }

    /**
     * Permite comparar dos clientes a ver si son iguales.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        return (cedula != other.cedula)
    }

    override fun hashCode(): Int {
        var result = cedula
        result = 31 * result + edad
        result = 31 * result + deAhorros.hashCode()
        result = 31 * result + saldo
        return result
    }


}