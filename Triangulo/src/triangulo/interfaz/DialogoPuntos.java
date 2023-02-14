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
package triangulo.interfaz;

import triangulo.mundo.Triangulo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Diálogo para cambiar los puntos del triángulo.
 */
@SuppressWarnings("serial")
public class DialogoPuntos extends JDialog implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar los nuevos puntos del triángulo.
     */
    private static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante para cancelar los cambios al triángulo.
     */
    private static final String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicación.
     */
    private InterfazTriangulo principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Valor X del punto 1.
     */
    private JTextField txtPunto1x;

    /**
     * Valor Y del punto 1.
     */
    private JTextField txtPunto1y;

    /**
     * Valor X del punto 2.
     */
    private JTextField txtPunto2x;

    /**
     * Valor Y del punto 2.
     */
    private JTextField txtPunto2y;

    /**
     * Valor X del punto 3.
     */
    private JTextField txtPunto3x;

    /**
     * Valor Y del punto 3.
     */
    private JTextField txtPunto3y;

    /**
     * Botón aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo. <br>
     * <b>post: </b> Se inicializó el diálogo y se muestra al usuario.
     *
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoPuntos(InterfazTriangulo pPrincipal) {
        principal = pPrincipal;

        setTitle("Modificar puntos");
        setSize(400, 200);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        Triangulo triangulo = pPrincipal.darTriangulo();

        setLayout(new BorderLayout());

        JPanel panelPuntos = new JPanel();
        JPanel panelBotones = new JPanel();

        panelPuntos.setLayout(new GridLayout(4, 3));
        panelBotones.setLayout(new GridLayout(1, 4));

        panelPuntos.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelBotones.setBorder(new EmptyBorder(10, 0, 10, 0));

        add(panelPuntos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        panelPuntos.add(new JLabel("Punto"));
        panelPuntos.add(new JLabel("Valor x"));
        panelPuntos.add(new JLabel("Valor y"));
        // Punto 1
        panelPuntos.add(new JLabel("Punto 1:"));
        txtPunto1x = new JTextField(Double.toString(triangulo.darPunto1().darX()));
        panelPuntos.add(txtPunto1x);
        txtPunto1y = new JTextField(Double.toString(triangulo.darPunto1().darY()));
        panelPuntos.add(txtPunto1y);

        // Punto 2
        panelPuntos.add(new JLabel("Punto 2:"));
        txtPunto2x = new JTextField(Double.toString(triangulo.darPunto2().darX()));
        panelPuntos.add(txtPunto2x);
        txtPunto2y = new JTextField(Double.toString(triangulo.darPunto2().darY()));
        panelPuntos.add(txtPunto2y);

        // Punto 3
        panelPuntos.add(new JLabel("Punto 3:"));
        txtPunto3x = new JTextField(Double.toString(triangulo.darPunto3().darX()));
        panelPuntos.add(txtPunto3x);
        txtPunto3y = new JTextField(Double.toString(triangulo.darPunto3().darY()));
        panelPuntos.add(txtPunto3y);

        // Botones
        panelBotones.add(new JLabel());
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(ACEPTAR);
        btnAceptar.addActionListener(this);
        panelBotones.add(btnAceptar);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
        panelBotones.add(btnCancelar);
        panelBotones.add(new JLabel());

        setModal(true);
        setLocationRelativeTo(pPrincipal);
        setResizable(false);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        try {
            if (ACEPTAR.equals(pEvento.getActionCommand())) {
                // Lee los valores
                double p1x = Double.parseDouble(txtPunto1x.getText());
                double p1y = Double.parseDouble(txtPunto1y.getText());
                double p2x = Double.parseDouble(txtPunto2x.getText());
                double p2y = Double.parseDouble(txtPunto2y.getText());
                double p3x = Double.parseDouble(txtPunto3x.getText());
                double p3y = Double.parseDouble(txtPunto3y.getText());

                // Valida que no sean negativos
                if (p1x < 0 || p1y < 0 || p2x < 0 || p2y < 0 || p3x < 0 || p3y < 0) {
                    JOptionPane.showMessageDialog(this, "No pueden haber coordenadas negativas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                // Valida que no sean colineales
                else if (principal.colineales(p1x, p1y, p2x, p2y, p3x, p3y)) {
                    JOptionPane.showMessageDialog(this, "Los puntos no pueden ser colineales.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // Cambia los puntos
                    principal.cambiarPunto(1, p1x, p1y);
                    principal.cambiarPunto(2, p2x, p2y);
                    principal.cambiarPunto(3, p3x, p3y);
                    principal.setEnabled(true);
                    principal.actualizar();
                    setVisible(false);
                    dispose();
                }
            }
            else {
                principal.setEnabled(true);
                principal.actualizar();
                setVisible(false);
                dispose();
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar sólo números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
