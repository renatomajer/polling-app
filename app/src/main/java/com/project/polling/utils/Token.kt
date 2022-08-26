package com.project.polling.utils

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val bpi: Bpi = Bpi(),
    val time: Time = Time()
)

@Serializable
data class Time(
    val updated: String = ""
)

@Serializable
data class Bpi(
    val USD: USD = USD()
)

@Serializable
data class USD(
    val rate: String = "0.0"
)