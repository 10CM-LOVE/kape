package io.github.asr.kape.entity

import org.bukkit.entity.Entity

fun <T: Entity> Entity.extendedModify(clazz: Class<T>, block: (T) -> Unit): T =
    (clazz.cast(this)).apply(block)