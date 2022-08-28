package io.github.asr.kape.entity

import io.github.asr.kape.KapeDSL
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity

fun Location.summonEntity(entityType: EntityType, block: EntityModify.() -> Unit = {}): LivingEntity {
    val entity = world.spawnEntity(this, entityType) as LivingEntity
    EntityModify(entity).run(block)
    return entity
}

fun Entity.modify(block: EntityModify.() -> Unit) {
    EntityModify(this as LivingEntity).run(block)
}

@KapeDSL
class EntityModify(private val entity: LivingEntity) {
    fun equipment(block: EquipmentStatus.() -> Unit) {
        val status = EquipmentStatus().apply(block)
        entity.equipment?.apply {
            setItemInMainHand(status.itemInMainHand)
            setItemInOffHand(status.itemInOffHand)

            helmet = status.helmet
            chestplate = status.chestplate
            leggings = status.leggings
            boots = status.boots
        }
    }

    fun potion(block: PotionStatus.() -> Unit) {
        val status = PotionStatus().apply(block)
        entity.addPotionEffects(status.potionEffects())
    }

    fun util(block: LivingEntity.() -> Unit) {
        entity.run(block)
    }
}