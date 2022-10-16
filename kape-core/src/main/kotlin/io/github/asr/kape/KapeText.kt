package io.github.asr.kape

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.util.HSVLike

fun Component.toText() = this as TextComponent


fun text(content: String) = Component.text(content)

fun RGB(red: Int, green: Int, blue: Int) = HSVLike.fromRGB(red, green, blue)

enum class KapeTextColor(private val color: TextColor) {
    BLACK(TextColor.color(RGB(0, 0, 0))),
    DARK_BLUE(TextColor.color(RGB(0, 0, 170))),
    DARK_GREEN(TextColor.color(RGB(0, 170, 0))),
    DARK_AQUA(TextColor.color(RGB(0, 170, 170))),
    DARK_RED(TextColor.color(RGB(170, 0, 0))),
    DARK_PURPLE(TextColor.color(RGB(170, 0, 170))),
    GOLD(TextColor.color(RGB(255, 170, 0))),
    GRAY(TextColor.color(RGB(170, 170, 170))),
    DARK_GRAY(TextColor.color(RGB(85, 85, 85))),
    BLUE(TextColor.color(RGB(85, 85, 255))),
    GREEN(TextColor.color(RGB(85, 255, 85))),
    AQUA(TextColor.color(RGB(85, 255, 255))),
    LIGHT_PURPLE(TextColor.color(RGB(255, 85, 255))),
    YELLOW(TextColor.color(RGB(255, 255, 85))),
    WHITE(TextColor.color(RGB(255, 85, 85)));

    fun toTextColor() = color
}

operator fun Component.plus(component: Component) = append(component)
