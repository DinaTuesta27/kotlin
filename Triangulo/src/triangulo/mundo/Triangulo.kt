/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Triangulo
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package triangulo.mundo

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Clase que representa un triángulo.
 */
class Triangulo {
    // -----------------------------------------------------------------
    // Atributos
    //Realizado por: GUSTAVO SANDOVAL Y DINA TUESTA
    // -----------------------------------------------------------------
    /**
     * Primer punto del triángulo.
     */
    private val punto1: Punto = Punto(200.0, 50.0)

    /**
     * Segundo punto del triángulo.
     */
    private val punto2: Punto = Punto(300.0, 200.0)

    /**
     * Tercer punto del triángulo.
     */
    private val punto3: Punto = Punto(100.0, 200.0)

    /**
     * Color de las líneas.
     */
    private val colorLineas: Color = Color(60, 168, 56)

    /**
     * Color del relleno.
     */
    private val colorRelleno: Color = Color(0, 83, 24)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el punto 1 del triángulo.
     * @return Punto 1.
     */
    fun darPunto1(): Punto {
        return punto1

    }

    /**
     * Retorna el punto 2 del triángulo.
     * @return Punto 2.
     */
    fun darPunto2(): Punto {
        return punto2

    }

    /**
     * Retorna el punto 3 del triángulo.
     * @return Punto 3.
     */
    fun darPunto3(): Punto {
        return punto3
    }

    /**
     * Retorna el color de las líneas del triángulo.
     * @return Color de las líneas.
     */
    fun darColorLineas(): Color {
        return colorLineas
    }

    /**
     * Retorna el color del relleno del triángulo.
     * @return Color del relleno.
     */
    fun darColorRelleno(): Color {
        return colorRelleno
    }

