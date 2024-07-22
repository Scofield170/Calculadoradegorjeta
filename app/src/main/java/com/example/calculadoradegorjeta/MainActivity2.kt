package com.example.calculadoradegorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val edtValor = findViewById<EditText>(R.id.edtValor)
        val edtPorcentagem = findViewById<EditText>(R.id.edtPorcentagem)
        val tvPessoas = findViewById<TextView>(R.id.textView7)
        val edtValorTotal = findViewById<TextView>(R.id.textView10)
        val btnMenos = findViewById<Button>(R.id.buttonMenos)
        val btnMais = findViewById<Button>(R.id.buttonMais)
        val btnCalcular = findViewById<Button>(R.id.buttonCalcular)

        var pessoas = 0

        tvPessoas.text = pessoas.toString()

        btnMais.setOnClickListener {
            pessoas++
            tvPessoas.text = pessoas.toString()
        }

        btnMenos.setOnClickListener {
            if (pessoas > 0) {
                pessoas--
                tvPessoas.text = pessoas.toString()
            }
        }

        btnCalcular.setOnClickListener {
            val valorStg = edtValor.text.toString()
            val porcentagemStg = edtPorcentagem.text.toString()

            if (valorStg.isEmpty() || porcentagemStg.isEmpty() || pessoas == 0) {
                Snackbar.make(
                    edtValor,
                    "Preencha todos os campos e adicione pelo menos uma pessoa",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val valor = valorStg.toFloat()
                val porcentagem = porcentagemStg.toFloat()

                val valorTotal = valor * (porcentagem / 100) / pessoas

                edtValorTotal.text = String.format("%.2f€", valorTotal)
            }
        }
    }
}