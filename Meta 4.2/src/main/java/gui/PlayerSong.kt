package gui

import data.Song
import utils.Vector
import gui.assets.Button
import gui.assets.ColorFlat
import java.awt.Component
import java.awt.Insets
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.util.*
import javax.swing.JPanel
import javax.swing.JSlider

/**
 * MiniReproductor de musica
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 * @see Song
 */

class PlayerSong(position: Vector, size: Vector): JPanel() {
    private var playSong: Button
    private var slider: JSlider
    private var song: Song
    init {
        setSize(size.getX() as Int, size.getY() as Int)
        setLocation(position.getX() as Int, position.getY() as Int)
        layout = null
        background = ColorFlat.ImperialPrime

        song = Song("RaymanLegendsSoundtrack-MainMenuTheTowerofBabel.wav")
        slider = JSlider()
        slider.setSize(width, 12)
        slider.setLocation(0, height - slider.height)
        slider.maximum = song.duration
        slider.value = 0
        slider.background = ColorFlat.ImperialPrime
        add(slider, Component.BOTTOM_ALIGNMENT)

        playSong = Button("PLAY")
        playSong.setSize(height - slider.height * 2, height - slider.height * 2)
        playSong.setLocation(width / 2 - playSong.width / 2, playSong.y)
        playSong.margin = Insets(4, 4, 4, 4)
        playSong.background = ColorFlat.PastelRed
        playSong.setColorOver(playSong.background)
        playSong.setColorEntered(ColorFlat.ImperialPrime)
        playSongEvent()

        add(playSong, Component.LEFT_ALIGNMENT)
        usoThread()
    }

    /**
     * Actualiza la posicion del slider respecto al valor del frame de la cancion
     */
    private fun usoThread() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                if(playSong.text.toLowerCase().equals("pause")) slider.value = song.value
            }
        }, 0, 10L)
    }

    /**
     * Evento del boton, control de la musica
     */
    private fun playSongEvent() {
        playSong.addMouseListener(object : MouseListener {
            override fun mouseReleased(e: MouseEvent?) {}
            override fun mouseEntered(e: MouseEvent?) {}
            override fun mousePressed(e: MouseEvent?) {}
            override fun mouseExited(e: MouseEvent?) {}
            override fun mouseClicked(e: MouseEvent?) {
                if(playSong.text.toLowerCase().equals("play")) playSong.text = "PAUSE"
                else playSong.text = "PLAY"

                song.playing()
            }
        })
    }
}