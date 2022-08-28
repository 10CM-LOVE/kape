package io.github.asr.kape.events.player

import io.github.asr.kape.events.Events
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

fun Events.onJoin(action: (PlayerJoinEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerJoinEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}

fun Events.onQuit(action: (PlayerQuitEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerQuitEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}