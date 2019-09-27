package com.nandroidex.texticonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clicked = false
        ftvSample.text = "click " + getString(R.string.fa_hand_pointer) + " anywhere to change"

        ftvSample.setOnClickListener {
            clicked = !clicked
            if (clicked) {
                ftvSample.text =
                    "click " + getString(R.string.fa_hand_pointer) + " anywhere to change"
            } else {
                ftvSample.text = "This is " + getString(R.string.fa_heart) + " heart"
            }
        }
    }
}
