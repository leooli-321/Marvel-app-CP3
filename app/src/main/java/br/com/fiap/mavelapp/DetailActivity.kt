package br.com.fiap.mavelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Referências aos elementos da UI
        val characterImageView = findViewById<ImageView>(R.id.characterImageView)
        val characterNameTextView = findViewById<TextView>(R.id.characterNameTextView)
        val characterDetailsTextView = findViewById<TextView>(R.id.characterDetailsTextView)
        val characterDescriptionTextView = findViewById<TextView>(R.id.characterDescriptionTextView)

        // Recebendo dados da Intent com verificação de valores padrão
        val imageResId = intent.getIntExtra("imageResId", android.R.drawable.ic_menu_gallery) // Usando um recurso padrão do Android
        val name = intent.getStringExtra("characterName") ?: "Nome não disponível"
        val details = intent.getStringExtra("characterDetails") ?: "Detalhes não disponíveis"
        val description = intent.getStringExtra("characterDescription") ?: "Descrição não disponível"

        // Definindo os dados na UI
        characterImageView.setImageResource(imageResId)
        characterNameTextView.text = name
        characterDetailsTextView.text = details
        characterDescriptionTextView.text = description
    }
}
