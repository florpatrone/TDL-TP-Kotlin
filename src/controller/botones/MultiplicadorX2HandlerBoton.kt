package controller.botones

class MultiplicadorX2HandlerBoton(juego: Juego) : EventHandler<ActionEvent?> {
    var juego: Juego
    fun handle(event: ActionEvent?) {
        juego.activarMultiplicadorX2()
    }

    init {
        this.juego = juego
    }
}