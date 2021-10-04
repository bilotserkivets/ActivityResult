package com.example.activityresult

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.activityresult.databinding.ActivityMainBinding

const val PICK_RAINBOW_COLOR_INTENT = 1
const val RAINBOW_COLOR_NAME = "RAINBOW_COLOR_NAME"
const val RAINBOW_COLOR = "RAINBOW_COLOR"
const val DEFAULT_COLOR = "#FFFFFF"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var launcher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if (it.resultCode == RESULT_OK) {
                    var backgroundColor = it.data?.getIntExtra(RAINBOW_COLOR, Color
                        .parseColor(DEFAULT_COLOR)) ?: Color.parseColor(DEFAULT_COLOR)
                    val colorName = it.data?.getStringExtra(RAINBOW_COLOR_NAME) ?: ""
                    val colorMessage = getString(R.string.color_chosen_message, colorName)

                    binding.rainbowColor.setBackgroundColor(ContextCompat.getColor(this, backgroundColor))
                    binding.rainbowColor.isVisible = true
                    binding.rainbowColor.text = colorMessage
                }
        }

        binding.submitButton.setOnClickListener {
            launcher?.launch(Intent(this, RainbowColorPickerActivity::class.java))
        }
    }
}