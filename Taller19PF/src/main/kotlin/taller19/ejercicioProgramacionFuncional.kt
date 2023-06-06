package taller19

import ean.colecciones.Lista
import ean.colecciones.listaVacia
import kotlin.math.sqrt


// Esta clase guarda la información de un producto de una tienda
data class Producto(val codigo: Int, val nombre: String, val cantidad: Int, val precio: Int)

// Esta clase guarda la información de un departamento del país
data class Departamento(
    val nombre: String,
    val poblacion: Int,
    val superficie: Double,
    val densidad: Double,
    val IDH: Double,
    val añoCreacion: Int)

// Esta clase guarda la información de un municipio del pais
data class Municipio(
    val codigo: Int,
    val nombre: String,
    val departamento: String,
    val poblacionUrbana: Int,
    val poblacionRural: Int,
    val esCapital: Boolean
)

// Esta clase guarda la información de un rectángulo
data class Rectangulo(val base: Double, val altura: Double) {
    // Hallar el área del rectangulo
    fun area(): Double = base * altura
}

// Esta clase guarda la información de un triángulo
data class Triangulo(val id: Int,
                     val lado1: Double,
                     val lado2: Double,
                     val lado3: Double)

//-------------------------------------------------------------------
// Operaciones con la clase Departamento
//-------------------------------------------------------------------

/**
 * Obtener el nombre del departamento más antiguo de toda la lista.
 * Si la lista está vacía, retorne null
 */
fun metodo6(dptos: Lista<Departamento>): String? {
    val dept=dptos.encontrarMenor { it.añoCreacion }
    return dept!!.nombre
}

/**
 * Retorna el  departamento que tiene la superficie más grande
 * pero con una población superior a la población que se pasa
 * como parámetro.
 */
fun metodo7(dptos: Lista<Departamento>, poblacion: Int): Departamento? {
    val PoblacionMayor=dptos.filtrar { it.poblacion > poblacion }
    val mayorSuperficie=PoblacionMayor.encontrarMayor { it.superficie }
    return mayorSuperficie
}

/**
 * Retorne la lista de los nombres de los departamentos creados
 * en el siglo XX y que tenga un IDH entre 0.85 y 0.95
 */
fun metodo8(dptos: Lista<Departamento>): Lista<String> {
    val iDHFiltro=dptos.filtrar { it.IDH in 0.85 .. 0.95 }
    val filtroSigloXX=iDHFiltro.filtrar { it.añoCreacion in 1900 .. 1999 }
    //Transforma la lista de objetos en una lista de strings
    return filtroSigloXX.transformar { it.nombre }
}

/**
 * Retorne el porcentaje de departamentos de la lista cuya densidad
 * esté por debajo del valor que se pasa como parámetro
 */
fun metodo9(deptos: Lista<Departamento>, valor: Double): Double {
    val densidad=deptos.contar { it.densidad < valor }
    return densidad*100.0/deptos.tam
}

/**
 * Retorne el promedio de superficie de los departamentos de la lista
 * cuya poblacion sea superior a la población del departamento con menor
 * IDH de toda la lista
 */
fun metodo10(deptos: Lista<Departamento>): Double {
    val menorIDH=deptos.encontrarMenor { it.IDH }
    val pol=deptos.filtrar { it.poblacion > menorIDH!!.poblacion }
    val elem:(Departamento) -> Int = { it.superficie.toInt() }
    val sum= pol.sumar(elem)
    return sum/pol.tam.toDouble()
}

//-------------------------------------------------------------------
// Operaciones con la clase Municipio
//-------------------------------------------------------------------

/**
 * Determinar y retornar cuántos municipios de la lista son capitales
 */
fun metodo11(muns: Lista<Municipio>): Int {
    return muns.contar { it.esCapital }
}

/**
 * Determinar el nombre del municipio que no es capital y que pertenece al
 * departamento que se recibe como parámetro y que tiene la población urbana
 * más grande
 */
fun metodo12(m: Lista<Municipio>, depto: String): String {
    val noCapital=m.filtrar { !it.esCapital }
    val dpto=noCapital.filtrar { it.departamento == depto}
    val PoblaciónUrMasGrande=dpto.encontrarMayor { it.poblacionUrbana }
    return PoblaciónUrMasGrande!!.nombre
}

