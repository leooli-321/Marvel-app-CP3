package br.com.fiap.mavelapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.mavelapp.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var characterList: List<Character>,
    private var filteredList: List<Character> = characterList,
    private val itemClick: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>(), Filterable {

    class ViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = filteredList[position]
        holder.binding.characterName.text = character.name
        holder.binding.characterImage.setImageResource(character.imageResId)

        holder.itemView.setOnClickListener {
            itemClick(character)
        }
    }

    override fun getItemCount(): Int = filteredList.size

    // Implementação do método filter
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                filterResults.values = if (constraint.isNullOrEmpty()) {
                    characterList // Retorna a lista original se não houver texto
                } else {
                    val query = constraint.toString().lowercase()
                    // Filtra a lista com base na pesquisa
                    characterList.filter { it.name.lowercase().contains(query) }
                }
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredList = results?.values as List<Character>
                notifyDataSetChanged() // Notifica o RecyclerView para atualizar
            }
        }
    }
}
