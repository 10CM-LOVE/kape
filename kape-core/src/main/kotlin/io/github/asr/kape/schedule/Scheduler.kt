package io.github.asr.kape.schedule

import org.bukkit.plugin.Plugin

fun Plugin.later(tick: Long, block: () -> Unit) =
    server.scheduler.runTaskTimer(this, Runnable(block), tick, 0L)

fun Plugin.loop(term: Long, times: Int, block: () -> Unit) {
    val id = server.scheduler.scheduleSyncRepeatingTask(this, block, 0L, term)
    later(times * term) { server.scheduler.cancelTask(id) }
}