/**
 * Retornar el promedio de la población total (suma de la población rural y población urbana)
 * de aquellos municipios de la lista que pertenecen al departamento que se pasa
 * como parámetro y cuyo código sea múltiplo de 3 o de 5
 */
fun metodo13(municipios: Lista<Municipio>, departamento: String): Double {
    val pertenecen=municipios.filtrar { it.departamento == departamento }
    val codigo=pertenecen.filtrar { it.codigo % 3 ==0  || it.codigo % 5 == 0 }
    val elem: (Municipio) -> Int = { it.poblacionRural + it.poblacionUrbana }
    val suma= codigo.sumar(elem)
    return suma/codigo.tam.toDouble()
}

/**
 * Retorne el nombre del primer municipio que inicia con J en toda la lista
 */
fun metodo14(muns: Lista<Municipio>): String {
    val inicaJ=muns.encontrarElPrimeroQueCumple { it.nombre.first() == 'J'}
    return inicaJ!!.nombre
}


/**
 * Retorne cuantos municipios de la lista que tienen un código
 * de 4 dígitos poseen una poblacion rural superior a la población
 * urbana
 */
fun metodo15(muns: Lista<Municipio>): Int {
    val cod4Digi=muns.filtrar { it.codigo in 1000 .. 9999 }
    val polRulMayorPolUrb= cod4Digi.filtrar { it.poblacionRural > it.poblacionUrbana }
    return polRulMayorPolUrb.tam
}

//-------------------------------------------------------------------
// Operaciones con la clase Producto
//-------------------------------------------------------------------

/**
 * Obtener el nombre de todos los productos cuyo código es par
 */
fun metodo1(productos: Lista<Producto>): Lista<String> {
    //filtra los productos con código par
    val lista1= productos.filtrar { it.codigo % 2 ==0 }
    //Transforme la lista en los productos, con los datos que ya fueron obtenido de la lista1
    val lista2= lista1.transformar { it.nombre }
    return lista2
    //no es necesario un for o while
    /** O también se puede:
     * fun metodo1(productos: Lista<Producto>): Lista<String> =

     * productos.filtrar { it.codigo % 2 ==0 }
     *     .transformar { it.nombre }
     *     para dejar más corto.
     */
}

/**
 * Obtener cuántos productos tienen un precio inferior al producto
 * cuyo código se pasa como parámetro
 */
fun metodo2(productos: Lista<Producto>, codProducto: Int): Int {
    //Encontrar el primer producto cuyo código pide el que se pasa cómo parámetro
    val prod=productos.encontrarElPrimeroQueCumple { it.codigo == codProducto }
    // el .tam es para que retorne el tamaño de los productos que filtraron
    //Se le pone doble signo de admiración porque no se sabe si existe el producto.
    return productos.filtrar { it.precio < prod!!.precio }.tam

    // Ó también:
    //return producto.contar{ it. precio < prod!!.precio}
}

/**
 * Obtener una lista con los códigos de los productos cuya cantidad sea
 * superior a la cantidad mínima que se pasa como parámetro y cuyo precio
 * esté entre mil y diez mil pesos.
 *
 */
fun metodo3(productos: Lista<Producto>, cantidadMinima: Int): Lista<Int> {
    val list=productos.filtrar { it.cantidad > cantidadMinima }
    val list2= productos.filtrar { it.precio in 1000.. 10000 }
    //obtener la lista con el código
    return list2.transformar { it.codigo }
}

/**
 * EL inventario total de la lista es la suma de la multiplicación de la cantidad por el precio
 * de todos y cada uno de los productos de la lista. Este método permite saber si el
 * inventario de la lista es superior al millón de pesos o no.
 */
fun metodo4(prods: Lista<Producto>): Boolean {
    //Criterio saca cada elemento de la lista y toma lo que va a sumar hay que especificarlo
    val criterio: (Producto) -> Int = { it.precio * it.cantidad  }
    return prods.sumar(criterio) > 1_000_000
}

/**
 * Obtener el promedio de la cantidad de aquellos productos cuyo precio
 * esté por debajo del promedio de precio de todos los productos de la lista
 */
fun metodo5(prods: Lista<Producto>): Double {
    //Promedio precio Todos los productos
    val elem: (Producto) -> Int = { it.precio }
    val sum= prods.sumar(elem)
    val promPrecio= sum/prods.tam

    //Promedio Cantidad productos por precio precio por debajo del promedio del precio
    val product= prods.filtrar { it.precio < promPrecio }
    val elem2: (Producto) -> Int = {it.cantidad}
    val sum2=product.sumar(elem2)
    // El tamaño de los productos precio por debajo dividido todos los productos de la lista
    return sum2/product.tam.toDouble()

}

