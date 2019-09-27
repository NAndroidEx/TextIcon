package com.nandroidex.texticon

import android.content.Context
import android.graphics.Typeface

import java.util.Hashtable

object FontCache {
    val FA_FONT_REGULAR = "fa-regular-400.ttf"
    val FA_FONT_SOLID = "fa-solid-900.ttf"
    val FA_FONT_BRANDS = "fa-brands-400.ttf"
    private val fontCache = Hashtable<String, Typeface>()

    operator fun get(context: Context, name: String): Typeface? {
        var typeface = fontCache[name]
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, name)
            } catch (e: Exception) {
                return null
            }

            fontCache[name] = typeface
        }
        return typeface
    }
}
