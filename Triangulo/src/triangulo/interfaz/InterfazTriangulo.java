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

import triangulo.mundo.Punto;
import triangulo.mundo.Triangulo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import static triangulo.mundo.TrianguloKt.incentro;

/**
 * Ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazTriangulo extends JFrame {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Triangulo triangulo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de los botones.
     */
    private PanelBotones panelBotones;

    /**
     * Panel para la visualización del triángulo.
     */
    private PanelTriangulo panelTriangulo;

    /**
     * Panel con la opciones de la aplicación.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con el encabezado.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal de la aplicación. <br>
     * <b>post: </b> Se inicializó la interfaz principal y sus paneles.
     */
    public InterfazTriangulo() {
        setTitle("Triángulo");
        setSize(600, 490);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        triangulo = new Triangulo();

        getContentPane().setLayout(new BorderLayout());

        panelImagen = new PanelImagen();
        getContentPane().add(panelImagen, BorderLayout.NORTH);

        panelBotones = new PanelBotones(this);
        getContentPane().add(panelBotones, BorderLayout.WEST);

        panelTriangulo = new PanelTriangulo(this);
        getContentPane().add(panelTriangulo, BorderLayout.CENTER);

        panelOpciones = new PanelOpciones(this);
        getContentPane().add(panelOpciones, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);

        actualizar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve el triángulo del mundo.
     *
     * @return Triángulo.
     */
    public Triangulo darTriangulo() {
        return triangulo;
    }

    /**
     * Cambia el valor de un punto del triángulo.
     *
     * @param pPunto Punto del que se quiere cambiar el valor. pPunto > 0 && pPunto < 4.
     * @param pX     Coordenada X del nuevo punto. pX > 0.
     * @param pY     Coordenada Y del nuevo punto. pY > 0.
     */
    public void cambiarPunto(int pPunto, double pX, double pY) {
        if (pPunto == 1) {
            triangulo.cambiarPunto1(pX, pY);
        }
        else if (pPunto == 2) {
            triangulo.cambiarPunto2(pX, pY);
        }
        else if (pPunto == 3) {
            triangulo.cambiarPunto3(pX, pY);
        }
    }

    /**
     * Cambia el color del fondo del triángulo. <br>
     * <b>post: </b> Se cambió el color del fondo del triángulo y se actualizó la interfaz.
     */
    public void cambiarColorFondo() {
        Color colorActual = new Color(triangulo.darColorRelleno().darRojo(), triangulo.darColorRelleno().darVerde(), triangulo.darColorRelleno().darAzul());
        Color nuevoColor = JColorChooser.showDialog(this, "Color fondo", colorActual);
        if (nuevoColor != null) {
            // Cambia los valores
            triangulo.cambiarColorRelleno(nuevoColor.getRed(), nuevoColor.getGreen(), nuevoColor.getBlue());
        }
        actualizar();
    }

    /**
     * Cambia el color de las líneas del triángulo. <br>
     * <b>post: </b> Se cambió el color de las líneas del triángulo y se actualizó la interfaz.
     */
    public void cambiarColorLineas() {
        Color colorActual = new Color(triangulo.darColorLineas().darRojo(), triangulo.darColorLineas().darVerde(), triangulo.darColorLineas().darAzul());
        Color nuevoColor = JColorChooser.showDialog(this, "Color líneas", colorActual);
        if (nuevoColor != null) {
            // Cambia los valores
            triangulo.cambiarColorLineas(nuevoColor.getRed(), nuevoColor.getGreen(), nuevoColor.getBlue());
        }
        actualizar();
    }

    /**
     * Verifica si 3 puntos son colineales.
     *
     * @param p1x Valor X punto 1. p1x >= 0.
     * @param p1y Valor Y punto 1. p1y >= 0.
     * @param p2x Valor X punto 2. p2x >= 0.
     * @param p2y Valor Y punto 2. p2y >= 0.
     * @param p3x Valor X punto 3. p3x >= 0.
     * @param p3y Valor Y punto 3. p3y >= 0.
     * @return True si los tres puntos dados son colineales. False en caso contrario.
     */
    public boolean colineales(double p1x, double p1y, double p2x, double p2y, double p3x, double p3y) {
        // Verifica usando un Line2D
        Line2D linea = new Line2D.Double(p1x, p1y, p2x, p2y);
        return (linea.ptLineDist(p3x, p3y) == 0);

    }

    /**
     * Muestra el diálogo para cambiar los puntos del triángulo.
     */
    public void mostrarDialogoCambiarPuntos() {
        DialogoPuntos dialogoPuntos = new DialogoPuntos(this);
        dialogoPuntos.setVisible(true);
    }

    /**
     * Repinta el triángulo y los valores. <br>
     * <b>post: </b> Se actualizó el triángulo y sus valores en la interfaz.
     */
    public void actualizar() {
        panelTriangulo.repaint();
        panelBotones.cambiarInformacion(triangulo.darPerimetro(), triangulo.darArea(), triangulo.darAltura());
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1.
     */
    public void reqFuncOpcion1() {
        String resultado = triangulo.tipo();
        actualizar();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Ejecuta el punto de extensión 2.
     */
    public void reqFuncOpcion2() {
        Punto resultado = triangulo.centroide();
        actualizar();
        String respuesta = String.format("El centroide es (%.2f, %.2f)", resultado.darX(), resultado.darY());
        JOptionPane.showMessageDialog(this, respuesta, "Centroide", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Ejecuta el punto de extensión 2.
     */
    public void reqFuncOpcion3() {
        Punto incentro = incentro(triangulo);
        actualizar();
        String respuesta = String.format("El incentro es (%.2f, %.2f)", incentro.darX(), incentro.darY());
        JOptionPane.showMessageDialog(this, respuesta, "Incentro", JOptionPane.INFORMATION_MESSAGE);

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

            InterfazTriangulo interfaz = new InterfazTriangulo();
            interfaz.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

