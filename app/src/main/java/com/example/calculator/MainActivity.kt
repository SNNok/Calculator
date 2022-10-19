package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.jar.Pack200


class MainActivity : AppCompatActivity() {
    private lateinit var math_operation:TextView
    private lateinit var result_text:TextView
    private lateinit var zeroButton:TextView
    private lateinit var button1:TextView
    private lateinit var button2:TextView
    private lateinit var button3:TextView
    private lateinit var button4:TextView
    private lateinit var button5:TextView
    private lateinit var button6:TextView
    private lateinit var button7:TextView
    private lateinit var button8:TextView
    private lateinit var button9:TextView
    private lateinit var ACButton:TextView
    private lateinit var parentheses1Button:TextView
    private lateinit var parentheses2Button:TextView
    private lateinit var divisionButton:TextView
    private lateinit var multiplyButton:TextView
    private lateinit var plusButton:TextView
    private lateinit var minusButton:TextView
    private lateinit var dotButton:TextView
    private lateinit var DeleteButton:TextView
    private lateinit var equalsButton:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zeroButton.setOnClickListener {setTextFields("0")}
        button1.setOnClickListener {setTextFields("1")}
        button2.setOnClickListener {setTextFields("2")}
        button3.setOnClickListener {setTextFields("3")}
        button4.setOnClickListener {setTextFields("4")}
        button5.setOnClickListener {setTextFields("5")}
        button6.setOnClickListener {setTextFields("6")}
        button7.setOnClickListener {setTextFields("7")}
        button8.setOnClickListener {setTextFields("8")}
        button9.setOnClickListener {setTextFields("9")}
        parentheses1Button.setOnClickListener {setTextFields("(")}
        parentheses2Button.setOnClickListener {setTextFields(")")}
        divisionButton.setOnClickListener {setTextFields("/")}
        multiplyButton.setOnClickListener {setTextFields("*")}
        plusButton.setOnClickListener {setTextFields("+")}
        minusButton.setOnClickListener {setTextFields("-")}
        ACButton.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        DeleteButton.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""
        }
        equalsButton.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }
    fun setTextFields(str:String) {
        math_operation.append(str)
    }
}