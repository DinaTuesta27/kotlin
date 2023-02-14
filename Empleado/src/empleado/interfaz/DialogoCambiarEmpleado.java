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

import com.toedter.calendar.JDateChooser;
import empleado.mundo.Fecha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

/**
 * Diálogo para cambiar el empleado.
 */
@SuppressWarnings("serial")
public class DialogoCambiarEmpleado extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar los cambios.
     */
    private final static String SELECCIONAR_IMAGEN = "SELECCIONAR_IMAGEN";

    /**
     * Constante para aceptar los cambios.
     */
    private final static String ACEPTAR = "ACEPTAR";

    /**
     * Constante para cancelar los cambios.
     */
    private final static String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Venta principal de la aplicación.
     */
    private InterfazEmpleado principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para el apellido.
     */
    private JTextField txtApellido;

    /**
     * Combo para el género.
     */
    private JComboBox cbGenero;

    /**
     * Campo de texto para el fecha de nacimiento.
     */
    private JDateChooser dcFechaNacimiento;

    /**
     * Campo de texto para el fecha de ingreso.
     */
    private JDateChooser dcFechaIngreso;

    /**
     * Campo de texto para el salario.
     */
    private JTextField txtSalario;

    /**
     * Campo de texto para la imagen.
     */
    private JTextField txtImagen;

    /**
     * Botón para seleccionar la imagen.
     */
    private JButton btnSelecImagen;

    /**
     * Botón para aceptar cambios.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar cambios.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo para modificar los datos del empleado.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoCambiarEmpleado(InterfazEmpleado pPrincipal) {
        principal = pPrincipal;

        setTitle("Cambiar empleado");
        setSize(450, 250);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Genero:"));
        cbGenero = new JComboBox();
        cbGenero.addItem("femenino");
        cbGenero.addItem("masculino");
        add(cbGenero);

        add(new JLabel("Fecha de nacimiento:"));
        dcFechaNacimiento = new JDateChooser();
        add(dcFechaNacimiento);

        add(new JLabel("Fecha de ingreso:"));
        dcFechaIngreso = new JDateChooser();
        add(dcFechaIngreso);

        add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        add(txtSalario);

        add(new JLabel("Imagen:"));
        JPanel panelAux = new JPanel();
        panelAux.setLayout(new BorderLayout());
        txtImagen = new JTextField();
        txtImagen.setEditable(false);
        panelAux.add(txtImagen, BorderLayout.CENTER);
        btnSelecImagen = new JButton("Seleccionar");
        btnSelecImagen.setActionCommand(SELECCIONAR_IMAGEN);
        btnSelecImagen.addActionListener(this);
        panelAux.add(btnSelecImagen, BorderLayout.EAST);
        add(panelAux);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(ACEPTAR);
        btnAceptar.addActionListener(this);
        add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
        add(btnCancelar);

        setModal(true);
        setLocationRelativeTo(principal);
        setResizable(false);
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();
        if (comando.equals(ACEPTAR)) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            int genero = cbGenero.getSelectedIndex();
            Date fechaIngreso = dcFechaIngreso.getDate();
            Fecha fechaIngreso2 = new Fecha(fechaIngreso.getDate(), fechaIngreso.getMonth() + 1, fechaIngreso.getYear() + 1900);
            Date fechaNacimiento = dcFechaNacimiento.getDate();
            Fecha fechaNacimiento2 = new Fecha(fechaNacimiento.getDate(), fechaNacimiento.getMonth() + 1, fechaNacimiento.getYear() + 1900);
            String salarioStr = txtSalario.getText();
            String imagen = txtImagen.getText();
            if (nombre.equals("") || apellido.equals("") || fechaIngreso == null || fechaNacimiento == null || salarioStr.equals("") || imagen.equals("")) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los datos.", "Cambiar empleado", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    int salario = Integer.parseInt(salarioStr);
                    if (salario <= 0) {
                        JOptionPane.showMessageDialog(this, "El salario debe ser mayor a cero.", "Cambiar empleado", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (fechaIngreso2.darDiferenciaEnMeses(fechaNacimiento2) < 0) {
                        JOptionPane.showMessageDialog(this, "La fecha de ingreso no puede ser anterior a la fecha de nacimiento.", "Cambiar empleado", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        principal.cambiarEmpleado(nombre, apellido, genero, fechaNacimiento2, fechaIngreso2, salario, imagen);
                        dispose();
                    }

                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El salario debe ser un número.", "Cambiar empleado", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if (comando.equals(SELECCIONAR_IMAGEN)) {
            JFileChooser jfc = new JFileChooser("./data/imagenes");
            int resultado = jfc.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File elegida = jfc.getSelectedFile();
                if (elegida != null) {
                    txtImagen.setText(elegida.getName());
                }
            }
        }
        else if (comando.equals(CANCELAR)) {
            dispose();
        }

    }

}