//-------------------------------------------------------------------
// Operaciones con la clase Rectangulo
//-------------------------------------------------------------------

/**
 * Retorna el número de rectángulos que también son cuadrados
 */
fun metodo16(rects: Lista<Rectangulo>): Int {
    val cua= rects.filtrar { it.altura == it.base }
    return cua.tam

}

/**
 * Obtiene el promedio del área de los rectángulos cuya base es inferior a su altura
 */
fun metodo17(rects: Lista<Rectangulo>): Double {
    //Tomar elementos area
    val elemArea: (Rectangulo) -> Int = {it.area().toInt()}

    //Filtrar rectangulos base < altura
    val rectBaseMenorAltura=rects.filtrar { it.base < it.altura }
    //sumar áreas filtradas de la lista rectBaseMenorAltura
    val areasFiltradas=rectBaseMenorAltura.sumar(elemArea)
    return areasFiltradas/rectBaseMenorAltura.tam.toDouble()
}

/**
 * Obtiene el rectángulo de mayor área de la lista
 */
fun metodo18(rects: Lista<Rectangulo>): Rectangulo {
    val mayorArea= rects.encontrarMayor { it.area().toInt() }
    return mayorArea!!
}

/**
 * Obtiene la lista con las diagonales de aquellos cuadrados cuya área sea
 * superior al área que se pasa como parámetros
 */
fun metodo19(rects: Lista<Rectangulo>, areaMin: Double): Lista<Double> {
    val areaSuperior= rects.filtrar { it.area() > areaMin }
    val getArea= areaSuperior.transformar { hypot(it.base, it.altura) }
    return getArea
}

/**
 * Halla la hipotenusa del triángulo rectángulo que tiene los catetos a y b
 */
fun hypot(a: Double, b: Double): Double = sqrt((a*a) + (b*b))

/**
 * Un triangulo es rectangulo si un lado (el mas largo) es igual a la raiz cuadrada de
 * la suma de los cuadrados de los otros dos lados
 */
fun esRectangulo(t: Triangulo): Boolean {
    var masLargo1=0.0
    var masLargo2=0.0
    var masLargo3=0.0
    var raiz=0.0
    if (t.lado1 > t.lado2 && t.lado1 > t.lado3) {
        masLargo1=t.lado1
        raiz = sqrt(Math.pow(t.lado2,2.0)+ Math.pow(t.lado3,2.0))
        if (raiz == masLargo1) {
            return true
        }
    }else if (t.lado1 < t.lado2 && t.lado2 > t.lado3) {
        masLargo2=t.lado2
        raiz = sqrt(Math.pow(t.lado1,2.0)+ Math.pow(t.lado3,2.0))
        if (raiz == masLargo2) {
            return true
        }
    }else if (t.lado1 < t.lado3 && t.lado2 < t.lado3) {
        masLargo3 = t.lado3
        raiz = sqrt(Math.pow(t.lado2, 2.0) + Math.pow(t.lado1, 2.0))
        if (raiz == masLargo3) {
            return true
        }
    }
    return false
}

/**
 * Hallar el área del triángulo que se pasa como parámetro
 */
fun areaTriangulo(t: Triangulo): Double {
    //Perimetro
    var p= t.lado1+t.lado2+t.lado3
    //Semiperimetro
    var s=p/2
    return sqrt(s*(s-t.lado1)*(s-t.lado2)*(s-t.lado3))
}

/**
 * Retorna la lista de las áreas de aquellos triángulos rectángulos de la lista
 */
fun metodo20(triangulos: Lista<Triangulo>): Lista<Double> {
    val esRect=triangulos.filtrar { esRectangulo(it) }
    return esRect.transformar { areaTriangulo(it) }

}

/**
 * Obtiene la lista de los identificadores de aquellos triángulos isosceles cuya área no supera a 10
 */
fun metodo21(triangulos: Lista<Triangulo>): Lista<Int> {
    val esIso=triangulos.filtrar { !esRectangulo(it) && (it.lado1 == it.lado2 || it.lado1 == it.lado3) }
    return esIso.transformar { it.id }
}
