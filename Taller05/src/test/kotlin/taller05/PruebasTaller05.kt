package taller05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Pruebas de la clase Circulo
 */
class PruebaCirculo {
    @Test
    fun prueba() {
        val circ = Circulo(radio = 4.0)
        assertEquals(50.2655, circ.area(), 1e-4)
        assertEquals(25.1327, circ.longitudCircunferencia(), 1e-4)
    }

}

//--------------------------------------------------------
/**
 * Pruebas de la clase Cuadrado
 */
class PruebaCuadrado {
    @Test
    fun pruebas() {
        val cuad = Cuadrado(lado = 5.0)
        assertEquals(25.0, cuad.area())
        assertEquals(7.0711, cuad.diagonal(), 1e-4)
        assertEquals(20.0, cuad.perimetro())
        println("Prueba superada 🦾")
    }
}

//-------------------------------------------------------
/**
 * Pruebas de la clase Rectangulo
 */
class PruebaRectangulo {
    @Test
    fun pruebas() {
        val rect = Rectangulo(base = 3.0, altura = 4.0)
        assertEquals(12.0, rect.area())
        assertEquals(5.0, rect.diagonal())
        assertEquals(14.0, rect.perimetro())
        println("Prueba superada 🦾")
    }
}

//--------------------------------------------------------
/**
 * Pruebas de la clase Triangulo
 */
class PruebaTriangulo() {
    @Test
    fun pruebas() {
        val tri = Triangulo(base = 3.0, altura = 4.0)
        assertEquals(6.0, tri.area())
        println("Prueba superada 🦾")
    }
}

//--------------------------------------------------------
/**
 * Pruebas de los diversos ejercicios
 */
internal class PruebasEjercicios {
    /**
     * Pruebas del ejercicio05
     */
    @Test
    fun pruebaEjercicio05() {
        assertEquals(37.699112, ejercicio05(2.0), 1e-6)
        println("Prueba superada 😀")
    }

    /**
     * Pruebas del ejercicio 06
     */
    @Test
    fun pruebaEjercicio06() {
        assertEquals(550.0, ejercicio06(5.0))
        println("Prueba superada 😀")
    }

    /**
     * Prueba del ejercicio 07
     */
    @Test
    fun pruebaEjercicio07() {
        assertEquals(134.126147, ejercicio07(x = 25.0), 1e-6)
        println("Prueba superada 😀")
    }

    /**
     * Prueba del ejercicio 08
     */
    @Test
    fun pruebaEjercicio08() {
        val triangulo = Triangulo(base = 3.0, altura = 4.0)
        assertEquals(5.0, ejercicio08(triangulo))
        println("Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 09
     */
    @Test
    fun pruebaEjercicio09() {
        assertEquals(15.81, ejercicio09(3.0, 4.0), 1e-2)
        println("Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 10
     */
    @Test
    fun pruebaEjercicio10() {
        assertEquals(114.1592653589793, ejercicio10(10.0), 1e-13)
        println("Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 11
     */
    @Test
    fun pruebaEjercicio11() {
        assertEquals(80.11, ejercicio11(10.0, 3.0), 1e-2)
        println("Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 12
     */
    @Test
    fun pruebaEjercicio12() {
        assertEquals(72.0, ejercicio12(10.0, 6.0, 14.0))
        println("Prueba superada 😀")
    }

    /**
     * Pruebas ejercicio 13
     */
    @Test
    fun pruebaEjercicio13() {
        assertEquals(13.0, ejercicio13(1.0, 2.0, 4.0, 6.0, 3.0))
        println("Prueba superada 😀")
    }
}