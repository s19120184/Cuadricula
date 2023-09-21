package com.example.cuadricula.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes  val stringResourceId: Int,
    val cantidad : Int =1,
    @DrawableRes val imageResourseId: Int
)
