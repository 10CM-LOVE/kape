package io.github.asr.kape.utils

import org.bukkit.Bukkit
import org.bukkit.World

enum class BasicWorld(val world: World) {
    OVER(Bukkit.getWorld("world")!!),
    NETHER(Bukkit.getWorld("world_nether")!!),
    END(Bukkit.getWorld("world_the_end")!!);
}