package com.hooting.hooting

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.FileInputStream
import javax.annotation.PostConstruct

@Service
internal class FBInitialize {
    @PostConstruct
    fun initialize() {
        try {
            val serviceAccount = FileInputStream("src/main/kotlin/com/hooting/hooting/serviceaccount.json")
            val options = FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://chatapp-e6e15.firebaseio.com")
                    .build()
            FirebaseApp.initializeApp(options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}