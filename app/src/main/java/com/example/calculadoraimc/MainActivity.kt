package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

  class MainActivity : AppCompatActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)

// atribuindo os elementos das interface a variaveis locais, usando o metodo 'findViewById()'
          val nome = findViewById<EditText>(R.id.editTextNome)
          val pesoedit = findViewById<EditText>(R.id.editTextPeso)
          val alturaedit = findViewById<EditText>(R.id.editTextAltura)
          val botao = findViewById<Button>(R.id.buttonCalcular)
          val resultado = findViewById<TextView>(R.id.textResultado)
          val limpar = findViewById<Button>(R.id.buttonlimpar)


          botao.setOnClickListener(object : View.OnClickListener {
              override fun onClick(v: View?) {

                  val peso = pesoedit.text.toString().toDoubleOrNull()?: 0.0
                  val altura = alturaedit.text.toString().toDoubleOrNull()?: 1.0

                  val imc = calcularIMC(peso, altura)


                  resultado.setText("${nome.text} Seu IMC é: ${imc.format(2)} ${classificarIMC(imc)}")
              }
          })
          limpar.setOnClickListener(object : View.OnClickListener {
              override fun onClick(v: View?) {
                  nome.setText ("")
                  pesoedit.setText ("")
                  alturaedit.setText ("")
                  resultado.setText ("")
              }
          })
      }

      private fun calcularIMC(peso: Double, altura: Double): Double {
          return peso / (altura * altura)
      }

      private fun classificarIMC(imc: Double): String {
          return when {
              imc < 18.5 -> "Magreza"
              imc < 25 -> "Normal"
              imc < 30 -> "Sobrepeso"
              else -> "Obesidade"
          }
      }
      private fun Double.format(digits: Int) = DecimalFormat("#,##0.00").format(this)


  }












