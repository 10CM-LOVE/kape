package io.github.asr.kape.inventory

import io.github.asr.kape.KapeDSL
import net.kyori.adventure.text.Component
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

fun Plugin.inventory(title: Component, line: Int, block: InventoryModify.() -> Unit = {})
    = InventoryModify(server.createInventory(null, 9 * line, title)).apply(block).inventory

fun <T: Inventory> Plugin.extendedInventory(title: Component, inventoryClass: Class<T>, block: T.() -> Unit): T {
    val type = InventoryType::class.java.cast(inventoryClass)
    return inventoryClass.cast(server.createInventory(null, type, title)).apply(block)
}

@KapeDSL
class InventoryModify(val inventory: Inventory) {
    fun set(slot: Int, stack: ItemStack) = inventory.setItem(slot, stack)
}