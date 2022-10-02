package io.github.asr.kape.test

import io.github.asr.kape.KapeTextColor
import io.github.asr.kape.entity.extendedModify
import io.github.asr.kape.entity.modify
import io.github.asr.kape.entity.summonEntity
import io.github.asr.kape.events.kapeEvents
import io.github.asr.kape.events.listener
import io.github.asr.kape.events.player.*
import io.github.asr.kape.inventory.extendedInventory
import io.github.asr.kape.inventory.inventory
import io.github.asr.kape.item.*
import io.github.asr.kape.text
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.EntityType
import org.bukkit.entity.Fireball
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.AnvilInventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.CrossbowMeta
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffectType

class KapeTestPlugin : JavaPlugin() {
    override fun onEnable() {
        val stack = stacker(Material.CROSSBOW).enchant(Enchantment.PIERCING, 3)

        stack.meta(CrossbowMeta::class.java) {
            it.addChargedProjectile(ItemStack(Material.SPECTRAL_ARROW))
        }

        listener {
            addEvent(PlayerInteractEvent::class.java) {
                it.player.sendMessage(text("인터렉트!"))
            }
        }

        kapeEvents {
            listener(InventoryClickEvent::class.java) {
                it.whoClicked.sendMessage(text("클릭!"))
            }

            listener(PlayerDropItemEvent::class.java) {
                it.player.openInventory(
                    extendedInventory(text("안녕하세요"), AnvilInventory::class.java) {
                        this.firstItem = stack
                    }
                )
            }

            onRightClick { event ->
                if (event.item?.type == Material.FIRE_CHARGE) {
                    event.player.launchProjectile(Fireball::class.java)
                }

                if (event.item?.type == Material.ARMOR_STAND) {
                    event.player.world.spawnEntity(event.player.location, EntityType.ARMOR_STAND).modify {
                        equipment {
                            helmet = ItemStack(Material.COMMAND_BLOCK)
                        }

                        potion {
                            addPotion(PotionEffectType.GLOWING)
                        }

                        util {
                            isInvisible = true
                        }
                    }

                    event.player.location.summonEntity(EntityType.ARMOR_STAND).extendedModify(ArmorStand::class.java) {
                        it.modify {
                            equipment {
                                helmet = ItemStack(Material.DIAMOND_BLOCK)
                            }
                        }
                        it.isInvisible = true
                        it.setArms(true)
                    }
                }
            }

            onInteractEntity {
                server.broadcast(text("건드리지마!"))
            }

            onChat { event ->
                event.isCancelled = false
                event.message(text("${event.player.name} : ${event.textMessage().content()}")
                    .color(KapeTextColor.GOLD.toTextColor()))

                event.player.openInventory(
                    inventory(text("테스트"), 3) {
                        set(13, ItemStack(Material.COMMAND_BLOCK))
                    }
                )
            }

            onJoin { event ->
                event.joinMessage(text("두등등장!"))
            }

            onQuit { event ->
                event.quitMessage(text("난 이만!"))
            }

            onDeath { event ->
                event.deathMessage(text("사망에 이르고 마는데..."))
            }

            onRespawn { event ->
                server.broadcast(text("개같이 재등장!"))
            }
        }
    }
}