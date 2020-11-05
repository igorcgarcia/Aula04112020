package com.example.mainactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userProfileAvatar: String,
    val userName: String,
    val userLastMessage: String,
    val userLastView: String,
    val userMessagesCount: Int = 0
) :Parcelable