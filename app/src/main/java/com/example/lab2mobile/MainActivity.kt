package com.example.lab2mobile


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab2mobile.data.ArtworkRepository
import com.example.lab2mobile.ui.theme.ArtSpaceApp
import com.example.lab2mobile.ui.theme.Lab2MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val repository = ArtworkRepository()
        val artworks = repository.getArtworks()

        setContent {
            Lab2MobileTheme {
                ArtSpaceApp(artworks = artworks)
            }
        }
    }
}