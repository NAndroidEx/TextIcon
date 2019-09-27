package com.nandroidex.texticon

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class FontTextView : AppCompatTextView {
    private var isBrandingIcon: Boolean = false
    private var isSolidIcon: Boolean = false

    constructor(context: Context) : super(context) {}

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet, defStyle: Int = 0) : super(
        context,
        attrs,
        defStyle
    ) {
        val a = context.theme.obtainStyledAttributes(
            attrs, R.styleable.TextIcon,
            0, 0
        )
        isSolidIcon = a.getBoolean(R.styleable.TextIcon_solid_icon, false)
        isBrandingIcon = a.getBoolean(R.styleable.TextIcon_brand_icon, false)
        init()
    }

    private fun init() {
        if (isBrandingIcon)
            typeface = FontCache.get(context, "fa-brands-400.ttf")
        else if (isSolidIcon)
            typeface = FontCache.get(context, "fa-solid-900.ttf")
        else
            typeface = FontCache.get(context, "fa-regular-400.ttf")
    }
}
