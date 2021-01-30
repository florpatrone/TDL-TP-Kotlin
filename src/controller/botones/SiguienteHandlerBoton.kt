package controller.botones

class SiguienteHandlerBoton(juego: Juego, juegoVista: JuegoVista) : EventHandler<ActionEvent?> {
    var juego: Juego
    var juegoVista: JuegoVista
    fun handle(event: ActionEvent?) {
        juego.siguienteTurno(juegoVista.obtenerRespuestaJugador())
    }

    init {
        this.juego = juego
        this.juegoVista = juegoVista
    }
}