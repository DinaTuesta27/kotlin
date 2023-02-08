package Taller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TallerKtTest{
    @Test
    fun pruebaTuristas(){
        val(viajes,costo)= hallarTuristas(187,19,25_000)
        assertEquals(10,viajes)
        assertEquals(250_000, costo)
        println("Prueba superada :)")
    }
}