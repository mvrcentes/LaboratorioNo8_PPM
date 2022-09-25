
package gt.uvg.pokelist.view

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.model.ApiClient
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import gt.uvg.pokelist.repository.PokemonRepository


class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val pokemonList = PokemonRepository().getPokemonList()

//        val client = ApiClient.service.getFirst100Pokemon()
//        client.enqueue(object : retrofit2.Callback<PokemonResponse>{
//
//            override fun onResponse(
//                call: Call<PokemonResponse>,
//                response: Response<PokemonResponse>
//            ) {
//                if(response.isSuccessful){
//                    Log.d("siEntro", "")
//                    Log.d("Results", ""+response.body())
//                    val pokemonList = response.body()?.result
//                    recyclerView = binding.recyclerView
//                    recyclerView.layoutManager = LinearLayoutManager(context)
//                    recyclerView.adapter = pokemonList?.let { PokemonListAdapter(it) }
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonResponse>, t: Throwable){
//                Log.e("NoEntro","")
//                Log.e("failed", "holaaa"+t.message)
//            }
//        })

        val client = ApiClient.service.getFirst100Pokemon().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                val pokemonList = response.body()?.result
                recyclerView = binding.recyclerView
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = pokemonList?.let { PokemonListAdapter(it) }
                Toast.makeText(requireContext(), "FETCHED: " + response.body(), Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}