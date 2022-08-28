package io.github.asr.kape.location

import org.bukkit.Location
import org.bukkit.entity.Entity

fun Location.forward(distance: Double) = clone().add(direction.multiply(distance))

fun Entity.forward(distance: Double) = teleport(location.forward(distance))