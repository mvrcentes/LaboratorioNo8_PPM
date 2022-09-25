package gt.uvg.pokelist.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.model.ApiService
//import gt.uvg.pokelist.repository.PokemonRepository


class DetailFragment : Fragment() {
    companion object{
        const val p_ID = "pokemonId"
        const val p_URL = "pokemonURL"
    }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var pokemonId: Int = 0
    private var pokemonURL: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{pokemonId = it.getInt(p_ID)}
//        arguments?.let{pokemonURL = it.getString(p_URL).toString()}

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val pokemonList = PokemonRepository().getPokemonList()
//        val pokemon = pokemonList.find{it.id == pokemonId}
//
//
//        binding.textView.text= "Front"
//        Picasso.get().load(pokemon!!.imageUrlFront).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView2)
//        binding.textView2.text= "Back"
//        Picasso.get().load(pokemon.imageUrlBack).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView3)
//        binding.textView3.text= "Front Shiny"
//        Picasso.get().load(pokemon.imageUrlShinnyFront).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView4)
//        binding.textView4.text= "Back Shiny"
//        Picasso.get().load(pokemon.imageUrlShinnyBack).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView5)

        val pokemonList = ApiService.getFirst100Pokemon()
        val pokemon = pokemonList.find{it.id == pokemonId}


        binding.textView.text= "Front"
        Picasso.get().load(pokemon!!.imageUrlFront).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView2)
        binding.textView2.text= "Back"
        Picasso.get().load(pokemon.imageUrlBack).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView3)
        binding.textView3.text= "Front Shiny"
        Picasso.get().load(pokemon.imageUrlShinnyFront).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView4)
        binding.textView4.text= "Back Shiny"
        Picasso.get().load(pokemon.imageUrlShinnyBack).placeholder(R.drawable.default_image).error(R.drawable.default_image).into(binding.imageView5)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}