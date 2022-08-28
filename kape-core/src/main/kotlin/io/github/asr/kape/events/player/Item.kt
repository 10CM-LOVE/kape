package io.github.asr.kape.events.player

import io.github.asr.kape.events.Events
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAttemptPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerItemConsumeEvent

fun Events.onPickUpItem(action: (PlayerAttemptPickupItemEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerAttemptPickupItemEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}

fun Events.onDropItem(action: (PlayerDropItemEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerDropItemEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}

fun Events.onItemConsume(action: (PlayerItemConsumeEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerItemConsumeEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}