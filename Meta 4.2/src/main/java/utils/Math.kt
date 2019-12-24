package utils

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 * @param x Valor en x
 * @param y Valor en y
 */
class Vector(private var x: Number, private var y: Number) {
    /**
     * Retorna el contenido de X
     */
    fun getX(): Number {
        return x
    }

    /**
     * Retorna el contenido de Y
     */
    fun getY(): Number {
        return y
    }

    /**
     * Modificar un solo valor o ambos
     */
    fun set(x: Number ?, y: Number ?) {
        if (x != null) this.x = x
        if (y != null) this.y = y
    }
}