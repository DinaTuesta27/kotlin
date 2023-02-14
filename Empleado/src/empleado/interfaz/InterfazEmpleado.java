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
package empleado.interfaz;

import empleado.mundo.Empleado;
import empleado.mundo.Fecha;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazEmpleado extends JFrame {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Empleado empleado;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel para mostrar los datos del empleado.
     */
    private PanelDatos panelDatos;

    /**
     * Panel para realizar consultas sobre el empleado.
     */
    private PanelConsultas panelConsultas;

    /**
     * Panel para ejecutar las extensiones a la aplicación.
     */
    private PanelOpciones panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva interfaz inicializada con los datos de una empleado particular. <br>
     * <b>post: </b> La interfaz principal y sus paneles quedaron inicializados.
     */
    public InterfazEmpleado() {
        setTitle("Sistema de un empleado");
        setSize(600, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Construir el empleado

        empleado = new Empleado();

        // construir los paneles
        JPanel panelCentral = new JPanel();
        panelDatos = new PanelDatos(this);
        panelConsultas = new PanelConsultas(this);
        panelOpciones = new PanelOpciones(this);
        panelImagen = new PanelImagen();

        // organizar el panel principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelImagen, BorderLayout.NORTH);
        getContentPane().add(panelCentral, BorderLayout.CENTER);
        getContentPane().add(panelOpciones, BorderLayout.SOUTH);

        // organizar el panel central
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(panelDatos, BorderLayout.NORTH);
        panelCentral.add(panelConsultas, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);

        actualizar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Calcula la edad del empleado y la muestra.
     */
    public void calcularEdadEmpleado() {
        panelConsultas.actualizarEdad(empleado.calcularEdad());
    }

    /**
     * Calcula la antigüedad del empleado y la muestra.
     */
    public void calcularAntiguedadEmpleado() {
        panelConsultas.actualizarAntiguedad(empleado.calcularAntiguedad());
    }

    /**
     * Calcula las prestaciones del empleado y las muestra.
     */
    public void calcularPrestacionesEmpleado() {
        panelConsultas.actualizarPrestaciones(empleado.calcularPrestaciones());
    }

    /**
     * Modifica y actualiza el salario del empleado. <br>
     * <b>post: </b> Se actualizó el salario del empleado y se presentó la información actualizada.
     */
    public void modificarSalario() {
        String strSalario = JOptionPane.showInputDialog(this, "Introduzca el nuevo salario.", "Modificar salario", JOptionPane.QUESTION_MESSAGE);

        if (strSalario != null) {
            try {
                double nuevoSalario = Double.parseDouble(strSalario);
                if (nuevoSalario <= 0) {
                    JOptionPane.showMessageDialog(this, "El salario debe ser un número positivo.", "Modificar salario", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    empleado.cambiarSalario(nuevoSalario);
                    panelDatos.actualizarSalario(empleado.darSalario());
                }
            }
            catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "El salario debe ser un número.", "Modificar salario", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Actualiza los datos actuales del empleado. <br>
     * <b>post: </b> Se actualizaron los campos de la ventana que contienen la información del empleado.
     */
    public void actualizar() {
        String nombre, apellido, genero, fechaI, fechaN, imagen;
        double salario;

        nombre = empleado.darNombre();
        apellido = empleado.darApellido();

        int iGenero = empleado.darGenero();
        if (iGenero == 1) {
            genero = "masculino";
        }
        else {
            genero = "femenino";
        }

        fechaI = empleado.darFechaIngreso();
        fechaN = empleado.darFechaNacimiento();
        salario = empleado.darSalario();
        imagen = empleado.darImagen();

        panelDatos.actualizarCampos(nombre, apellido, genero, fechaI, fechaN, imagen);
        panelDatos.actualizarSalario(salario);

        panelConsultas.limpiarCampos();

        validate();
    }

    /**
     * Cambia los datos del empleado.
     *
     * @param pNombre          Nuevo nombre del empleado. pNombre != "" && pNombre != null.
     * @param pApellido        Nuevo apellido del empleado. pApellido != "" && pApellido != null.
     * @param pGenero          Nuevo género del empleado. pGenero == 1 && pGenero == 0.
     * @param pFechaNacimiento Nueva fecha de nacimiento del empleado. pFechaNacimiento != null.
     * @param pFechaIngreso    Nueva fecha de ingreso. pFechaIngreso != null.
     * @param pSalario         Nuevo salario del empleado. pSalario > 0.
     * @param pImagen          Nueva imagen del empleado. pImagen != null && pImagen != "".
     */
    public void cambiarEmpleado(String pNombre, String pApellido, int pGenero, Fecha pFechaNacimiento, Fecha pFechaIngreso, int pSalario, String pImagen) {
        empleado = new Empleado();
        empleado.cambiarEmpleado(pNombre, pApellido, pGenero, pFechaNacimiento, pFechaIngreso, pSalario, pImagen);
        actualizar();
    }

    /**
     * Muestra el diálogo para modificar el empleado.
     */
    public void mostrarDialogoCambiarEmpleado() {
        DialogoCambiarEmpleado dialogo = new DialogoCambiarEmpleado(this);
        dialogo.setVisible(true);
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1() {
        String respuesta = "El empleado es de tipo: " + empleado.tipo();
        actualizar();
        JOptionPane.showMessageDialog(this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2() {
        int personas = 0;
        try {
            String entrada = JOptionPane.showInputDialog("¿Cuántas personas a cargo tiene el empleado");
            personas = Integer.parseInt(entrada);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la entrada!");
            return ;
        }

        double bonificacion = empleado.bonificacion(personas);

        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("$###,###.##");

        String respuesta = "La bonificación es de: " + df.format(bonificacion);

        actualizar();
        JOptionPane.showMessageDialog(this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     *
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main(String[] pArgs) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfazEmpleado interfaz = new InterfazEmpleado();
            interfaz.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
