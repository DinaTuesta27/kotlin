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

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Panel para las consultas y operaciones de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelConsultas extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para calcular la edad del empleado.
     */
    private final static String CALCULAR_EDAD = "CALCULAR EDAD";

    /**
     * Constante para calcular la antigüedad del empleado.
     */
    private final static String CALCULAR_ANTIGUEDAD = "CALCULAR ANTIGUEDAD";

    /**
     * Constane para calcular las prestaciones del empleado.
     */
    private final static String CALCULAR_PRESTACIONES = "CALCULAR PRESTACIONES";

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
     * Campo donde se muestra la edad del empleado.
     */
    private JTextField txtEdad;

    /**
     * Campo donde se muestra la antigüedad del empleado.
     */
    private JTextField txtAntiguedad;

    /**
     * Campo donde se muestran las prestaciones del empleado.
     */
    private JTextField txtPrestaciones;

    /**
     * Botón para calcular la edad del empleado.
     */
    private JButton btnEdad;

    /**
     * Botón para calcular la antigüedad del empleado.
     */
    private JButton btnAntiguedad;

    /**
     * Botón para calcular las prestaciones del empleado.
     */
    private JButton btnPrestaciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel de datos a consultar. <br>
     * <b>post: </b> Panel quedó inicializado.
     *
     * @param pPrincipal Interfaz principal de la aplicación. pPrincipal != null.
     */
    public PanelConsultas(InterfazEmpleado pPrincipal) {
        principal = pPrincipal;
        setLayout(new BorderLayout());
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder("Cálculos")));

        btnEdad = new JButton();
        btnEdad.setText("Calcular edad");
        btnEdad.setActionCommand(PanelConsultas.CALCULAR_EDAD);
        btnEdad.addActionListener(this);

        btnAntiguedad = new JButton();
        btnAntiguedad.setText("Calcular antigüedad");
        btnAntiguedad.setActionCommand(PanelConsultas.CALCULAR_ANTIGUEDAD);
        btnAntiguedad.addActionListener(this);

        btnPrestaciones = new JButton();
        btnPrestaciones.setText("Calcular prestaciones");
        btnPrestaciones.setActionCommand(PanelConsultas.CALCULAR_PRESTACIONES);
        btnPrestaciones.addActionListener(this);

        txtEdad = new JTextField(10);
        txtEdad.setEditable(false);

        txtAntiguedad = new JTextField(10);
        txtAntiguedad.setEditable(false);

        txtPrestaciones = new JTextField(10);
        txtPrestaciones.setEditable(false);

        JPanel panelCalculos = new JPanel(new GridLayout(3, 2));
        JLabel espacioVacio1 = new JLabel("");
        JLabel espacioVacio2 = new JLabel("");
        espacioVacio1.setPreferredSize(new Dimension(120, 0));
        espacioVacio2.setPreferredSize(new Dimension(120, 0));

        add(espacioVacio1, BorderLayout.EAST);
        add(panelCalculos, BorderLayout.CENTER);
        add(espacioVacio2, BorderLayout.WEST);
        panelCalculos.add(btnEdad);
        panelCalculos.add(txtEdad);
        panelCalculos.add(btnAntiguedad);
        panelCalculos.add(txtAntiguedad);
        panelCalculos.add(btnPrestaciones);
        panelCalculos.add(txtPrestaciones);

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Limpia los campos. <br>
     * <b>post: </b> Todos los campos del panel están limpios.
     */
    public void limpiarCampos() {
        txtEdad.setText("");
        txtAntiguedad.setText("");
        txtPrestaciones.setText("");
    }

    /**
     * Actualiza el campo de texto de la edad con el valor dado por parámetro.
     *
     * @param pEdad Edad del empleado. pEdad > 0.
     */
    public void actualizarEdad(int pEdad) {
        txtEdad.setText("" + pEdad + " años");
    }

    /**
     * Actualiza el campo de texto de la antigüedad con el valor dado por parámetro.
     *
     * @param pAntiguedad Antigüedad del empleado. pAntiguedad > 0.
     */
    public void actualizarAntiguedad(int pAntiguedad) {
        txtAntiguedad.setText("" + pAntiguedad);
    }

    /**
     * Actualiza el campo de texto de las prestaciones con el valor dado por parámetro.
     *
     * @param pPrestaciones Prestaciones del empleado. pPrestaciones > 0.
     */
    public void actualizarPrestaciones(double pPrestaciones) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("$###,###.##");
        txtPrestaciones.setText(df.format(pPrestaciones));
    }

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String command = pEvento.getActionCommand();

        if (command.equals(CALCULAR_EDAD)) {
            principal.calcularEdadEmpleado();
        }
        else if (command.equals(CALCULAR_ANTIGUEDAD)) {
            principal.calcularAntiguedadEmpleado();
        }
        else if (command.equals(CALCULAR_PRESTACIONES)) {
            principal.calcularPrestacionesEmpleado();
        }
    }

}

