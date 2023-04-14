package taller11

import ean.collections.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Taller11KtTest {
    @Test
    fun pruebaEjercicio01() {
        val pila: IStack<Int> = TLinkedStack()

        pila.push(1)
        pila.push(2)
        pila.push(3)
        pila.push(4)
        pila.push(5)
        pila.push(6)

        println("La pila es $pila")
        println("El tope es ${pila.peek()}")
        println("El fondo es ${obtenerFondo(pila)}")

        assertEquals(1, obtenerFondo(pila))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio02() {
        val p: IStack<Int> = TLinkedStack()

        p.push(2)
        p.push(25)
        p.push(250)
        p.push(2500)
        p.push(100)
        p.push(125)
        p.push(81)

        assertEquals(350, sumarParesTresCifras(p))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio03() {
        var p: IStack<Int> = TLinkedStack()

        p.push(2)
        p.push(25)
        p.push(250)
        p.push(50)
        p.push(100)
        p.push(95)
        p.push(81)

        assertEquals(mayorDeDosCifras(p), 95)
        println("Primera Prueba Superada ✔")

        p.clear()
        p.push(3)
        p.push(4)
        p.push(5)

        assertNull(mayorDeDosCifras(p))
        println("Prueba Superada ✔")

    }

    @Test
    fun pruebaEjercicio04() {
        val pila: IStack<Int> = TLinkedStack()

        pila.push(1)
        pila.push(2)
        pila.push(3)
        pila.push(4)
        pila.push(5)
        pila.push(6)

        assertEquals(1, obtenerFondo(pila))

        guardarEnElFondo(pila, 10)

        assertEquals(10, obtenerFondo(pila))
        println("Prueba superada!")
    }


    @Test
    fun pruebaEjercicio05() {
        val pila: IStack<String> = TLinkedStack()

        assertEquals(0, tamPila(pila))

        pila.push("Hola")
        pila.push("nano")
        pila.push("shell")
        pila.push("rojo")

        assertEquals(4, tamPila(pila))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio06() {
        val pila: IStack<String> = TLinkedStack()
        val lista = Lists.of("uno", "dos", "tres", "cuatro", "cinco")

        for (elem in lista) {
            pila.push(elem)
        }

        val inv = invertirPila(pila)
        for (elem in lista) {
            assertEquals(elem, inv.peek())
            inv.pop()
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio07() {
        val pila: IStack<Int> = TLinkedStack()
        val lista = Lists.of(5, 11, 8, -3, 6, 4, 31)

        for (elem in lista) {
            pila.push(elem)
        }

        val copia = copiarPila(pila)
        for (n in lista.size - 1 downTo 0) {
            assertEquals(lista[n], copia.peek())
            copia.pop()
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio08() {
        val pila: IStack<Int> = TLinkedStack()
        val lista = Lists.of(5, 11, 8, -3, 5, 4, 31, 5)

        for (elem in lista) {
            pila.push(elem)
        }

        eliminarElementoPila(pila, 5)

        for (n in lista.size - 1 downTo 0) {
            if (lista[n] != 5) {
                assertEquals(lista[n], pila.peek())
                pila.pop()
            }
        }
        assertTrue(pila.isEmpty)
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio09() {
        val lista = mutableListOf<Int>(8, 1, 7, 6, -4, 5, 1, 31)
        val invlst = mutableListOf<Int>(8, 1, 7, 6, -4, 5, 1, 31)

        invertirLista(lista)

        for (i in 0 until lista.size) {
            assertEquals(lista[i], invlst[lista.size - i - 1])
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio10() {
        assertTrue(palindrome("nosubasabuson"))
        assertTrue(palindrome("lavanesabasenaval"))
        assertTrue(palindrome("logracasillasallisacargol"))
        assertFalse(palindrome("arrozconleche"))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio11() {
        val pila1: IStack<String> = TLinkedStack()
        val pila2: IStack<String> = TLinkedStack()
        val pila3: IStack<String> = TLinkedStack()
        val lista = Lists.of("uno", "dos", "tres", "cuatro", "cinco")

        for (elem in lista) {
            pila1.push(elem)
            pila2.push(elem)
            pila3.push(elem)
            pila3.push(elem)
        }

        assertTrue(igualesPilas(pila1, pila2))
        assertFalse(igualesPilas(pila3, pila2))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaContarVerbos() {
        val palabras: IStack<String> = TArrayStack()

        palabras.push("casa")
        palabras.push("casar")
        palabras.push("yuca")
        palabras.push("camisa")
        palabras.push("lluvia")
        palabras.push("llover")
        palabras.push("vives")
        palabras.push("vivir")
        palabras.push("partir")
        palabras.push("toma")
        palabras.push("épico")
        palabras.push("abrigo")

        assertEquals(4, contarVerbos(palabras))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaReemplazar() {
        val pila: IStack<Int> = TArrayStack()

        pila.push(4)
        pila.push(2)
        pila.push(3)
        pila.push(5)
        pila.push(2)
        pila.push(1)

        reemplazarElementoPila(pila, 2, 7)
        var n = 0
        var x = 0

        while (!pila.isEmpty) {
            n++
            if (pila.peek() == 7) {
                x++
            }
            else if (pila.peek() == 2) {
                assertEquals(7, pila.peek())
            }
            pila.pop()
        }
        assertTrue(n == 6 && x == 2)
        println("Prueba Superada ✔")

    }

    @Test
    fun probarPerrosMenoresEdad() {
        var pilaPerros: IStack<Perro> = TLinkedStack()

        with (pilaPerros) {
            push(Perro("juana", "chihuahua", 12))
            push(Perro("lila", "bulldog", 6))
            push(Perro("leon", "bulldog", 5))
            push(Perro("dion", "pastor collie", 7))
            push(Perro("leila", "bulldog", 11))
            push(Perro("angel", "pastor collie", 3))
            push(Perro("angela", "chihuahua", 4))
            push(Perro("terso", "bulldog", 5))
        }

        val res = perrosMenoresEdad(pilaPerros, 10)
        val res1 = res.sorted()
        assertEquals(listOf("angela", "lila", "terso"), res1)
        println("Prueba superada!")
    }

    @Test
    fun pruebaPerroMasJoven() {
        var pilaPerros: IStack<Perro> = TLinkedStack()

        with (pilaPerros) {
            push(Perro("juana", "chihuahua", 12))
            push(Perro("lila", "bulldog", 6))
            push(Perro("leon", "bulldog", 5))
            push(Perro("dion", "pastor collie", 7))
            push(Perro("leila", "bulldog", 11))
            push(Perro("angel", "pastor collie", 3))
            push(Perro("angela", "chihuahua", 4))
            push(Perro("terso", "bulldog", 5))
            push(Perro("resisto", "fox terrier", 15))
            push(Perro("mao", "doberman", 8))
            push(Perro("miso", "bulldog", 16))
            push(Perro("rifa", "doberman", 2))
            push(Perro("pumba", "fox terrier", 9))
            push(Perro("tostao", "pastor collie", 5))
            push(Perro("viento", "doberman", 12))
            push(Perro("brisa", "fox terrier", 1))
            push(Perro("arrastrao", "chihuahua", 18))
        }

        var res: Perro? = perroMasJoven(pilaPerros, "labrador")
        assertNull(res)

        res = perroMasJoven(pilaPerros, "doberman")
        var p1 = Perro(nombre="rifa", raza="doberman", edad=2)
        assertEquals(p1, res)

        res = perroMasJoven(pilaPerros, "chihuahua")
        p1 = Perro(nombre="angela", raza="chihuahua", edad=4)
        assertEquals(p1, res)

        res = perroMasJoven(pilaPerros, "bulldog")
        p1 = Perro(nombre="terso", raza="bulldog", edad=5)
        assertEquals(p1, res)

        println("Prueba superada! 👍")
    }
}