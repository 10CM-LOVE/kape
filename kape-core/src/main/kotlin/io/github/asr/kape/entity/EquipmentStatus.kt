package io.github.asr.kape.entity

import io.github.asr.kape.KapeDSL
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

@KapeDSL
class EquipmentStatus {
    var helmet: ItemStack? = null
    var chestplate: ItemStack? = null
    var leggings: ItemStack? = null
    var boots: ItemStack? = null

    var itemInMainHand: ItemStack? = null
    var itemInOffHand: ItemStack? = null
}

@KapeDSL
class PotionStatus {
    private val potions = mutableListOf<PotionEffect>()

    fun addPotion(type: PotionEffectType, amplifier: Int = 0, duration: Int = Int.MAX_VALUE,
                  ambient: Boolean = false, particles: Boolean = false, icon: Boolean = false) {
        potions.add(PotionEffect(type, duration, amplifier, ambient, particles, icon))
    }

    fun potionEffects() = potions
}