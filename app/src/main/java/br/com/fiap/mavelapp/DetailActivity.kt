package br.com.fiap.mavelapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.mavelapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receber dados do Intent
        val imageResId = intent.getIntExtra("imageResId", 0)
        val characterName = intent.getStringExtra("characterName") ?: "Nome não disponível"
        val characterDetails = intent.getStringExtra("characterDetails") ?: "Detalhes não disponíveis"
        val characterDescription = intent.getStringExtra("characterDescription") ?: "Descrição não disponível"


        Log.d("DetailActivity", "imageResId: $imageResId")
        Log.d("DetailActivity", "characterName: $characterName")
        Log.d("DetailActivity", "characterDetails: $characterDetails")
        Log.d("DetailActivity", "characterDescription: $characterDescription")

        // Preencher os views com os dados recebidos
        binding.characterImageView.setImageResource(imageResId)
        binding.characterNameTextView.text = characterName
        binding.characterDetailsTextView.text = characterDetails
        binding.characterDescriptionTextView.text = characterDescription

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}
