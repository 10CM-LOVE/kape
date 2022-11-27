package io.github.asr.kape.schedule

import org.bukkit.plugin.Plugin

fun Plugin.later(tick: Long, block: () -> Unit) =
    server.scheduler.runTaskLater(this, Runnable(block), tick)

fun Plugin.loop(term: Long, times: Int, block: () -> Unit) {
    val id = server.scheduler.scheduleSyncRepeatingTask(this, block, 0L, term)
    later(times * term) { server.scheduler.cancelTask(id) }
}