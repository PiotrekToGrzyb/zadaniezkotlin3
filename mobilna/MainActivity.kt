package com.example.kostki

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var diceImages: Array<ImageView>
    private lateinit var btnRzut: Button
    private lateinit var tvWynik: TextView

    private val diceValues = IntArray(5) { 0 }
    private val isAvailable = BooleanArray(5) { true }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        diceImages = arrayOf(
            findViewById(R.id.dice1),
            findViewById(R.id.dice2),
            findViewById(R.id.dice3),
            findViewById(R.id.dice4),
            findViewById(R.id.dice5)
        )

        btnRzut = findViewById(R.id.btnRzut)
        tvWynik = findViewById(R.id.tvWynik)

        if (savedInstanceState != null) {
            val savedValues = savedInstanceState.getIntArray("diceValues")
            val savedAvailable = savedInstanceState.getBooleanArray("isAvailable")
            if (savedValues != null && savedValues.size == 5) {
                for (i in 0 until 5) {
                    diceValues[i] = savedValues[i]
                }
            }
            if (savedAvailable != null && savedAvailable.size == 5) {
                for (i in 0 until 5) {
                    isAvailable[i] = savedAvailable[i]
                }
            }
            updateUI()
        }

        btnRzut.setOnClickListener {
            rollDice()
        }

        for (i in diceImages.indices) {
            diceImages[i].setOnClickListener {
                toggleDice(i)
            }
        }
    }

    private fun rollDice() {
        for (i in 0 until 5) {
            if (isAvailable[i]) {
                diceValues[i] = (1..6).random()
            }
        }
        updateUI()
    }

    private fun toggleDice(index: Int) {
        isAvailable[index] = !isAvailable[index]
        diceImages[index].alpha = if (isAvailable[index]) 1.0f else 0.5f
    }

    private fun updateUI() {
        var sum = 0
        for (i in 0 until 5) {
            sum += diceValues[i]
            val drawableRes = when (diceValues[i]) {
                1 -> R.drawable.kosc1
                2 -> R.drawable.kosc2
                3 -> R.drawable.kosc3
                4 -> R.drawable.kosc4
                5 -> R.drawable.kosc5
                6 -> R.drawable.kosc6
                else -> R.drawable.kosc0
            }
            diceImages[i].setImageResource(drawableRes)
            diceImages[i].alpha = if (isAvailable[i]) 1.0f else 0.5f
        }
        tvWynik.text = sum.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("diceValues", diceValues)
        outState.putBooleanArray("isAvailable", isAvailable)
    }
}
