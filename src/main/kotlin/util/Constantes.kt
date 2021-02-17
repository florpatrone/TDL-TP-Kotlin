package util

class Constantes {

    companion object{
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION
        const val URL_BASE_PREGUNTAS = "$URL_BASE/preguntas"
        const val URL_BASE_RESPUESTAS = "$URL_BASE/respuestas"
    }
}