    /**
     * Retorna el perímetro del triángulo.
     * @return Perímetro del triángulo.
     */
    fun darPerimetro(): Double {
        // Retorna la suma de todos los lados
        return calcularLado1()+calcularLado2()+calcularLado3()
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br></br>
     * @return Área del triángulo.
     */
    fun darArea(): Double {
        // Calcula y devuelve el área
        when {
            calcularLado1() + calcularLado2() + calcularLado3() > 0 -> {
                val s = (calcularLado1() + calcularLado2() + calcularLado3()) / 2
                return Math.sqrt(s * (s - calcularLado1()) * (s - calcularLado2()) * (s - calcularLado3()))
            }
            // Calcula y devuelve el área return 0.0
            else -> return 0.0
        }
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br></br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     * @return Altura del triángulo.
     */
    fun darAltura(): Double {
        return 2 * darArea() / calcularLado1()
    }
    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    private fun calcularLado1(): Double {
        // calcula la distancia
        val a=punto1.darX()
        val b=punto1.darY()
        val c=punto2.darX()
        val d=punto2.darY()
        return sqrt((c-a).pow(2)+(d-b).pow(2))
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    private fun calcularLado2(): Double {
        // calcula la distancia
        val a=punto2.darX()
        val b=punto2.darY()
        val c=punto3.darX()
        val d=punto3.darY()
        return sqrt((c-a).pow(2)+(d-b).pow(2))

    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    private fun calcularLado3(): Double {
        // calcula la distancia
        val a=punto3.darX()
        val b=punto3.darY()
        val c=punto1.darX()
        val d=punto1.darY()
        return sqrt((c-a).pow(2)+(d-b).pow(2))
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     * @param pX1 Coordenada X del vértice de referencia.
     * @param pY1 Coordenada Y del vértice de referencia.
     * @param pX2 Coordenada X del vértice opuesto 1.
     * @param pY2 Coordenada Y del vértice opuesto 1.
     * @param pX3 Coordenada X del vértice opuesto 2.
     * @param pY3 Coordenada Y del vértice opuesto 2.
     * @return Ángulo opuesto entre vértice de referencia y los otros dos vértices.
     */
    fun calcularAnguloOpuesto(pX1: Double, pY1: Double, pX2: Double, pY2: Double, pX3: Double, pY3: Double): Double {
        // Ángulo 1
        var angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1)

        // Ángulo 2
        var angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1)

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = if (angulo1 < 0) angulo1 + 2.0 * Math.PI else angulo1
            angulo2 = if (angulo2 < 0) angulo2 + 2.0 * Math.PI else angulo2
        }

        // Calcula el ángulo opuesto
        var anguloOpuesto = (angulo1 + angulo2) / 2.0 + Math.PI
        anguloOpuesto = anguloOpuesto % (2.0 * Math.PI)
        return anguloOpuesto
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto1(pX: Double, pY: Double) {
        this.punto1.cambiarX(pX)
        pX>0
        this.punto1.cambiarY(pY)
        pY>0
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto2(pX: Double, pY: Double) {
        this.punto2.cambiarX(pX)
        pX>0
        this.punto2.cambiarY(pY)
        pY>0
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto3(pX: Double, pY: Double) {
        this.punto3.cambiarX(pX)
        pX>0
        this.punto3.cambiarY(pY)
        pY>0
    }

    /**
     * Cambia el color de relleno del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorRelleno(pRojo: Int, pVerde: Int, pAzul: Int) {
        this.colorRelleno.cambiarRojo(pRojo)
        pRojo>=0
        this.colorRelleno.cambiarVerde(pVerde)
        pVerde>=0
        this.colorRelleno.cambiarAzul(pAzul)
        pAzul>=0
    }

    /**
     * Cambia el color de la líneas del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorLineas(pRojo: Int, pVerde: Int, pAzul: Int) {
        this.colorLineas.cambiarRojo(pRojo)
        pRojo>=0
        this.colorLineas.cambiarVerde(pVerde)
        pVerde>=0
        this.colorLineas.cambiarAzul(pAzul)
        pAzul>=0
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Permite obtener el tipo del triángulo
     * "equilátero" si los tres lados son iguales
     * "isosceles" si dos lados son iguales
     * "escaleno" si los tres lados son diferentes
     */
    fun tipo(): String {
        when {
            calcularLado1() == calcularLado2() &&  calcularLado2() == calcularLado3() -> return "equilátero"
            calcularLado1() == calcularLado2() || calcularLado2() == calcularLado3() || calcularLado1() == calcularLado3() -> return "isosceles"
            else -> return "escaleno"
        }
    }

    /**
     * Permite obtener el punto en el centro del triángulo, conocido como el centroide
     */
    fun centroide(): Punto {
        val a=punto1.darX()
        val b=punto1.darY()
        val c=punto2.darX()
        val d=punto2.darY()
        val e=punto3.darX()
        val f=punto3.darY()
        return Punto(a+c+e/3, b+d+f/3)
    }

}

/**
 * Permite obtener el punto que se encuentra en el incentro del triángulo t
 * El incentro es el punto donde las bisectrices de los tres ángulos internos
 * se intersecan.
 * https://www.neurochispas.com/wiki/incentro-de-un-triangulo-definicion-formulas-y-ejemplos/
 */
fun incentro(t: Triangulo): Punto {
val lado1X=t.darPunto1().darX()
val lado1Y=t.darPunto1().darY()
val lado2X=t.darPunto2().darX()
val lado2Y=t.darPunto2().darY()
val lado3X=t.darPunto3().darX()
val lado3Y=t.darPunto3().darY()

val longitud1=sqrt((lado2X-lado1X).pow(2)+(lado2Y-lado1Y).pow(2))
val longitud2=sqrt((lado3X-lado2X).pow(2)+(lado3Y-lado2Y).pow(2))
val longitud3=sqrt((lado1X-lado3X).pow(2)+(lado1Y-lado3Y).pow(2))
val longitudX=longitud1*lado1X+longitud2*lado2X+longitud3*lado3X
val longitudY=longitud1*lado1Y+longitud2*lado2Y+longitud3*lado3Y
val longitudTotal=longitud1+longitud2+longitud3
return Punto(longitudX/longitudTotal,longitudY/longitudTotal)


}
