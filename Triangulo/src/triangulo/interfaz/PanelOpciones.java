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

/**
 * Panel con las opciones de la aplicación.
 */
@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para la extensión 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando para la extensión 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando para la extensión 3.
     */
    private static final String OPCION_3 = "OPCION_3";

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
     * Botón opción 1.
     */
    private JButton btnOpcion1;

    /**
     * Botón opción 2.
     */
    private JButton btnOpcion2;

    /**
     * Botón opción 3.
     */
    private JButton btnOpcion3;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializó el panel.
     *
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones(InterfazTriangulo pPrincipal) {
        principal = pPrincipal;

        setBorder(new TitledBorder("Opciones"));
        setLayout(new GridLayout(1, 2));

        // Botón opción 1
        btnOpcion1 = new JButton("Tipo");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        add(btnOpcion1);

        // Botón opción 2
        btnOpcion2 = new JButton("Centroide");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        add(btnOpcion2);

        // Botón opción 3
        btnOpcion3 = new JButton("Incentro");
        btnOpcion3.setActionCommand(OPCION_3);
        btnOpcion3.addActionListener(this);
        add(btnOpcion3);
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
        if (OPCION_1.equals(pEvento.getActionCommand())) {
            principal.reqFuncOpcion1();
        }
        else if (OPCION_2.equals(pEvento.getActionCommand())) {
            principal.reqFuncOpcion2();
        }
        else if (OPCION_3.equals(pEvento.getActionCommand())) {
            principal.reqFuncOpcion3();
        }
    }

}

