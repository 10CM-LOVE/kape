package io.github.asr.kape.events.player

import io.github.asr.kape.events.Events
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerInteractEvent

fun Events.onRightClick(action: (PlayerInteractEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerInteractEvent) {
            if (event.action.isRightClick) event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}

fun Events.onLeftClick(action: (PlayerInteractEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerInteractEvent) {
            if (event.action.isLeftClick) event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}

fun Events.onInteractEntity(action: (PlayerInteractAtEntityEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: PlayerInteractAtEntityEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}