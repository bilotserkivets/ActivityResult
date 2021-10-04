package com.example.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.activityresult.databinding.ActivityRainbowColorPickerBinding

class RainbowColorPickerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRainbowColorPickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRainbowColorPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            redButton.setOnClickListener(colorPickerClickListener)
            orangeButton.setOnClickListener(colorPickerClickListener)
            yellowButton.setOnClickListener(colorPickerClickListener)
            greenButton.setOnClickListener(colorPickerClickListener)
            blueButton.setOnClickListener(colorPickerClickListener)
            indigoButton.setOnClickListener(colorPickerClickListener)
            violetButton.setOnClickListener(colorPickerClickListener)
        }
    }

    private fun setRainbowColor(colorName: String, color: Int) {
        val i = Intent()
        i.putExtra(RAINBOW_COLOR_NAME, colorName)
        i.putExtra(RAINBOW_COLOR, color)
        setResult(RESULT_OK, i)
        finish()
    }

    val colorPickerClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.red_button -> setRainbowColor(getString(R.string.red), R.color.red)
            R.id.orange_button -> setRainbowColor(getString(R.string.orange), R.color.orange)
            R.id.yellow_button -> setRainbowColor(getString(R.string.yellow), R.color.yellow)
            R.id.green_button -> setRainbowColor(getString(R.string.green), R.color.green)
            R.id.blue_button -> setRainbowColor(getString(R.string.blue), R.color.blue)
            R.id.indigo_button -> setRainbowColor(getString(R.string.indigo), R.color.indigo)
            R.id.violet_button -> setRainbowColor(getString(R.string.violet), R.color.violet)
            else -> {
                Toast.makeText(this, getString(
                    R.string.unexpected_color), Toast.LENGTH_LONG).show()
            }
        }

    }
}