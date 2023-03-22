/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Exposición Canina.
 * Fecha: Marzo 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller09


/**
 * Un perro es un objeto que participa en una
 * exposición canina, con los atributos que
 * se muestran a continuación.
 */
data class Perro(val placa: String,  // El identificador del perro
                 val nombre: String, // El nombre del perro
                 val raza: String,   // La raza del perro
                 val edad: Int,      // La edad en años del perro,
                 var puntos: Int     // El puntaje en la exposicion
                 ) {
    // Retorna el año en que nació el perro, suponiendo que estamos en 2023
    fun añoNacimiento(): Int {
        return 2023-edad
    }
}

// --------------------------------------------------------------------------

/**
 * Un nodo es un objeto especial capaz de referenciar a otro objeto
 * de la misma clase. En este caso usaremos un nodo sencillamente
 * encadenado que tiene un solo nodo siguiente.
 */
class NodoPerro(var info: Perro, var siguiente: NodoPerro? = null)

// ---------------------------------------------------------------------------

/**
 * Es la clase que se encarga de manejar, organizar, almacenar los perros.
 * No hay dos perros con la misma placa
 */
class ExposicionPerros() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia al primero perro de la lista
     */
    var primero: NodoPerro? = null

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de nodos en la lista
     */
    fun numPerros(): Int {
        var p=primero
        var c=0
        while (p!=null) {
            c++
            p=p!!.siguiente
        }
        return c
    }

    /**
     * La función recorre la lista buscando al perro que tiene la placa
     * que se pasa como parámetro. Retorna true si encontró el perro con
     * la placa y false si ningún perro tiene esa placa.
     */
    fun existePerro(placa: String): Boolean {
        var p=primero
        while (p!=null) {
            if (p!!.info.placa==placa) {
                return true
            }
            p=p!!.siguiente
        }
        return false
    }

    /**
     * Encuentra y retorna el perro que tiene la placa que se
     * pasa como parámetro.
     *
     * Si no existe ningún perro con esa placa, debe retornarse
     * null.
     */
    fun obtenerPerroConPlaca(placa: String): Perro? {
        var p=primero
        while (p!=null) {
            if (p!!.info.placa==placa) {
                return p.info
            }
            p=p!!.siguiente
        }
        return null
    }

    /**
     * Obtiene el perro que se encuentra en la posición
     * dada de la lista de nodos. Si la posición supera
     * al último nodo de la lista, deberá retornarse null.
     *
     * Las posiciones van desde cero en adelante.
     */
    fun obtenerPerroEnPosicion(posicion: Int): Perro? {
        require(posicion >= 0)

        var p=primero
        var c=0
        //si la lista no está vacía
        while (p != null) {
            if (c==posicion) {
                return p.info
            }
            c++
            p=p.siguiente
        }
        return null
    }

    /**
     * Obtiene la posición dentro de la lista de nodos
     * donde se encuentra el perro que tiene la placa
     * que se pasa como parámetro.
     *
     * Si no existe un perro con esa placa dentro de la
     * lista de nodos, se debe retornar el valor -1
     */
    fun obtenerPosicionPerro(placa: String): Int {
        if (existePerro(placa)==false) {
            return -1
        }

        var p=primero
        //para hallar la posición se empieza en -1
        //se le suma uno cada vez que el while se ejecuta
        var c=-1
        while (p!=null) {
            c++ // empieza en posición 0
            if (p.info.placa==placa) {
                return c
            }
            p=p!!.siguiente
        }
        return 0
    }

    /**
     * Crea un nodo con el perro dado dentro de él y lo coloca de primero
     * en la lista de nodos sencillamente encadenados.
     *
     * Si ya existe un perro con la misma placa que perro.placa debe
     * retornarse false. Si se pudo agregar el perro al principio de
     * la lista de nodos, se debe retornar true.
     */
    fun agregarAlPrincipio(perro: Perro): Boolean {
        if (existePerro(perro.placa)) {
            return false
        }
        //creamos el nodo
        val nodo=NodoPerro(perro)
        if (primero == null) {
            primero = nodo
        } else {
            nodo.siguiente=primero
            primero=nodo
        }
        return true
    }

    /**
     * Crea un nodo con el perro dado dentro de él y lo coloca de último
     * en la lista de nodos sencillamente encadenados.
     *
     * Si ya existe un perro con la misma placa que perro.placa debe
     * retornarse false. Si se pudo agregar el perro al principio de
     * la lista de nodos, se debe retornar true.
     */
    fun agregarAlFinal(perro: Perro): Boolean {

        if (existePerro(perro.placa)) {
            return false
        }

        val nodo=NodoPerro(perro)
        var p=primero
        if (primero==null) {
            primero=nodo
        } else {
            while (p!!.siguiente != null) {
                p = p!!.siguiente
            }
            p!!.siguiente = nodo
        }
        //fuera del else
        return true
    }

    /**
     * Crea un nodo con el perro dado dentro de él y lo coloca en la
     * posición indicada. Si la posición es superior al número de
     * nodos en la lista, deberá agregarse el nuevo nodo al final
     * de la lista.
     *
     * Si ya existe un perro con la misma placa que perro.placa debe
     * retornarse false. Si se pudo agregar el perro al principio de
     * la lista de nodos, se debe retornar true.
     */
    fun agregarEnPosicion(posicion: Int, perro: Perro): Boolean {
        require(posicion >= 0)
        if (existePerro(perro.placa)) {
            return false
        }
        when {
            posicion == 0-> return agregarAlPrincipio(perro)
            posicion >= numPerros()->return agregarAlFinal(perro)
            else->{
                val nodo=NodoPerro(perro)
                var p=primero
                // avanzar tantos nodos hasta la posición pedida
                for (i in 0 until posicion-1) {
                    p=p!!.siguiente
                }
                nodo.siguiente=p!!.siguiente
                p!!.siguiente=nodo
                return true
            }
        }
        return false
    }

    /**
     * Elimina el nodo del perro que está de primero en la lista
     * de nodos.
     *
     * El método retorna false si la lista está vacía y
     * debe retornar true en caso contrario (indicando
     * que se pudo eliminar el nodo).
     */
    fun eliminarPrimero(): Boolean {
        if (primero==null) {
            return false
        }
        primero=primero!!.siguiente
        return true
    }

    /**
     * Elimina el nodo que está de último en la lista
     * de nodos.
     *
     * El método retorna false si la lista está vacía y
     * debe retornar true en caso contrario (indicando
     * que se pudo eliminar el nodo).
     */
    fun eliminarUltimo(): Boolean {
        var p = primero
        //Si no hay nada
        if (primero == null) {
            return false
        }
        //Si sólo hay un nodo primero queda en nulo
        else if (p!!.siguiente==null) {
            primero=null
        } else {
            while (p!!.siguiente!!.siguiente != null) {
                p = p!!.siguiente
            }
            p!!.siguiente = null
        }
        return true


    }

    /**
     * Elimina de la lista el nodo que se encuentra en
     * la posición dada. Esta posición debe estar entre
     * 0 y el número de nodos - 1.
     *
     * El método debe retornar true si la posición es
     * válida (indicando que se pudo eliminar el nodo)
     * y debe retornar false si la posición es inválida
     */
    fun eliminarPosicion(posicion: Int): Boolean {
        //Por si la posición es negativa
        if (posicion<0) {
            return false
        }
        //Por si la posición es mayor a la cantidad de nodos
        if (posicion>=numPerros()) {
            return false
        }
        when {
            posicion == 0-> return eliminarPrimero()
            posicion == numPerros()-1 ->return eliminarUltimo()
            else->{
                var p=primero
                // avanzar tantos nodos hasta la posición pedida
                for (i in 0 until posicion -1) {
                    p=p!!.siguiente
                }
                p!!.siguiente=p.siguiente!!.siguiente
                return true
            }
        }
    }

    /**
     * Le suma a los puntos del perro con la placa dada
     * los puntos adicionales que se pasa como parámetro
     *
     * Se retorna true si se hizo el cambio a los puntos
     * (existe el perro con la placa dada) y false si el
     * perro con la placa dada no existe.
     */
    fun aumentarPuntosPerro(placa: String, puntosAdicionales: Int): Boolean {
        require(puntosAdicionales > 0)
        if (existePerro(placa)==false) {
            return false
        }

        var p=primero
        //el while también puede buscar en los nodos de esta forma.
        while (p!!.info.placa!=placa) {
            p=p!!.siguiente
        }
        p.info.puntos+=puntosAdicionales
        return true
    }

    /**
     * Obtiene y retorna cuántos perros tienen una
     * edad entre los parámetros minimo y maximo
     * inclusives.
     */
    fun contarPerrosRangoEdad(minimo: Int, maximo: Int): Int {
        var p=primero
        var c=0
        //se toman los elementos no las fechas por eso p sola
        while (p != null) {
            if (p.info.edad>=minimo && p.info.edad<=maximo) {
                c++
            }
            p=p!!.siguiente
        }
        return c
    }

    /**
     * Obtiene y retorna la suma de los puntos de los
     * perros cuyo nombre comienza por la letra que se
     * recibe como parámetro y cuya edad es par.
     */
    fun sumarPuntosPerros(letra: Char): Int {
        var p=primero
        var sp=0
        while (p != null) {
            //Para tomar la primera letra del String p!!.info.nombre[0]
            if (p!!.info.nombre[0] == letra && p.info.edad%2==0) {
                sp+=p.info.puntos
            }
            p=p!!.siguiente
        }
        return sp
    }

    /**
     * Obtiene y retorna el promedio de la edad
     * de todos los perros de la lista de nodos
     */
    fun promedioEdadPerros(): Double {
        var p=primero
        var promedio=0
        var c=0
        while (p!=null) {
            c++
            promedio+=p.info.edad
            p=p!!.siguiente
        }
        return promedio/c.toDouble()
    }

    /**
     * Obtiene y retorna el PERRO ganador de la
     * exposición, es decir, aquel perro que
     * posee el puntaje más alto. Si la lista
     * está vacía deberá retornarse null
     */
    fun ganador(): Perro? {
        var p=primero
        var puntajeMasAlto=0
        if (primero==null) {
            return null
        }else {
            var dog=primero!!.info
            while (p != null) {
                if (p.info.puntos > puntajeMasAlto) {
                    puntajeMasAlto = p!!.info.puntos
                    dog=p.info
                }
                p = p!!.siguiente
            }
            return dog
        }
    }

    /**
     * Obtiene y retorna la placa del perro
     * más joven de la lista que tienen una
     * cantidad de puntos inferior o igual
     * al puntaje que se pasa como parámetro.
     *
     * Si la lista está vacía, deberá retornarse
     * null.
     */
    fun masJoven(puntaje: Int): String? {
        var p=primero
        var MasJoven=Int.MAX_VALUE

        if (primero==null) {
            return null
        }else {
            //puede retornar un null o un string
            var dog:String?=null
            while (p != null) {
                if (p.info.puntos <= puntaje) {
                    if (p.info.edad < MasJoven) {
                        MasJoven = p!!.info.edad
                        dog = p.info.placa
                    }
                }
                p = p!!.siguiente
            }
            return dog
        }
    }

    /**
     * Obtiene y retorna el porcentaje de perros
     * que tienen un nombre que finaliza en la
     * letra que se pasa como parámetro.
     *
     * El porcentaje debe estar entre 0.0 y 100.0
     * OJO: Si la lista está vacía, debe retornar 0.0
     */
    fun porcentajePerrosFinalizanLetra(letra: Char): Double {
        var p=primero
        var cantidadPerros=0
        if (primero==null) {
            return 0.0
        }else {
            while (p != null) {
                if (p.info.nombre.last()==letra) {
                    cantidadPerros++
                }
                p = p!!.siguiente
            }
            return cantidadPerros*100/numPerros().toDouble()
            //porcentaje=perros finalizan letra*100.0/total perros


        }
    }
}