package com.Hoot.hoot.model

interface Observable {
    fun addObserver(observer: Observer?)
    fun notifyObservers()
}
