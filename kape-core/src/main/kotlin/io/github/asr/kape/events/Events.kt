package io.github.asr.kape.events

import io.github.asr.kape.KapeDSL
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin

private fun Events.registerListeners(plugin: Plugin) {
    plugin.server.pluginManager.registerEvents(this, plugin)
}

fun Plugin.kapeEvents(events: Events.() -> Unit) {
    Events().apply {
        plugin = this@kapeEvents
    }.apply(events).registerListeners(this)
}

@KapeDSL
class Events : Listener {
    lateinit var plugin: Plugin

    fun <T: Event> listener(clazz: Class<T>, block: (T) -> Unit) {

        plugin.server.pluginManager.registerEvents(
            object : Listener {
                @EventHandler
                fun onEvent(event: Event) {
                    clazz.cast(event).run(block)
                }
            }, plugin
        )
    }
}