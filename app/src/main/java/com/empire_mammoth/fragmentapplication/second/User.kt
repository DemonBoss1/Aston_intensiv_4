package com.empire_mammoth.fragmentapplication.second

import java.io.Serializable

data class User(
    var firstName: String,
    var lastName: String,
    var phone: String,
    val url: String
): Serializable
