package com.example.project_kbm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelNews (
    val name: String?,
    val date: String?,
    val nameNews: String?,
    val nameCategory: String?,
    val detailNews: String?
) : Parcelable