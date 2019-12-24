import utils.Vector
import gui.Container
import javax.swing.JFrame

/**
 * Clase principal, tiene las propiedades del JFrame (hereda de el)
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */
class Application: JFrame() {
    private var container: Container

    init {
        layout = null
        setSize(800, 500)
        isResizable = false
        setLocationRelativeTo(null)
        title = "Uso de concurrencia"
        defaultCloseOperation = EXIT_ON_CLOSE

        container = Container(Vector(0, 0), Vector(width, height))
        add(container)
        getRootPane().contentPane = container
    }
}

/**
 * Funcion principal de ejecucion de la Aplicacion
 */
fun main() {
    Application().isVisible = true
}