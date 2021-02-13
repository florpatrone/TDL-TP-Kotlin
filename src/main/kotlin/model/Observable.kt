package model

interface Observable {
    fun addObserver(observer: Observer?)
    fun notifyObservers()
}
