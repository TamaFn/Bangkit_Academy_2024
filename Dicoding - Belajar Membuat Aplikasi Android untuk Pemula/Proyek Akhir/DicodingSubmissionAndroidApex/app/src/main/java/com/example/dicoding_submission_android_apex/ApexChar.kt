package com.example.dicoding_submission_android_apex

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApexChar(
    var name: String? = "",
    var gender: String? = "",
    var age: String? = "",
    var homeworld: String? = "",
    var classtype: String? = "",
    var tacticalability: String? = "",
    var passiveability: String? = "",
    var ultimateability: String? = "",
    var tacticaldescription: String? = "",
    var passivedescription: String? = "",
    var ultimatedescription: String? = "",
    var photoprofile: Int? = 0,
    var photocover: Int? = 0,
    var icontactical: Int? = 0,
    var iconpassive: Int? = 0,
    var iconultimate: Int? = 0,
    var iconclass:Int? = 0
) : Parcelable
