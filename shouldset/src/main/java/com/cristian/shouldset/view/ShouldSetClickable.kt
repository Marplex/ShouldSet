package com.cristian.shouldset.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.cristian.shouldset.R

class ShouldSetClickable : LinearLayout {

    private lateinit var mShouldSetClickableContentTextView: TextView

    var text: String? = null
        set(value) {
            field = value
            mShouldSetClickableContentTextView.text = value
        }

    var backgroundColor: Int? = null
        set(value) {
            field = value
            if (value != null) mShouldSetClickableContentTextView.background =
                resources.getDrawable(value, context.theme)
        }

    var textColor: Int? = null
        set(value) {
            field = value
            if (value != null) mShouldSetClickableContentTextView.setTextColor(
                    ContextCompat.getColor(context, value)
            )
        }

    constructor(context: Context) : super(context) {
        onInit()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        onInit()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        onInit()
    }


    private fun onInit() {
        View.inflate(context, R.layout.shouldset_preference_clickable, this)
        mShouldSetClickableContentTextView = findViewById(R.id.shouldSetClickableContentTextView)
        elevation = 8.0F
    }

}