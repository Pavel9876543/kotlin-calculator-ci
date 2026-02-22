package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private var current = ""
    private var operand = ""
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)

        val digits = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        digits.forEach {
            findViewById<Button>(it).setOnClickListener { b ->
                current += (b as Button).text
                result.text = current
            }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener { setOp("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener { setOp("-") }
        findViewById<Button>(R.id.btnMul).setOnClickListener { setOp("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { setOp("/") }
        findViewById<Button>(R.id.btnEq).setOnClickListener { calc() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clear() }
    }

    private fun setOp(op: String) {
        operand = current
        operator = op
        current = ""
    }

    private fun calc() {
        val a = operand.toDouble()
        val b = current.toDouble()
        val res = when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> 0.0
        }
        current = res.toString()
        result.text = current
    }

    private fun clear() {
        current = ""
        operand = ""
        operator = ""
        result.text = "0"
    }
}
