package io.github.asr.kape.events.player

import io.github.asr.kape.events.Events
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.TextComponent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

fun AsyncChatEvent.textMessage() = message() as TextComponent

fun Events.onChat(action: (AsyncChatEvent) -> Unit) {
    val listener = object : Listener {
        @EventHandler
        fun onEvent(event: AsyncChatEvent) {
            event.run(action)
        }
    }

    plugin.server.pluginManager.registerEvents(listener, plugin)
}