package com.hooting.hooting.business

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import com.hooting.hooting.data.Pregunta
import org.springframework.stereotype.Service
import java.util.concurrent.ExecutionException


@Service
class PreguntaService {

    @Throws(InterruptedException::class, ExecutionException::class)
    fun listPreguntas(): ArrayList<Pregunta> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val preguntas: ArrayList<Pregunta> = dbFirestore.collection(COL_NAME).get().get().toObjects(Pregunta::class.java) as ArrayList<Pregunta>
        return preguntas
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun savePreguntaDetails(pregunta: Pregunta): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val collectionsApiFuture: ApiFuture<WriteResult> = dbFirestore.collection(COL_NAME).document(pregunta.id.toString()).set(pregunta)
        return collectionsApiFuture.get().getUpdateTime().toString()
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun getPreguntaDetails(id: Long): Pregunta? {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val documentReference = dbFirestore.collection(COL_NAME).document(id.toString())
        val future = documentReference.get()
        val document = future.get()
        var pregunta: Pregunta? = null
        return if (document.exists()) {
            pregunta = document.toObject(Pregunta::class.java)
            pregunta
        } else {
            null
        }
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun updatePreguntaDetails(pregunta: Pregunta): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val collectionsApiFuture: ApiFuture<WriteResult> = dbFirestore.collection(COL_NAME).document(pregunta.id.toString()).set(pregunta)
        return collectionsApiFuture.get().getUpdateTime().toString()
    }

    fun deletePregunta(id: Long): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val writeResult: ApiFuture<WriteResult> = dbFirestore.collection(COL_NAME).document(id.toString()).delete()
        return "Document with Pregunta ID $id has been deleted"
    }

    companion object {
        const val COL_NAME = "preguntas"
    }
}  