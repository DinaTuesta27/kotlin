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

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Panel con la opciones para modificar el triángulo.
 */
@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para cambiar los punto del triángulo.
     */
    private static final String PUNTOS = "PUNTOS";

    /**
     * Constante para cambiar el color del triángulo.
     */
    private static final String COLOR_TRIANGULO = "COLOR_TRIANGULO";

    /**
     * Constante para cambiar el fondo de color de las líneas del triángulo.
     */
    private static final String COLOR_LINEAS = "COLOR_LINEAS";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazTriangulo principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón cambio de puntos.
     */
    private JButton btnPuntos;

    /**
     * Botón cambio color de la líneas.
     */
    private JButton btnColorLinea;

    /**
     * Botón cambio color del triángulo.
     */
    private JButton btnColorTriangulo;

    /**
     * Etiqueta con el área del triángulo.
     */
    private JLabel etiquetaArea;

    /**
     * Etiqueta con la altura del triángulo.
     */
    private JLabel etiquetaAltura;

    /**
     * Etiqueta con el perímetro.
     */
    private JLabel etiquetaPerimetro;

    /**
     * Campo de texto para el área del triángulo.
     */
    private JTextField txtArea;

    /**
     * Campo de texto para la altura del triángulo.
     */
    private JTextField txtAltura;

    /**
     * Campo de texto para el perímetro del triángulo.
     */
    private JTextField txtPerimetro;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializó el panel.
     *
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelBotones(InterfazTriangulo pPrincipal) {
        principal = pPrincipal;
        setLayout(new GridLayout(2, 1));

        // Panel Modificaciones
        JPanel panelModificaciones = new JPanel(new GridLayout(3, 1));
        panelModificaciones.setBorder(new TitledBorder("Modificaciones"));

        btnPuntos = new JButton("Cambiar puntos");
        btnPuntos.setActionCommand(PUNTOS);
        btnPuntos.addActionListener(this);
        panelModificaciones.add(btnPuntos);

        btnColorLinea = new JButton("Cambiar líneas");
        btnColorLinea.setActionCommand(COLOR_LINEAS);
        btnColorLinea.addActionListener(this);
        panelModificaciones.add(btnColorLinea);

        btnColorTriangulo = new JButton("Cambiar color triángulo");
        btnColorTriangulo.setActionCommand(COLOR_TRIANGULO);
        btnColorTriangulo.addActionListener(this);
        panelModificaciones.add(btnColorTriangulo);

        // Panel Datos
        JPanel panelInformacion = new JPanel(new GridLayout(3, 2));
        panelInformacion.setBorder(new TitledBorder("Medidas en pixeles"));

        etiquetaPerimetro = new JLabel("Perímetro: ");
        etiquetaPerimetro.setFont(etiquetaPerimetro.getFont().deriveFont(Font.PLAIN));
        panelInformacion.add(etiquetaPerimetro);

        txtPerimetro = new JTextField(8);
        txtPerimetro.setEditable(false);
        txtPerimetro.setText(formatearValor(0) + " px");
        panelInformacion.add(txtPerimetro);

        etiquetaArea = new JLabel("Área: ");
        etiquetaArea.setFont(etiquetaArea.getFont().deriveFont(Font.PLAIN));
        panelInformacion.add(etiquetaArea);

        txtArea = new JTextField(8);
        txtArea.setEditable(false);
        txtArea.setText(formatearValor(0) + " px");
        panelInformacion.add(txtArea);

        etiquetaAltura = new JLabel("Altura: ");
        etiquetaAltura.setFont(etiquetaAltura.getFont().deriveFont(Font.PLAIN));
        panelInformacion.add(etiquetaAltura);

        txtAltura = new JTextField(8);
        txtAltura.setEditable(false);
        txtAltura.setText(formatearValor(0) + " px");
        panelInformacion.add(txtAltura);

        add(panelModificaciones);
        add(panelInformacion);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia la información del triángulo.
     *
     * @param pPerimetro Nuevo perímetro del triángulo. pPerimetro > 0.
     * @param pArea      Nueva área del triángulo. pArea > 0.
     * @param pAltura    Nueva altura del triángulo. pAltura > 0.
     */
    public void cambiarInformacion(double pPerimetro, double pArea, double pAltura) {
        txtArea.setText(formatearValor(pArea) + " px");
        txtPerimetro.setText(formatearValor(pPerimetro) + " px");
        txtAltura.setText(formatearValor(pAltura) + " px");
    }

    /**
     * Manejo de los eventos de los botones.
     *
     * @param pEvento Evento de click sobre un botón. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        if (PUNTOS.equals(pEvento.getActionCommand())) {
            principal.mostrarDialogoCambiarPuntos();
        }
        else if (COLOR_TRIANGULO.equals(pEvento.getActionCommand())) {
            principal.cambiarColorFondo();
        }
        else if (COLOR_LINEAS.equals(pEvento.getActionCommand())) {
            principal.cambiarColorLineas();
        }
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz.
     *
     * @param pValor Valor numérico a ser formateado. pValor > 0.
     * @return Retorna un string con el valor formateado con puntos y signos.
     */
    private String formatearValor(double pValor) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(pValor);
    }

}

