package controller.botones

class MultiplicadorX3HandlerBoton(juego: Juego) : EventHandler<ActionEvent?> {
    var juego: Juego
    fun handle(event: ActionEvent?) {
        juego.activarMultiplicadorX3()
    }

    init {
        this.juego = juego
    }
}