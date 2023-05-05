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

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class SuperHéroe(val nombre: String, val poder: Int, val universo: String): Comparable<SuperHéroe> {
    /**
     * Primer criterio de comparación es el nombre, y el segundo será el poder.
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [other] object, a negative number if it's less than [other], or a positive number
     * if it's greater than [other].
     */
    override fun compareTo(other: SuperHéroe): Int {
        return compareValuesBy(this, other, SuperHéroe::nombre, SuperHéroe::poder)
    }

}

/**
 * Clase que representa la información de un producto.
 * Use el precio del producto como criterio de comparación.
 */

data class Producto(var nombre: String, var precio: Double, var cantidad: Int) : Comparable<Producto> {

    override fun compareTo(other: Producto): Int {
        if (this.precio == other.precio) {
            return 1
        }else if (this.precio < other.precio) {
            return -1
        } else {
            return 0
        }
    }

}

//--------------------------------------------------------------------
// Un comparador de productos, usando el nombre como criterio de
// comparación.
//--------------------------------------------------------------------

class ComparadorDeProductosPorNombre : Comparator<Producto> {

    // Compara los productos por nombre
    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1!!.nombre == o2!!.nombre) {
            return 0
        }else if (o1!!.nombre < o2!!.nombre) {
            return -1
        } else {
            return 1
        }
    }

}

object ComparadorPorNombreYPrecio : Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1!!.nombre == o2!!.nombre) {
            if (o1!!.precio == o2!!.precio) {
                return 0
            } else if (o1!!.nombre < o2!!.nombre) {
                return -1
            } else {
                return 1
            }
        }else if (o1!!.nombre < o2!!.nombre) {
            return -1
        } else {
            return 1
        }
    }

}

object ComparadorPorCantidad: Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1!!.cantidad == o2!!.cantidad) {
            return 0
        }else if (o1!!.cantidad < o2!!.cantidad) {
            return -1
        } else {
            return 1
        }
    }
}

/**
 * Clase que representa un Reloj
 */
class Reloj : Comparable<Reloj> {
    /**
    Atributos: Un reloj tiene horas, minutos y segundos.
    La hora están 0 y 23, los minutos y segundos entre 0 y 59
     */

    var hora: Int = 0
    var minutos: Int = 0
    var segundos: Int= 0

    /**
     * Agregue un constructor que inicialice el reloj en la hora
     * actual del computador (este es el constructor por defecto)
     */
    constructor() {
        val horaAct = java.time.LocalTime.now()
    // El formato es HH:mm:ss
        this.hora = horaAct.hour
        this.minutos = horaAct.minute
        this.segundos = horaAct.second
    }

    constructor(hora: Int, minutos: Int, segundos: Int) {
        require(hora in 0 .. 24 && minutos in 0 .. 59 && segundos in 0 .. 59)
        this.hora = hora
        this.minutos = minutos
        this.segundos = segundos
    }

    /*
     * Agregue una función toString que muestre la hora en formato hh:mm:ss
     * y otra función toAMPMString que muestre el tiempo en hh:mm:ss AMPM
     */
    override fun toString(): String {
        if (hora in 0 .. 9) {
            return "0${hora}:${minutos}:${segundos}"
        }else if (minutos in 0 .. 9) {
            return "${hora}:0${minutos}:${segundos}"
        }else if (segundos in 0.. 9) {
            return "${hora}:${minutos}:0${segundos}"
        }else{
            return "${hora}:${minutos}:${segundos}"
        }
    }

    fun toAMPMString(): String {
        if (hora in 0 .. 11) {
            return "${hora}:${minutos}:${segundos} AM"
        }else{
            var pm= hora-12
            if (pm in 0..9 || segundos in 0..9) {
                return "0${pm}:${minutos}:0${segundos} PM"
            }else{
                return "${pm}:${minutos}:${segundos} PM"
            }
        }
    }

    /*
     * Agregue métodos para avanzar el reloj un segundo y otro para retrocederlo un segundo.
     * Adicionalmente un método equals.
     */
    fun avanzarUnSegundo() {
        if (this.segundos == 59 && this.minutos == 59 && this.hora == 23) {
            segundos = 0
            minutos = 0
            hora=0
        }else if (this.segundos == 59 && this.minutos == 59 && this.hora in 0 .. 22) {
            segundos = 0
            minutos = 0
            hora++
        } else if (this.segundos == 59 && this.minutos in 0 .. 58) {
            segundos=0
            minutos++
        }else{
            segundos++
        }
    }

    fun retrocederUnSegundo() {
        if (this.segundos == 0 && this.minutos == 0 && this.hora == 0) {
            segundos = 59
            minutos = 59
            hora = 23
        }else if (this.segundos == 0 && this.minutos == 0 && this.hora in 1..23) {
            segundos = 59
            minutos = 59
            hora--
        } else if (this.segundos == 0 && this.minutos in 1 .. 59) {
            this.segundos=59
            minutos--
        }else{
            segundos--
        }
    }

    /**
     * La función de comparación
     */
    override fun compareTo(other: Reloj): Int {
        if (this.hora == other.hora) {
            if (this.minutos == other.minutos) {
                if (this.segundos == other.segundos) {
                    return 0
                }else if (this.segundos < other.segundos) {
                    return -1
                }else{
                    return 1
                }
            } else if (this.minutos < other.minutos) {
                return -1
            } else {
                return 1
            }
        }else if (this.hora < other.hora) {
            return -1
        } else {
            return 1
        }
    }
    //equals
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Reloj

        if (hora != other.hora) return false
        if (minutos != other.minutos) return false
        if (segundos != other.segundos) return false

        return true
    }

}


