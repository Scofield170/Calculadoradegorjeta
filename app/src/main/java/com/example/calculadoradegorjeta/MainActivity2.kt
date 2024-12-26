package com.example.calculadoradegorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoradegorjeta.databinding.ActivityMain2Binding
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        var pessoas = 0

        binding.tvPessoas.text = pessoas.toString()

        binding.buttonMais.setOnClickListener {
            pessoas++
            binding.tvPessoas.text = pessoas.toString()
        }

        binding.buttonMenos.setOnClickListener {
            if (pessoas > 0) {
                pessoas--
                binding.tvPessoas.text = pessoas.toString()
            }
        }

        binding.buttonCalcular.setOnClickListener {
            val valorStg = binding.edtValor.text.toString()
            val porcentagemStg = binding.edtPorcentagem.text.toString()

            if (valorStg.isEmpty() || porcentagemStg.isEmpty() || pessoas == 0) {
                Snackbar.make(
                    binding.edtValor,
                    "Preencha todos os campos e adicione pelo menos uma pessoa",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val valor = valorStg.toFloat()
                val porcentagem = porcentagemStg.toFloat()

                val valorTotal = valor * (porcentagem / 100) / pessoas

                binding.tvResultado.text = String.format("%.2f€", valorTotal)
            }
        }
    }
}