package com.example.cuadricula.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes  val stringResourceId: Int,
    val cantidad: Int,
    @DrawableRes val imageResourseId: Int
)
