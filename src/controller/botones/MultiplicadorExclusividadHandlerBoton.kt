package controller.botones

class MultiplicadorExclusividadHandlerBoton(juego: Juego, juegoVista: JuegoVista) : EventHandler<ActionEvent?> {
    var juego: Juego
    private val juegoVista: JuegoVista
    fun handle(event: ActionEvent?) {
        juegoVista.bloquearBoton("BOTONEXCLUSIVIDAD")
        juego.activarExclusividad()
    }

    init {
        this.juego = juego
        this.juegoVista = juegoVista
    }
}