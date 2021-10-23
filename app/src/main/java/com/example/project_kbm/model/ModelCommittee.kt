package com.example.project_kbm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelCommittee(
    val nameCommittee: String?,
    val descCommittee: String?,
    val url: String?,
    val cardCommittee: Int
): Parcelable
