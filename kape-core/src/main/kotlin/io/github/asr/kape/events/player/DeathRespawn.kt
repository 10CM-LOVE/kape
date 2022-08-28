package io.github.asr.kape.events.player

import io.github.asr.kape.events.Events
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerRespawnEvent

fun Events.onDeath(action: (PlayerDeathEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerDeathEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}

fun Events.onRespawn(action: (PlayerRespawnEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerRespawnEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}