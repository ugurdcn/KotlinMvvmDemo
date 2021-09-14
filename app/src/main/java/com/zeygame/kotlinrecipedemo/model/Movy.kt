package com.zeygame.kotlinrecipedemo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movy(
    val actors: String,
    val director: String,
    val genres: List<String>,
    val id: Int,
    val plot: String,
    val posterUrl: String,
    val runtime: String,
    val title: String,
    val year: String
):Parcelable