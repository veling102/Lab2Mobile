package com.example.lab2mobile.data

import com.example.lab2mobile.R

class ArtworkRepository {
    fun getArtworks(): List<Artwork> {
        return listOf(
            Artwork(
                imageResId = R.drawable.artwork_1,
                titleResId = R.string.artwork1_title,
                artistResId = R.string.artwork1_artist,
                yearResId = R.string.artwork1_year,
                contentDescriptionResId = R.string.artwork1_desc
            ),
            Artwork(
                imageResId = R.drawable.artwork_2,
                titleResId = R.string.artwork2_title,
                artistResId = R.string.artwork2_artist,
                yearResId = R.string.artwork2_year,
                contentDescriptionResId = R.string.artwork2_desc
            ),
            Artwork(
                imageResId = R.drawable.artwork_3,
                titleResId = R.string.artwork3_title,
                artistResId = R.string.artwork3_artist,
                yearResId = R.string.artwork3_year,
                contentDescriptionResId = R.string.artwork3_desc
            )
        )
    }
}