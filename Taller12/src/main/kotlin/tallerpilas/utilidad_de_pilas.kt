package tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Facultad de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Marzo 15, 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IStack
import ean.collections.TLinkedStack

/**
 * Objeto que permite convertir una expresión infija normal a una expresión en notación
 * postfija. Utiliza pilas para realizar la conversión.
 */
object Evaluador {

    //-------------------------------------
    // Métodos REALIZADO POR: GUSTAVO SANDOVAL Y DINA TUESTA
    //-------------------------------------

    /**
     * Verifica que la expresión tiene los símbolos de agrupación
     * bien balanceados
     * @return true si la expresión está balanceados
     */
    fun estánSímbolosAgrupaciónBalanceados(expresion: List<String>): Boolean {
        val pilaSimbolos: IStack<String> = TLinkedStack()
        for (element in expresion) {
            if (element=="(" || element=="[" || element=="{") {
                pilaSimbolos.push(element)
            }else if (element==")" || element=="]" || element=="}") {
                if (pilaSimbolos.isEmpty) {
                    return false
                }
                pilaSimbolos.peek()
                pilaSimbolos.pop()
                if ((element=="(" && pilaSimbolos.peek()!=")") || (element=="["
                            && pilaSimbolos.peek()!="]") || (element=="{"
                            && pilaSimbolos.peek()!="}")) {
                    return false
                }
            }
        }
        if (!pilaSimbolos.isEmpty) {
            return false
        }
        return true
    }

    /**
     * Transforma la expresión,
     * cambiando los simbolos de agrupación [] y {} por ()
     */
    //El unit significa que la función no retorna nada.
    //me falta hacer que la función me retorne la expresión con los paréntesis
    fun reemplazarDelimitadoresPorParéntesis(expresion: MutableList<String>): Unit {
        val pilaSimbolos: IStack<String> = TLinkedStack()
        for (element in expresion) {
            if (element=="[" || element=="{") {
                pilaSimbolos.push("(")
            }else if (element=="]" || element=="}") {
                pilaSimbolos.push(")")
            }
        }
        for (i in 0 until expresion.size) {
            if (expresion[i]=="[" || expresion[i]=="{") {
                expresion[i]="("
            }else if (expresion[i]=="]" || expresion[i]=="}") {
                expresion[i]=")"
            }
        }
    }
    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     */
    fun convertirAPostfijo(expresion: List<String>): List<String> {
        val pila: IStack<String> = TLinkedStack()
        val lista = mutableListOf<String>()
        for (dato in expresion) {
            if (dato=="+" || dato=="-" || dato=="*" || dato=="/" || dato=="%") {
                pila.push(dato)
            }else if (dato==")") {
                val elem= pila.peek()
                lista.add(elem)
                pila.pop()
            }else if (dato.toIntOrNull()!=null || dato!="(") {
                lista.add(dato)
            }
        }
        return lista;
    }

    /**
     * Realiza la evaluación de la expresión postfija almacenada en la lista
     * llamada "expresión". Realiza las operaciones de acuerdo al algoritmo
     * presentado.
     */
    fun evaluarExpresiónPostfija(expression: List<String>): Int {
        val pila: IStack<Int> = TLinkedStack()
        for (dato in expression) {
            if (dato.toIntOrNull() != null) {
                pila.push(dato.toInt())
            } else if (dato == "+" || dato == "-" || dato == "*" || dato == "/" || dato == "%") {
                if (dato == "+") {
                    val elem1 = pila.peek()
                    pila.pop()
                    val elem2 = pila.peek()
                    pila.pop()
                    val elem3 = elem1 + elem2
                    pila.push(elem3)
                } else if (dato == "-") {
                    val elem1 = pila.peek()
                    pila.pop()
                    val elem2 = pila.peek()
                    pila.pop()
                    val elem3 = elem2 - elem1
                    pila.push(elem3)
                } else if (dato == "*") {
                    val elem1 = pila.peek()
                    pila.pop()
                    val elem2 = pila.peek()
                    pila.pop()
                    val elem3 = elem1 * elem2
                    pila.push(elem3)
                } else if (dato == "/") {
                    val elem1 = pila.peek()
                    pila.pop()
                    val elem2 = pila.peek()
                    pila.pop()
                    val elem3 = elem2 / elem1
                    pila.push(elem3)
                } else if (dato == "%") {
                    val elem1 = pila.peek()
                    pila.pop()
                    val elem2 = pila.peek()
                    pila.pop()
                    val elem3 = elem2 % elem1
                    pila.push(elem3)
                }
            }
        }
        return pila.peek()
    }
}
