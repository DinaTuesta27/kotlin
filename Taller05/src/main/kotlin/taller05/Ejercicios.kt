/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Geometría
 * Autor: Universidad EAN - 07 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller05

import kotlin.math.pow
import kotlin.math.sqrt


/**
 * Ejercicio 5
 */
fun ejercicio05(r: Double): Double {
    var cp=Circulo(r) //el pequeño
    var cg=Circulo(2*r) //el grande
    return cg.area()-cp.area()
}

/**
 * Ejercicio 6
 */
fun ejercicio06(u: Double): Double {
    var c=Cuadrado(2*u)
    var r=Rectangulo(3*u,4*u)
    var t=Triangulo(3*u,4*u)
    return c.area()+r.area()+t.area()
}

/**
 * Ejercicio 07
 */
fun ejercicio07(x: Double): Double {
    var cir=Circulo(x/2)
    var cua=Cuadrado(x)
    return cua.area()-cir.area()
}

/**
 * Ejercicio 08 - Hipotenusa
 */
fun ejercicio08(tri: Triangulo): Double {
    var h=tri.altura
    var b=tri.base
    return sqrt(h.pow(2)+b.pow(2))
}

/**
 * Ejercicio 09
 */
fun ejercicio09(a: Double, b: Double): Double {
    var ca=Triangulo(a,b)
    var hip= ejercicio08(ca)
    var c=Circulo(hip/2)
    //El área der circulo va sobre dos porque es la mitad del circulo
    return c.area()/2+ca.area()

}

/**
 * Ejercicio 10
 */
fun ejercicio10(r: Double): Double {
    var cua=Cuadrado(sqrt(r.pow(2)+r.pow(2)))
    var ci=Circulo(r)
    return ci.area()-cua.area()
}

/**
 * Ejercicio 11
 */
fun ejercicio11(r: Double, a: Double): Double {
    var cG=Circulo(r)
    var cP=Circulo(r-a)
    return cG.area()/2-cP.area()/2
}

/**
 * Ejercicio 12
 */
fun ejercicio12(x: Double, y: Double, z: Double): Double {
    var t=Triangulo(y,z-x)
    var rec=Rectangulo(y,x)
    return (t.area()+rec.area())
}

/**
 * Ejercicio 13
 */
fun ejercicio13(a: Double, b: Double, c: Double, d: Double, e: Double): Double {
    var r=Rectangulo(e,c)
    var tri=Triangulo(e,d-c)
    var puerta=Rectangulo(a,b)
    return (r.area()-puerta.area())+tri.area()
}
