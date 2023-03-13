/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralpacientes.mundo

import ean.collections.TArray
import kotlin.jvm.Throws
                                           //ARRAYS O ARREGLOS
// -----------------------------------------------------------------
// Constantes
// -----------------------------------------------------------------

/**
 * Constante para representar el número máximo de paciente en la lista
 */
const val MAX_PACIENTES = 20

// -----------------------------------------------------------------
// Excepciones
// -----------------------------------------------------------------

/**
 * Excepción que informa que el paciente que se va a agregar
 * ya está registrado en la central de pacientes
 */
class YaExisteException(codigo: Int) :
    Exception("El paciente con código $codigo ya está registrado")

/**
 * Excepción generada cuando un paciente con un código dado no existe
 */
class NoExisteException(codigo: Int) :
    Exception("El paciente con código $codigo no está registrado")

// -----------------------------------------------------------------
// Clases
// -----------------------------------------------------------------

/**
 * Esta clase representa una lista con todos los pacientes que se maneja en una
 * central de la ciudad.
 */
class ListaPacientes() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Arreglo con la información de los pacientes
     */
    private val pacientes: TArray<Paciente> = TArray(MAX_PACIENTES)

    /**
     * Número actual de pacientes en el arreglos
     */
    private var numPacientes: Int = 0

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     */
    fun darNumeroPacientes(): Int = numPacientes

    /**
     * Busca el paciente con el código dado en el arreglo de pacientes.
     *
     * Retorna la posición del paciente en el arreglo o -1 si no hay
     * paciente con ese código.
     */
    fun obtenerPosicionPaciente(codigo: Int): Int {
        for (i in 0 until  numPacientes ) {
            if (pacientes[i].codigo==codigo) {
                return i
            }
        }
        return -1
    }

    /**
     * Retorna el paciente que se encuentra en la posición
     * especificada del arreglo.
     */
    fun obtenerPaciente(posicion: Int): Paciente {
        require(posicion in 0 until numPacientes)
        return pacientes[posicion]
    }

    /**
     * Permite obtener el paciente con el código dado
     *
     * Si no existe el paciente con ese código, deberá
     * retornarse un null
     */
    fun localizar(cod: Int): Paciente? {
        for (i in 0 until numPacientes) {
            if (pacientes[i].codigo==cod) {
                return pacientes[i]
            }
        }
        return null
    }

    /**
     * Adiciona un paciente al principio del arreglo de pacientes
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe generar una excepción YaExistePaciente
     */
    fun agregarPacienteAlComienzo(pac: Paciente) {
        require(numPacientes < MAX_PACIENTES)

        //Vemos si el paciente está repetido
        if (obtenerPosicionPaciente(pac.codigo)!=-1) {
            throw YaExisteException(pac.codigo)
        }
        //Correr todos los pacientes a la derecha para
        //abrirle un espacio al nuevo paciente
        for (i in numPacientes downTo 1) {
            pacientes[i]=pacientes[i-1]
        }
        //agregar el dato al principio
        pacientes[0]=pac
        //incremento de numero de pacientes
        numPacientes++
    }

    /**
     * Adiciona un paciente al final del arreglo de pacientes
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteAlFinal(pac: Paciente) {
        //Vemos si el paciente está repetido
        if (obtenerPosicionPaciente(pac.codigo)!=-1) {
            throw YaExisteException(pac.codigo)
        }
        pacientes[numPacientes]=pac
        numPacientes++
    }

    /**
     * Adiciona un paciente al arreglo de pacientes antes
     * del paciente con el código especificado.
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteAntesDe(cod: Int, pac: Paciente) {
        require(numPacientes < MAX_PACIENTES)

        if (obtenerPosicionPaciente(pac.codigo)!=-1) {
            throw YaExisteException(pac.codigo)
        }

        val pos = obtenerPosicionPaciente(cod)
        for (i in numPacientes downTo pos ) {
            pacientes[i]=pacientes[i-1]
        }
        //agregar el dato en la posición que se quiere
        pacientes[pos]=pac

        //incremento de numero de pacientes
        numPacientes++
    }

    /**
     * Adiciona un paciente al arreglo de pacientes después
     * del paciente con el código especificado.
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteDespuesDe(cod: Int, pac: Paciente) {
        require(numPacientes < MAX_PACIENTES)
        //Revisar
        if (obtenerPosicionPaciente(pac.codigo)!=-1) {
            throw YaExisteException(pac.codigo)
        }

        val pos = obtenerPosicionPaciente(cod)
        for (i in numPacientes downTo pos+1) {
            pacientes[i]=pacientes[i-1]
        }
        //agregar el dato en la posición que se quiere
        pacientes[pos+1]=pac

        //incremento de numero de pacientes
        numPacientes++
    }

    /**
     * Elimina el paciente que se encuentra en la posición cero
     * del arreglo.
     */
    private fun eliminarPrimerPaciente() {
        //Debe haber al menos 1 paciente
        require(numPacientes > 0)
        for (i in 0 until numPacientes - 1) {
            pacientes[i] = pacientes[i+1]
        }
        //Disminuimos el número de pacientes
        numPacientes--
    }

    /**
     * Elimina el paciente que se encuentra en última posición
     * del arreglo.
     */
    private fun eliminarUltimoPaciente() {
        require(numPacientes > 0)
        numPacientes--
    }


    /**
     * Elimina el paciente con el código especificado.
     *
     * Si no existe el paciente con el código dado, genera la excepción
     * NoExisteException con el código del paciente
     *
     * @throws NoExisteException
     */
    @Throws(NoExisteException::class)
    fun eliminarPaciente(cod: Int) {

        val pos = obtenerPosicionPaciente(cod)
        //No deja borrar la posición 1
        if (pos == -1) { //No existe Paciente
            throw NoExisteException(cod)
        }
        when (pos) {
            0 -> eliminarPrimerPaciente()
            numPacientes-1 -> eliminarUltimoPaciente()
            else ->{
                for (i in pos until numPacientes - 1) {
                    pacientes[i] = pacientes[i+1]
                }
                numPacientes--
            }

        }
    }

    /**
     * Retorna la cantidad de hombres que hay en el arreglo
     */
    fun cantHombres(): Int {
        var cont=0
        for (i in 0 until  numPacientes) {
            if (pacientes[i].sexo==1) {
                cont++
            }
        }
        return cont
    }

    /**
     * Retorna la cantidad de mujeres que hay en el arreglo
     */
    fun cantMujeres(): Int {
        var cont=0
        for (i in 0 until  numPacientes) {
            if (pacientes[i].sexo==2) {
                cont++
            }
        }
        return cont
    }

    /**
     * Función que encuentra el paciente que tienen el nombre
     * más largo. Use el método length de los nombre para saber
     * el tamaño del nombre
     */
    //Corregir
    fun nombreMasLargo(): Paciente {
        var masLargo=0
        var paciente=pacientes[0]
        for (i in 0 until  numPacientes) {
            if (pacientes[i].nombre.length>masLargo) {
                masLargo=pacientes[i].nombre.length
                paciente=pacientes[i]
            }
        }
        return paciente


    }

    /**
     * Permite obtener y retornar el porcentaje de pacientes
     * en el arreglo que se encuentran hospitalizados en la
     * clínica con el nombre dado. El valor del porcentaje debe
     * estar entre 0.0 y 100.0
     */
    fun porcentajeClinica(clinica: String): Double {
        var contador=0
        var porcentaje=0.0
        for (i in 0 until  numPacientes){
            if (pacientes[i].clinica==clinica) {
                contador++
                porcentaje=contador*100.0/numPacientes
            }

        }
        return porcentaje
    }
}