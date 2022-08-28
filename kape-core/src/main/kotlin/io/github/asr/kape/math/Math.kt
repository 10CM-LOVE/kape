package io.github.asr.kape.math

const val pi = Math.PI

fun Double.toRadians() = this / 180 * pi

fun Double.toDegrees() = this / pi * 180
