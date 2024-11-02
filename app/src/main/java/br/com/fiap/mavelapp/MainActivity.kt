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
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista de personagens
        val characters = listOf(
            Character(
                "Captain America",
                "Avengers",
                "1941",
                "Joe Simon",
                R.drawable.captainamerica,
                "Um super soldado que luta contra injustiças e defende os inocentes.",
                "Lutador pela justiça, símbolo da liberdade e líder nato. Com seu escudo indestrutível, ele enfrenta vilões e inspira seus aliados."
            ),
            Character(
                "Iron Man",
                "Avengers",
                "1963",
                "Stan Lee",
                R.drawable.ironman,
                "Gênio bilionário que usa sua inteligência e recursos para criar armaduras poderosas.",
                "Criador da armadura que se transforma em uma extensão de si mesmo. Um inovador que desafia os limites da tecnologia e do heroísmo."
            ),
            Character(
                "Wolverine",
                "X-Men",
                "1974",
                "Len Wein",
                R.drawable.wolverine,
                "Um mutante com garras retráteis e um fator de cura impressionante.",
                "Regeneração e fúria são suas armas, além de um instinto de sobrevivência aguçado. Um solitário que busca um propósito em meio ao caos."
            ),
            Character(
                "Spiderman",
                "Avengers",
                "1962",
                "Stan Lee",
                R.drawable.spiderman,
                "Um jovem que ganha poderes aracnídeos e se torna um herói relutante.",
                "Sensores de aranha e agilidade incríveis permitem que ele enfrente adversários muito mais fortes. Sua vida é uma batalha constante entre ser um adolescente e um super-herói."
            ),
            Character(
                "Thor",
                "Avengers",
                "1962",
                "Stan Lee",
                R.drawable.thor,
                "Deus do trovão, príncipe de Asgard, com força sobre-humana e controle sobre o relâmpago.",
                "Martelo mágico e força imbatível fazem dele um dos guerreiros mais poderosos do universo. Ele luta para proteger tanto seu mundo quanto a Terra."
            )
        )


        // Configuração do RecyclerView
        characterAdapter = CharacterAdapter(characters) { character ->
            // Navegação para a DetailActivity com o personagem selecionado
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("imageResId", character.imageResId)
            intent.putExtra("characterName", character.name)
            intent.putExtra("characterDetails", character.details)
            intent.putExtra("characterDescription", character.description)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = characterAdapter

        // Configuração do SearchView
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                characterAdapter.filter.filter(query) // Filtra quando o usuário pressiona Enter
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                characterAdapter.filter.filter(newText) // Filtra enquanto o usuário digita
                return true
            }
        })
    }
}
