package gui

import data.Clock
import utils.Vector
import gui.assets.ColorFlat
import utils.ImageTool
import java.awt.Graphics
import javax.swing.*

/**
 * Reloj con uso de un nuevo Thread, para mantener independencia
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 * @param size Dimension de la ventana
 * @param position Posicion de la ventana
 */
class Container(position: Vector, size: Vector): JPanel() {
    private var clock: Clock
    private var clockLabel: JLabel
    private var playerSong: PlayerSong

    private var image: JLabel

    init {
        setSize(size.getX() as Int, size.getY() as Int)
        setLocation(position.getX() as Int, position.getY() as Int)
        layout = null

        clock = Clock()
        clockLabel = JLabel(clock.dateToString)
        clockLabel.setBounds(0, 0, width, 30)
        clockLabel.horizontalAlignment = SwingConstants.CENTER
        clockLabel.foreground = ColorFlat.LightBlueBallerina

        playerSong = PlayerSong(Vector(25, height - 125), Vector(width - 55, 80))
        add(clockLabel)
        add(playerSong)
        background = ColorFlat.ImperialPrime


        image = JLabel()
        image.setSize(500, 300)
        image.setLocation(width / 2 - image.width / 2, clockLabel.height + 10)
        image.icon = ImageTool.resizeImage("rayman.jpg", image.width, image.height)
        add(image)
    }

    /**
     * Se agrega componentes a actualizar y redibujan
     */
    override fun paint(g: Graphics?) {
        clockLabel.text = clock.dateToString
        clockLabel.repaint()

        super.paint(g)
    }
}