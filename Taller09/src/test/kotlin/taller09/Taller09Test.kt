package taller09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.*


class Taller09Test {

    @Test
    fun pruebaPerro() {
        val p = Perro("ABC123", "Firulais", "Pastor", 12, 177)
        assertEquals(2011, p.añoNacimiento())
        println("Prueba superada 👍")
    }

    private fun cargarPerros(): ExposicionPerros? {
        try {
            val propiedades = Properties()
            propiedades.load(FileReader("./data/perros.txt"))
            val exposicion = ExposicionPerros()

            // Cargar los perros
            var dato: String
            var placa: String?
            var nombre: String
            var raza: String
            var imagen: String
            var puntos: Int
            var edad: Int
            var aux: String
            dato = "total.perros"
            aux = propiedades.getProperty(dato)
            val cantidad = aux.toInt()
            var p: NodoPerro? = null
            for (cont in 1..cantidad) {
                // Carga un perro
                dato = "perro$cont.placa"
                placa = propiedades.getProperty(dato)
                dato = "perro$cont.nombre"
                nombre = propiedades.getProperty(dato)
                dato = "perro$cont.raza"
                raza = propiedades.getProperty(dato)
                dato = "perro$cont.raza"
                raza = propiedades.getProperty(dato)
                dato = "perro$cont.puntos"
                aux = propiedades.getProperty(dato)
                puntos = aux.toInt()
                dato = "perro$cont.edad"
                aux = propiedades.getProperty(dato)
                edad = aux.toInt()

                // Sólo se carga el perro si los datos son correctos
                if (placa != null) {
                    val perro = Perro(placa!!, nombre, raza, edad, puntos)
                    if (p == null) {
                        exposicion.primero = NodoPerro(perro)
                        p = exposicion.primero
                    }
                    else {
                        val nodo = NodoPerro(perro)
                        p!!.siguiente = nodo
                        p = nodo
                    }
                }
            }
            return exposicion
        }
        catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    @Test
    fun pruebaNumPerros() {
        var expo: ExposicionPerros? = ExposicionPerros()
        assertEquals(0, expo!!.numPerros())

        val p1 = Perro("A", "A", "A", 1, 1)
        val p2 = Perro("B", "B", "A", 1, 1)
        val p3 = Perro("C", "C", "A", 1, 1)

        expo!!.primero = NodoPerro(p1)
        var pointer = expo!!.primero
        pointer!!.siguiente = NodoPerro(p2)
        pointer = pointer!!.siguiente
        pointer!!.siguiente = NodoPerro(p3)
        assertEquals(3, expo!!.numPerros())

        expo = cargarPerros()
        assertEquals(11, expo!!.numPerros())

        println("Prueba Superada 👍👍")
    }

    @Test
    fun pruebaExistePerro() {
        val expo = cargarPerros()
        assertTrue(expo!!.existePerro("NIS340"))
        assertTrue(expo!!.existePerro("ABR901"))
        assertTrue(expo!!.existePerro("REI8273"))
        assertFalse(expo!!.existePerro("123ABC"))
        assertFalse(expo!!.existePerro("XYZ"))
        println("Prueba Superada!! 👍")
    }

    @Test
    fun pruebaObtenerPerroConPlaca() {
        val expo = cargarPerros()!!

        var p = expo.obtenerPerroConPlaca("NIS340")
        assertNotNull(p)
        assertEquals("Maximus", p!!.nombre)

        p = expo.obtenerPerroConPlaca("WBX-ZYE")
        assertNotNull(p)
        assertEquals("Gosque", p!!.raza)
        assertEquals(10, p!!.puntos)

        p = expo.obtenerPerroConPlaca("OEN219")
        assertNotNull(p)
        assertEquals("Beagle", p!!.raza)
        assertEquals(75, p!!.puntos)
        assertEquals("Taylor", p!!.nombre)

        p = expo.obtenerPerroConPlaca("AVC1234")
        assertNull(p)

        p = expo.obtenerPerroConPlaca("1234567")
        assertNull(p)

        println("Prueba Superada!! 👍")
    }

    @Test
    fun pruebaObtenerPerroEnPosicion() {
        val expo = cargarPerros()!!

        var p = expo.obtenerPerroEnPosicion(0)
        assertNotNull(p)
        assertEquals("Puppy", p!!.nombre)
        assertEquals(10, p!!.edad)

        p = expo.obtenerPerroEnPosicion(10)
        assertNotNull(p)
        assertEquals("Fido", p!!.nombre)
        assertEquals(83, p!!.puntos)

        p = expo.obtenerPerroEnPosicion(6)
        assertNotNull(p)
        assertEquals("210JULY", p!!.placa)
        assertEquals("Nieve", p!!.nombre)

        p = expo.obtenerPerroEnPosicion(20)
        assertNull(p)

        p = expo.obtenerPerroEnPosicion(11)
        assertNull(p)

        println("Prueba superada! 👍")
    }

    @Test
    fun pruebaObtenerPosicionPerro() {
        val expo = cargarPerros()!!

        var pos = expo.obtenerPosicionPerro("210JULY")
        assertEquals(6, pos)

        pos = expo.obtenerPosicionPerro("YUI182")
        assertEquals(0, pos)

        pos = expo.obtenerPosicionPerro("PERRO123")
        assertEquals(-1, pos)

        pos = expo.obtenerPosicionPerro("DEA388")
        assertEquals(8, pos)

        println("Prueba superada! 👍")
    }

    @Test
    fun pruebaAgregarAlPrincipio() {
        var expo1 = ExposicionPerros()

        var p1 = Perro("ABC123", "A", "B", 11, 100)
        assertTrue(expo1.agregarAlPrincipio(p1))
        assertNotNull(expo1.primero)
        assertNull(expo1.primero!!.siguiente)
        assertEquals("A", expo1.primero!!.info.nombre)

        assertFalse(expo1.agregarAlPrincipio(p1))

        var p2 = Perro("CDE896", "B", "C", 45, 31)
        assertTrue(expo1.agregarAlPrincipio(p2))
        assertFalse(expo1.agregarAlPrincipio(p1))
        assertFalse(expo1.agregarAlPrincipio(p2))
        var n1 = expo1.primero
        assertNotNull(n1)
        var n2 = n1!!.siguiente
        assertNotNull(n2)
        assertNull(n2!!.siguiente)
        assertEquals("CDE896", n1!!.info.placa)
        assertEquals("A", n2!!.info.nombre)

        p1 = Perro("XYZ", "Z", "C", 19, 87)
        assertTrue(expo1.agregarAlPrincipio(p1))
        n1 = expo1.primero
        assertNotNull(n1)
        n2 = n1!!.siguiente
        assertNotNull(n2)
        var n3 = n2!!.siguiente
        assertNotNull(n3)
        assertNull(n3!!.siguiente)
        assertEquals("XYZ", n1!!.info.placa)
        assertEquals("CDE896", n2!!.info.placa)
        assertEquals("A", n3!!.info.nombre)

        p1 = Perro("LAC281", "D", "XXA", 21, 61)
        assertTrue(expo1.agregarAlPrincipio(p1))
        n1 = expo1.primero
        assertNotNull(n1)
        n2 = n1!!.siguiente
        assertNotNull(n2)
        n3 = n2!!.siguiente
        assertNotNull(n3)
        var n4 = n3!!.siguiente
        assertNotNull(n4)
        assertNull(n4!!.siguiente)
        assertEquals("LAC281", n1!!.info.placa)
        assertEquals("XYZ", n2!!.info.placa)
        assertEquals("CDE896", n3!!.info.placa)
        assertEquals("A", n4!!.info.nombre)

        println("Prueba superada!! 👍")
    }

    @Test
    fun pruebaAgregarAlFinal() {
        var expo1 = ExposicionPerros()

        var p1 = Perro("ABC123", "A", "B", 11, 100)
        assertTrue(expo1.agregarAlFinal(p1))
        assertFalse(expo1.agregarAlFinal(p1))
        assertNotNull(expo1.primero)
        assertNull(expo1.primero!!.siguiente)
        assertEquals("A", expo1.primero!!.info.nombre)

        var p2 = Perro("CDE896", "B", "C", 45, 31)
        assertTrue(expo1.agregarAlFinal(p2))
        assertFalse(expo1.agregarAlFinal(p1))
        assertFalse(expo1.agregarAlFinal(p2))
        var n1 = expo1.primero
        assertNotNull(n1)
        var n2 = n1!!.siguiente
        assertNotNull(n2)
        assertNull(n2!!.siguiente)
        assertEquals("CDE896", n2!!.info.placa)
        assertEquals("A", n1!!.info.nombre)

        p1 = Perro("XYZ", "Z", "C", 19, 87)
        assertTrue(expo1.agregarAlFinal(p1))
        assertFalse(expo1.agregarAlFinal(p2))
        n1 = expo1.primero
        assertNotNull(n1)
        n2 = n1!!.siguiente
        assertNotNull(n2)
        var n3 = n2!!.siguiente
        assertNotNull(n3)
        assertNull(n3!!.siguiente)
        assertEquals("XYZ", n3!!.info.placa)
        assertEquals("CDE896", n2!!.info.placa)
        assertEquals("ABC123", n1!!.info.placa)

        p1 = Perro("LAC281", "D", "XXA", 21, 61)
        assertTrue(expo1.agregarAlFinal(p1))
        assertFalse(expo1.agregarAlFinal(p1))
        assertFalse(expo1.agregarAlFinal(p2))
        n1 = expo1.primero
        assertNotNull(n1)
        n2 = n1!!.siguiente
        assertNotNull(n2)
        n3 = n2!!.siguiente
        assertNotNull(n3)
        var n4 = n3!!.siguiente
        assertNotNull(n4)
        assertNull(n4!!.siguiente)
        assertEquals("LAC281", n4!!.info.placa)
        assertEquals("XYZ", n3!!.info.placa)
        assertEquals("CDE896", n2!!.info.placa)
        assertEquals("ABC123", n1!!.info.placa)

        println("Prueba superada!! 👍")

    }

    @Test
    fun pruebaAgregarEnPosicion() {
        var expo1 = ExposicionPerros()
        var p1 = Perro("LAC281", "D", "XXA", 21, 61)
        assertTrue(expo1.agregarEnPosicion(10, p1))
        assertEquals("LAC281", expo1.primero!!.info.placa)
        assertNull(expo1.primero!!.siguiente)

        var p2 = Perro("TERA-001", "Falco", "Doberman", 11, 78)
        assertTrue(expo1.agregarEnPosicion(0, p2))
        assertFalse(expo1.agregarEnPosicion(0, p1))
        var n1 = expo1.primero
        assertNotNull(n1)
        var n2 = n1!!.siguiente
        assertNotNull(n2)
        assertNull(n2!!.siguiente)
        assertEquals("Falco", n1!!.info.nombre)
        assertEquals("D", n2!!.info.nombre)

        expo1 = cargarPerros()!!
        assertTrue(expo1.agregarEnPosicion(3, p1))
        assertFalse(expo1.agregarEnPosicion(100, p1))
        n1 = expo1.primero  // 0
        assertNotNull(n1)
        n2 = n1!!.siguiente // 1
        assertNotNull(n2)
        var n3 = n2!!.siguiente // 2
        assertNotNull(n3)
        var n4 = n3!!.siguiente // 3
        assertNotNull(n4)
        var n5 = n4!!.siguiente // 4
        assertNotNull(n5)
        assertNotNull(n5!!.siguiente)
        assertEquals("YUI182", n1!!.info.placa)
        assertEquals("OEN219", n2!!.info.placa)
        assertEquals("BEN841", n3!!.info.placa)
        assertEquals("LAC281", n4!!.info.placa)
        assertEquals("HINO-178", n5!!.info.placa)

        assertTrue(expo1.agregarEnPosicion(11, p2))
        assertFalse(expo1.agregarEnPosicion(8, n3!!.info))
        var q: NodoPerro? = expo1.primero
        while (q!!.siguiente!!.siguiente != null) {
            q = q!!.siguiente
        }
        assertEquals("Falco", q!!.info.nombre)
        assertEquals("Fido", q!!.siguiente!!.info.nombre)

        var p3 = Perro("SDE1891", "Tormenta", "AAA", 11, 89)
        assertTrue(expo1.agregarEnPosicion(200, p3))
        var s = q!!.siguiente
        assertNotNull(s)
        assertNotNull(s!!.siguiente)
        s = s!!.siguiente
        assertNull(s!!.siguiente)
        assertEquals("SDE1891", s!!.info.placa)
        assertEquals(14, expo1.numPerros())

        println("Prueba superada!! 👍")

    }

    @Test
    fun pruebaEliminarPrimero() {
        var expo = ExposicionPerros()
        assertFalse(expo.eliminarPrimero())

        expo.agregarAlPrincipio(Perro("A", "A", "A", 1, 1))
        assertEquals(1, expo.numPerros())
        expo.agregarAlFinal(Perro("B", "B", "B", 2, 2))
        assertEquals(2, expo.numPerros())

        assertTrue(expo.eliminarPrimero())
        assertEquals(1, expo.numPerros())
        assertEquals("B", expo.primero!!.info.placa)
        assertNull(expo.primero!!.siguiente)

        assertTrue(expo.eliminarPrimero())
        assertEquals(0, expo.numPerros())
        assertNull(expo.primero)
        assertFalse(expo.eliminarPrimero())

        expo = cargarPerros()!!
        assertEquals(11, expo.numPerros())
        assertTrue(expo.eliminarPrimero())
        assertEquals(10, expo.numPerros())
        assertEquals("Taylor", expo.primero!!.info.nombre);
        var q: NodoPerro? = expo.primero
        while (q!!.siguiente != null) {
            q = q!!.siguiente
        }
        assertEquals("Fido", q!!.info.nombre)

        println("Prueba superada!! 👍")
    }

    @Test
    fun pruebaEliminarUltimo() {
        var expo = ExposicionPerros()
        assertFalse(expo.eliminarUltimo())

        expo.agregarAlFinal(Perro("A", "A", "A", 1, 1))
        assertEquals(1, expo.numPerros())
        expo.agregarAlFinal(Perro("B", "B", "B", 2, 2))
        assertEquals(2, expo.numPerros())

        assertTrue(expo.eliminarUltimo())
        assertEquals(1, expo.numPerros())
        assertEquals("A", expo.primero!!.info.placa)

        assertTrue(expo.eliminarUltimo())
        assertNull(expo.primero)
        assertFalse(expo.eliminarUltimo())

        expo = cargarPerros()!!
        assertEquals(11, expo.numPerros())
        assertTrue(expo.eliminarUltimo())
        assertEquals(10, expo.numPerros())
        var q: NodoPerro? = expo.primero
        while (q!!.siguiente != null) {
            q = q!!.siguiente
        }
        assertEquals("Gosque", q!!.info.raza)

        assertTrue(expo.eliminarUltimo())
        assertEquals(9, expo.numPerros())
        q = expo.primero
        while (q!!.siguiente != null) {
            q = q!!.siguiente
        }
        assertEquals("Chiuahua", q!!.info.raza)

        println("Prueba superada!! 👍")

    }

    @Test
    fun pruebaEliminarPosicion() {
        var expo: ExposicionPerros? = ExposicionPerros()
        assertFalse(expo!!.eliminarPosicion(0))

        expo!!.agregarAlFinal(Perro("A", "B", "C", 1, 1))
        assertFalse(expo!!.eliminarPosicion(-10))
        assertFalse(expo!!.eliminarPosicion(5))
        assertTrue(expo!!.eliminarPosicion(0))
        assertEquals(0, expo!!.numPerros())
        assertNull(expo!!.primero)

        expo = cargarPerros()
        assertFalse(expo!!.eliminarPosicion(-1))
        assertFalse(expo!!.eliminarPosicion(11))
        assertTrue(expo!!.eliminarPosicion(3))
        assertEquals(10, expo!!.numPerros())
        var n1 = expo!!.primero   // 0
        assertNotNull(n1)
        var n2 = n1!!.siguiente   // 1
        assertNotNull(n2)
        var n3 = n2!!.siguiente   // 2
        assertNotNull(n3)
        var n4 = n3!!.siguiente   // 3
        assertNotNull(n4)
        var n5 = n4!!.siguiente   // 4
        assertNotNull(n5)
        assertNotNull(n5!!.siguiente)

        assertEquals("Puppy", n1!!.info.nombre)
        assertEquals("Taylor", n2!!.info.nombre)
        assertEquals("Cobrador", n3!!.info.nombre)
        assertEquals("Maximus", n4!!.info.nombre)
        assertEquals("Tony", n5!!.info.nombre)

        assertTrue(expo!!.eliminarPosicion(0))
        assertEquals(9, expo!!.numPerros())
        assertNotNull(expo!!.primero)

        assertTrue(expo!!.eliminarPosicion(8))
        assertEquals(8, expo!!.numPerros())
        var q: NodoPerro? = expo!!.primero
        while (q!!.siguiente != null) {
            q = q!!.siguiente
        }
        assertEquals("WBX-ZYE", q!!.info.placa)

        println("Prueba superada!! 👍")
    }

    @Test
    fun pruebaAumentarPuntos() {
        var expo: ExposicionPerros? = ExposicionPerros()
        assertFalse(expo!!.aumentarPuntosPerro("123", 10))

        expo = cargarPerros()
        assertTrue(expo!!.aumentarPuntosPerro("REI8273", 5))
        var perro1 = expo!!.obtenerPerroConPlaca("REI8273")
        assertNotNull(perro1)
        assertEquals("Fido", perro1!!.nombre)
        assertEquals(88, perro1!!.puntos)

        assertFalse(expo!!.aumentarPuntosPerro("WBX-ZZU", 100))

        assertTrue(expo!!.aumentarPuntosPerro("210JULY", 30))
        perro1 = expo!!.obtenerPerroConPlaca("210JULY")
        assertNotNull(perro1)
        assertEquals("Nieve", perro1!!.nombre)
        assertEquals(80, perro1!!.puntos)

        println("Prueba superada!! 👍")
    }

    @Test
    fun pruebaContarRangos() {
        var expo = cargarPerros()!!
        assertEquals(9, expo!!.contarPerrosRangoEdad(10, 20))
        assertEquals(1, expo!!.contarPerrosRangoEdad(20, 30))
        println("Prueba superada!! 👍")
    }

    @Test
    fun pruebaSumaPuntos() {
        var expo = cargarPerros()!!
        assertEquals(118, expo!!.sumarPuntosPerros('T'))
        assertEquals(83, expo!!.sumarPuntosPerros('F'))
        println("Prueba superada!! 👍")
    }

    @Test
    fun pruebaPromedio() {
        var expo = cargarPerros()
        assertEquals(17.81, expo!!.promedioEdadPerros(), 1e-2)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaGanador() {
        var expo = cargarPerros()!!
        var p = expo.ganador()
        assertEquals("BEN841", p!!.placa)
        assertEquals("Cobrador", p!!.nombre)

        assertNull(ExposicionPerros().ganador())
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaMasJoven() {
        var expo = ExposicionPerros()
        assertNull(expo.masJoven(20))

        expo = cargarPerros()!!
        assertEquals("YUI182", expo.masJoven(100))
        assertEquals("WBX-ZYE", expo.masJoven(50))
        assertNull(expo.masJoven(5))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPorcentaje() {
        var expo = ExposicionPerros()
        assertEquals(0.0, expo.porcentajePerrosFinalizanLetra('K'))
        expo = cargarPerros()!!
        assertEquals(0.0, expo.porcentajePerrosFinalizanLetra('K'))
        assertEquals(27.27, expo.porcentajePerrosFinalizanLetra('n'), 1e-2)
        assertEquals(18.18, expo.porcentajePerrosFinalizanLetra('r'), 1e-2)
        assertEquals(18.19, expo.porcentajePerrosFinalizanLetra('y'), 1e-2)
        println("Prueba superada!! 👍")
    }

}