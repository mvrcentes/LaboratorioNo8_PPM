
package gt.uvg.pokelist.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name="url")
    val url: String,
    @Json(name="name")
    val name: String,
) {

    fun imageUrlFront(id: Int): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    fun imageUrlBack(id: Int): String  = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png"
    fun imageUrlShinnyFront(id: Int): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png"
    fun imageUrlShinnyBack(id: Int): String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/$id.png"
}

data class PokemonResponse(@Json(name="results")
                           val result : List<Pokemon>)