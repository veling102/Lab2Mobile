package com.example.lab2mobile.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @DrawableRes val imageResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val artistResId: Int,
    @StringRes val yearResId: Int,
    @StringRes val contentDescriptionResId: Int
)