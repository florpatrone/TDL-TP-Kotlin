package builders

class DirectorPregunta(var tipoPuntaje: String, var enunciado: String, opciones: List<OpcionSerializada?>) {
    var opciones: List<OpcionSerializada?>

    constructor(preguntaSerializada: PreguntaSerializada) : this(
        preguntaSerializada.getPuntajeType(),
        preguntaSerializada.getEnunciado(),
        preguntaSerializada.getOptions()
    ) {
    }

    fun asignar(builder: Builder) {
        builder.setOpciones(opciones)
        builder.asignarComportamiento(tipoPuntaje)
        builder.setEnunciado(enunciado)
    }

    init {
        this.opciones = opciones
    }
}