# App Desenvolvido por:

Beatriz Silva - RM552600 <br>
Leonardo de Oliveira - RM554024 <br>
Pedro Henrique Soares Araujo - RM553801


# MarvelApp

MarvelApp é um aplicativo Android desenvolvido em Kotlin que apresenta informações sobre personagens icônicos do universo Marvel. Cada personagem é exibido em um card que, ao ser pressionado, leva o usuário a uma tela de detalhes com uma imagem ampliada e uma breve descrição.


## Funcionalidades

- **Lista de Personagens**: Exibe uma lista de personagens Marvel com nome, grupo, ano de criação e criador.
- **Tela de Detalhes**: Ao selecionar um personagem, o usuário é levado a uma nova tela que mostra uma imagem maior do personagem, detalhes adicionais e uma descrição do personagem.
- **Pesquisa**: Inclui uma barra de pesquisa para facilitar a localização de personagens específicos.


## Tecnologias Utilizadas

- **Kotlin**: Linguagem principal para o desenvolvimento do aplicativo.
- **AndroidX**: Inclui componentes modernos de UI, como o `ConstraintLayout` e `RecyclerView`.
- **Data Binding**: Facilita a interação entre a UI e os dados.
- **Intent**: Permite a navegação entre atividades, passando dados entre a lista e a tela de detalhes.


## Estrutura do Projeto

- `MainActivity.kt`: Exibe a lista de personagens.
- `DetailActivity.kt`: Tela que exibe os detalhes de um personagem selecionado.
- `CharacterAdapter.kt`: Adaptador para o RecyclerView que gerencia os cards dos personagens.
- `Character.kt`: Data class que representa as propriedades de cada personagem.
