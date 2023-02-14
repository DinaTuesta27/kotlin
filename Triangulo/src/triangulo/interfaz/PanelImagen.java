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

/**
 * Panel de la imagen del título.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel {

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se inicializó el panel.
     */
    public PanelImagen() {
        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("data/titulo.png");
        imagen = new JLabel("");
        imagen.setIcon(icono);
        add(imagen);
    }

}
