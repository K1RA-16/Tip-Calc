package org.hyperskill.calculator.tip

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    var percentage = "0"
    var tex = ""
    private var bill:Double = 0.0
    private var tip:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edittext = findViewById<EditText>(R.id.edit_text)
        val s = findViewById<Slider>(R.id.slider)
        edittext.addTextChangedListener(object: TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                tex = p0.toString()
                bill = tex.toDouble()

            }

        })
        s.addOnChangeListener(object: Slider.OnChangeListener{
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {

                percentage = (value).toString()
                tip = percentage.toDouble()
                calc(bill,tip)
            }

        })










    }

    @SuppressLint("SetTextI18n")
    fun calc (bill: Double, tip:Double)
    {
        val calculate:Double = bill*(tip/100)
       val c = "%.2f".format(calculate)
        val txt = findViewById<TextView>(R.id.text_view)
        txt.text = "Tip amount: $c"


    }
}