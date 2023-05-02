package taller15

import ean.collections.IBinTree
import ean.collections.TBinTree
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Taller15Test {
    /**
     * Objetos que usaremos en el desarrollo de las pruebas
     */
    private lateinit var arbol1: IBinTree<String>
    private lateinit var arbol2: IBinTree<Int>

    @BeforeEach
    fun setUp() {
        // Arbol de String: vacio
        val vacioStr: IBinTree<String> = TBinTree()

        // Árbol de letras
        arbol1 = TBinTree(
            "A",
            TBinTree(
                "B",
                TBinTree(
                    "D",
                    TBinTree("G"),
                    vacioStr
                ),
                TBinTree(
                    "E",
                    TBinTree("H"),
                    TBinTree("I")
                )
            ),
            TBinTree(
                "C",
                vacioStr,
                TBinTree(
                    "F",
                    TBinTree(
                        "J",
                        vacioStr,
                        TBinTree("K")
                    ),
                    vacioStr
                )
            )
        )

        // Arbol de números: vacío
        val vacioInt: IBinTree<Int> = TBinTree()

        // Árbol de números
        arbol2 = TBinTree(
            60,
            TBinTree(
                41,
                TBinTree(
                    16,
                    vacioInt,
                    TBinTree(25)
                ),
                TBinTree(
                    53,
                    TBinTree(
                        46,
                        TBinTree(42),
                        vacioInt
                    ),
                    TBinTree(55)
                )
            ),
            TBinTree(
                74,
                TBinTree(
                    65,
                    TBinTree(
                        63,
                        TBinTree(62),
                        TBinTree(64)
                    ),
                    TBinTree(70)
                ),
                vacioInt
            )
        )
    }

    @Test
    fun pruebaEstaArbin() {
        assertFalse {
            estaArbin(arbol2, 72)
        }
        assertTrue {
            estaArbin(arbol1, "H")
        }
        assertFalse {
            estaArbin(TBinTree<Int>(), 30)
        }
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContarVocales() {
        assertEquals(3, contarVocales(arbol1))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaSumaPares() {
        assertEquals(434, sumaPares(arbol2))
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaPorcentajePares() {
        assertEquals(57.14285, porcentajePares(arbol2), 1e-5)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaMultiplosDeSeis() {
        val res = multiplosDeSeis(arbol2).sorted()
        assertEquals(listOf(42, 60), res)
        println("Prueba superada 👍")
    }

    @Test
    fun pruebaContar() {
        assertEquals(3, contarArbol(arbol2))
        println("Prueba superada 👍")
    }

    @Test
    fun probarPeso() {
        assertEquals(11, peso(arbol1))
        println("Prueba superada 👍")
    }

    @Test
    fun probarContarHojas() {
        assertEquals(6, contarHojas(arbol2))
        println("Prueba superada 👍")
    }

    @Test
    fun probarNivelElemento() {
        assertEquals(-1, nivelElementoArbol(arbol1, "Z"))
        assertEquals(3, nivelElementoArbol(arbol1, "G"))
        println("Prueba superada 👍")
    }

    @Test
    fun probarAltura() {
        assertEquals(5, altura(arbol1))
        println("Prueba superada 👍")
    }

    @Test
    fun probarContarVecesApareceElem() {
        assertEquals(1, contarNumVecesApareceElemento(arbol2, 63))
        assertEquals(0, contarNumVecesApareceElemento(arbol2, 8))
        println("Prueba superada 👍")
    }

    @Test
    fun probarPadre() {
        assertNull(padre(arbol1, "R"))

        assertEquals("J", padre(arbol1, "K"))

        assertEquals(63, padre(arbol2, 64))

        println("Prueba superada 👍")
    }

    @Test
    fun probarHermano() {
        assertNull(hermanoElementoArbol(arbol2, 42))  //  El 42 no tiene hermano

        assertEquals(62, hermanoElementoArbol(arbol2, 64))

        assertEquals("I", hermanoElementoArbol(arbol1, "H"))

        println("Prueba superada 👍")
    }

    @Test
    fun probarMenor() {
        assertEquals(16, menorArbol(arbol2))
        println("Prueba superada 💪")
    }

    @Test
    fun probarPreorden() {
        preorden(arbol1)
    }

    @Test
    fun probarInorden() {
        inorden(arbol2)
    }

    @Test
    fun probarPostorden() {
        postorden(arbol1)
    }

    @Test
    fun probarVerbal() {
        val verbos = TBinTree<String>(
            "comer",
            TBinTree(
                "cenar",
                TBinTree("partir", TBinTree("Tener"), TBinTree("sufrir")),
                TBinTree("internacionalizar")
            ),
            TBinTree(
                "exponer",
                TBinTree(
                    "pedir",
                    TBinTree("sanar"),
                    TBinTree("mecer")
                ),
                TBinTree("doler")
            )
        )

        assertFalse(verbal(arbol1))
        assertTrue(verbal(verbos))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaDigital() {
        val aDig = TBinTree(
            7,
            TBinTree(
                8, TBinTree(4, TBinTree(2), TBinTree()),
                TBinTree(6)
            ),
            TBinTree(1, TBinTree(0), TBinTree(5))
        )
        assertFalse {
            digital(arbol2)
        }
        assertTrue {
            digital(aDig)
        }
        println("Prueba superada ✔")
    }

    @Test
    fun probarPalabraMasLarga() {
        val verbos = TBinTree<String>(
            "comer",
            TBinTree(
                "cenar",
                TBinTree("partir", TBinTree("Tener"), TBinTree("sufrir")),
                TBinTree("internacionalizar")
            ),
            TBinTree(
                "exponer",
                TBinTree(
                    "pedir",
                    TBinTree("sanar"),
                    TBinTree("mecer")
                ),
                TBinTree("doler")
            )
        )

        assertEquals("internacionalizar", palabraMasLarga(verbos))
        assertEquals("", palabraMasLarga(TBinTree<String>()))
        assertEquals("perro", palabraMasLarga(TBinTree("gato", TBinTree("rojo"), TBinTree("perro"))))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaProductoMasCaro() {
        val arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 85.0),
                    TBinTree(Producto("Agua", 311.0), TBinTree(), TBinTree()),
                    TBinTree(Producto("Pollo", 179.0), TBinTree(), TBinTree())
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0), TBinTree(), TBinTree())
                )
            ),
            TBinTree(
                Producto("Pescado", 61.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0), TBinTree(), TBinTree()),
                    TBinTree()
                )
            )
        )

        val prod = productoMasCaro(arbProds)
        assertNotNull(prod)
        assertEquals("Agua", prod!!.nombre)
        println("Prueba superada ✔")
    }

    @Test
    fun probarPromedioPrecios() {
        val arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 85.0),
                    TBinTree(Producto("Agua", 311.0), TBinTree(), TBinTree()),
                    TBinTree(Producto("Pollo", 179.0), TBinTree(), TBinTree())
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0), TBinTree(), TBinTree())
                )
            ),
            TBinTree(
                Producto("Pescado", 61.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0), TBinTree(), TBinTree()),
                    TBinTree()
                )
            )
        )

        assertEquals(193.75, promedioPrecios(arbProds))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaNomProductosPrecioInferiorPromedio() {
        val arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 85.0),
                    TBinTree(Producto("Agua", 311.0), TBinTree(), TBinTree()),
                    TBinTree(Producto("Pollo", 179.0), TBinTree(), TBinTree())
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0), TBinTree(), TBinTree())
                )
            ),
            TBinTree(
                Producto("Pescado", 61.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0), TBinTree(), TBinTree()),
                    TBinTree()
                )
            )
        )

        assertEquals(
            listOf("Banana", "Brocoli", "Café", "Carne", "Pescado", "Pollo"),
            productosInferiorPromedio(arbProds).sorted()
        )
        println("Prueba superada ✔")
    }

    @Test
    fun probarEncontrarPrecioProducto() {
        val arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 85.0),
                    TBinTree(Producto("Agua", 311.0), TBinTree(), TBinTree()),
                    TBinTree(Producto("Pollo", 179.0), TBinTree(), TBinTree())
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0), TBinTree(), TBinTree())
                )
            ),
            TBinTree(
                Producto("Pescado", 61.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0), TBinTree(), TBinTree()),
                    TBinTree()
                )
            )
        )

        assertEquals(189.0, encontrarPrecioProducto(arbProds, "Banana"))
        assertNull(encontrarPrecioProducto(arbProds, "Perro"))
        assertEquals(309.0, encontrarPrecioProducto(arbProds, "Jamón"))
        println("Prueba superada ✔")
    }

    @Test
    fun probarContarProductosNombreComienzanConLetra() {
        val arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 85.0),
                    TBinTree(Producto("Agua", 311.0), TBinTree(), TBinTree()),
                    TBinTree(Producto("Pollo", 179.0), TBinTree(), TBinTree())
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0), TBinTree(), TBinTree())
                )
            ),
            TBinTree(
                Producto("Pescado", 61.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0), TBinTree(), TBinTree()),
                    TBinTree()
                )
            )
        )

        assertEquals(0, contarProductosNombreComienzanConLetra(arbProds, 'M'))
        assertEquals(2, contarProductosNombreComienzanConLetra(arbProds, 'B'))
        assertEquals(3, contarProductosNombreComienzanConLetra(arbProds, 'P'))
        println("Prueba superada ✔")
    }

    @Test
    fun probarInventarioCorrecto() {
        var arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 85.0),
                    TBinTree(Producto("Agua", 311.0), TBinTree(), TBinTree()),
                    TBinTree(Producto("Pollo", 179.0), TBinTree(), TBinTree())
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0), TBinTree(), TBinTree())
                )
            ),
            TBinTree(
                Producto("Pescado", 61.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0), TBinTree(), TBinTree()),
                    TBinTree()
                )
            )
        )

        assertFalse { inventarioCorrecto(arbProds) }

        arbProds = TBinTree<Producto>(
            Producto("Papa", 300.0),
            TBinTree(
                Producto("Carne", 120.0),
                TBinTree(
                    Producto("Café", 185.0),
                    TBinTree(Producto("Agua", 311.0)),
                    TBinTree(Producto("Pollo", 179.0))
                ),
                TBinTree(
                    Producto("Queso", 217.5), TBinTree(),
                    TBinTree(Producto("Banana", 189.0))
                )
            ),
            TBinTree(
                Producto("Pescado", 161.0), TBinTree(),
                TBinTree(
                    Producto("Jamón", 309.0),
                    TBinTree(Producto("Brocoli", 166.0)),
                    TBinTree()
                )
            )
        )
        assertTrue { inventarioCorrecto(arbProds) }
        println("Prueba superada ✔")
    }
}