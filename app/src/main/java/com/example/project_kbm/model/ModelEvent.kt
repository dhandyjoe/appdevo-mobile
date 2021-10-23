package com.example.project_kbm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelEvent(
    val poster: Int,
    val name: String? = "",
    val url: String? = "",
    val cardPoster: Int
): Parcelable
