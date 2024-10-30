package br.com.fiap.mavelapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.mavelapp.databinding.ActivityMainBinding

data class Character(
    val name: String,
    val group: String,
    val year: String,
    val creator: String,
    val imageResId: Int,
    val details: String,
    val description: String
)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// Lista de personagens
        val characters = listOf(
            Character("Captain America", "Avengers", "1941", "Joe Simon", R.drawable.captainamerica, "Um super soldado", "Lutador pela justiça"),
            Character("Iron Man", "Avengers", "1963", "Stan Lee", R.drawable.ironman, "Gênio bilionário", "Criador da armadura"),
            Character("Wolverine", "X-Men", "1974", "Len Wein", R.drawable.wolverine, "Mutante com garras", "Regeneração e fúria"),
            Character("Spiderman", "Avengers", "1962", "Stan Lee", R.drawable.spiderman, "Homem-aranha", "Sensores de aranha e agilidade"),
            Character("Thor", "Avengers", "1962", "Stan Lee", R.drawable.thor, "Deus do trovão", "Martelo mágico e força imbatível")
        )



        // Configuração do RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CharacterAdapter(characters) { character ->
            // Navegação para a DetailActivity com o personagem selecionado
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("imageResId", character.imageResId)
            intent.putExtra("characterName", character.name)
            intent.putExtra("characterDetails", character.details)
            intent.putExtra("characterDescription", character.description)
            startActivity(intent)
        }
    }
}
