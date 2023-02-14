/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Empleados
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package empleado.mundo

import java.util.*

class Empleado {

    // -----------------------------------------------------------------
    // Atributos
    //Realizado por: GUSTAVO SANDOVAL Y DINA TUESTA
    // -----------------------------------------------------------------
    /**
     * Nombre del empleado.
     */
    private var nombre: String = ""

    /**
     * Apellido del empleado.
     */
    private var apellido: String = ""

    /**
     * Genero del empleado. <br></br>
     * 1 indica género masculino. <br></br>
     * 2 indica género femenino. <br></br>
     */
    private var genero = 0

    /**
     * Fecha de nacimiento del empleado.
     */
    private var fechaNacimiento: Fecha = Fecha(1, 1, 1970)

    /**
     * Fecha de ingreso del empleado a la compañía.
     */
    private var fechaIngreso: Fecha = Fecha(1, 1, 1970)

    /**
     * Ruta de la imagen.
     */
    private var imagen: String = ""

    /**
     * Salario del empleado.
     */
    private var salario = 0.0

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Construye el empleado. <br></br>
     * **post: ** Se creó el empleado con los siguientes valores: <br></br>
     * Nombre: Pedro, Apellido: Matallana, Género: masculino (1), Fecha de nacimiento: 16-6-1982, Fecha de ingreso: 5-4-2000, Imagen: empleado1.png, Salario: 1500000.
     */
    constructor() {
        nombre = "Pedro"
        apellido = "Matallana"
        genero = 1
        fechaNacimiento = Fecha(16, 6, 1982)
        fechaIngreso = Fecha(5, 4, 2000)
        imagen = "empleado1.png"
        salario = 1500000.0
    }

    /**
     * Retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    fun darNombre(): String {
        return this.nombre
    }

    /**
     * Retorna el genero del empleado.
     * @return Genero del empleado.
     */
    fun darGenero(): Int {
        return this.genero
    }

    /**
     * Retorna la fecha de nacimiento del empleado en una cadena.
     * @return Fecha de nacimiento del empleado.
     */
    fun darFechaNacimiento(): String {
        return fechaNacimiento.toString()
    }

    /**
     * Retorna la fecha de ingreso del empleado en una cadena.
     * @return Fecha de ingreso del empleado.
     */
    fun darFechaIngreso(): String {
        return fechaNacimiento.toString()
    }

    /**
     * Retorna la ruta de la imagen del empleado.
     * @return Ruta de la imagen.
     */
    fun darImagen(): String {
        return this.imagen
    }

    /**
     * Retorna el salario del empleado.
     * @return Salario del empleado.
     */
    fun darSalario(): Double {
        return this.salario
    }

    /**
     * Retorna el apellido del empleado.
     * @return Apellido del empleado.
     */
    fun darApellido(): String {
        return this.apellido
    }

    /**
     * Retorna la edad del empleado en años.
     * @return Edad del empleado en años.
     */
    fun calcularEdad(): Int {
        val hoy = darFechaActual()
        return hoy.darDiferenciaEnMeses(this.fechaNacimiento)/12
    }

    /**
     * Retorna la antigüedad del empleado en años.
     * @return Antigüedad del empleado en años.
     */
    fun calcularAntiguedad(): Int {
        val hoy = darFechaActual()
        return hoy.darDiferenciaEnMeses(this.fechaIngreso)/12
    }

    /**
     * Retorna las prestaciones del empleado usando la fórmula: p = (a * s)/12 (p: prestaciones, a: antigüedad, s: salario). <br></br>
     * La antigüedad que se utiliza está dada en años, así que si un empleado lleva menos de un año en la empresa, sus prestaciones serán 0.
     * @return Prestaciones del empleado.
     */
    fun calcularPrestaciones(): Double {
        when{
            calcularAntiguedad() <1 -> return 0.0
            else -> return (calcularAntiguedad() * salario)/12
        }
    }

    /**
     * Cambia la información del empleado con los valores dados por parámetro. <br></br>
     * ** post: ** El nombre, apellido, género, fecha de nacimiento, fecha de ingreso, salario e imagen fueron cambiados con los valores dados por parámetro.
     * @param pNombre Nombre del empleado. pNombre != null && pNombre != "".
     * @param pApellido Apellido del empleado. pApellido != null && pApellido != "".
     * @param pGenero Género del empleado. pGenero == 1 || pGenero == 0.
     * @param pFechaNacimiento Fecha de nacimiento del empleado. pFechaNacimiento != null.
     * @param pFechaIngreso Fecha de ingreso del empleado. pFechaIngreso != null.
     * @param pSalario Salario del empleado. pSalario > 0.
     * @param pImagen Imagen del empleado. pImagen != null && pImagen != "".
     */
    fun cambiarEmpleado(
        pNombre: String,
        pApellido: String,
        pGenero: Int,
        pFechaNacimiento: Fecha,
        pFechaIngreso: Fecha,
        pSalario: Double,
        pImagen: String
    ) {
        this.nombre = pNombre
        this.apellido = pApellido
        this.genero = pGenero
        this.fechaNacimiento = pFechaNacimiento
        this.fechaIngreso = pFechaIngreso
        this.salario = pSalario
        this.imagen = pImagen
    }

    /**
     * Cambia el salario del empleado con el valor dado por parámetro. <br></br>
     * **post: ** El salario tiene el valor ingresado por parámetro.
     * @param pSalario Nuevo salario del empleado. pSalario > 0.
     */
    fun cambiarSalario(pSalario: Double) {
        this.salario = pSalario
        pSalario > 0.0
    }

    /**
     * Retorna la fecha actual.
     * @return Fecha actual.
     */
    fun darFechaActual(): Fecha {
        val gc = GregorianCalendar()
        val dia = gc[Calendar.DAY_OF_MONTH]
        val mes = gc[Calendar.MONTH] + 1
        val año = gc[Calendar.YEAR]
        return Fecha(dia, mes, año)
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Obtiene el tipo del empleado. Este tipo depende de la antigüedad del empleado
     * "freshman" si el empleado tiene menos de 1 año de antigüedad
     * "sophomore" si el empleado tiene entre 1 y 3 años de antigüedad
     * "junior" si el empleado tiene más de 3 pero menos de 10 años de antigüedad
     * "senior" si tiene 10 o más años de antigüedad
     */
    fun tipo(): String {
        when {
            calcularAntiguedad() < 1 -> return "freshman"
            calcularAntiguedad() in 1..3 -> return "sophomore"
            calcularAntiguedad() in 4..9 -> return "junior"
            else -> return "senior"
        }
    }

    /**
     * La bonificación es un dinero extra que recibe el empleado por su labor de coordinación.
     * Este valor se calcula a partir del nueve por ciento (9%) del salario dividido por el número de
     * personas a cargo (dato de entrada).
     */
    fun bonificacion(numPersonasACargo: Int): Double {
        return (salario * 0.09) / numPersonasACargo
    }
}