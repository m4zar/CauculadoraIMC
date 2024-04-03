package com.example.meuprimeiroaplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)

        btnCalcular.setOnClickListener {

            val alturastr = edtAltura.text.toString()
            val pesoStr = edtPeso. text.toString()

            if (alturastr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturastr.toFloat()
                val alturaFinal: Float = altura * altura
                val peso: Float = pesoStr.toFloat()
                val result: Float = peso / alturaFinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA RESULT", result)
                    }

                startActivity(intent)
            } else{
                Toast.makeText(this, "PREENCHER TODOS OS CAMPOS", Toast.LENGTH_LONG).show()
            }
        }
    }
}