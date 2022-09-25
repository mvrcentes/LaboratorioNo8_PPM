package gt.uvg.pokelist.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.*

object ApiClient {
    val BASE_URL = "https://pokeapi.co"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val simpleService: SimpleService by lazy {
        retrofit.create(SimpleService::class.java)
    }
}

interface SimpleService {
    @GET("posts")
    suspend fun listPosts() : List<Pokemon>
    @GET("posts/{userId}")
    suspend fun listByUser(@Path("userId") userId:String): List<Pokemon>
    @GET("posts/search")  // becomes post/search?filter=query
    suspend fun search(@Query("filter") search: String): List<Pokemon>
    @POST("posts/new")
    suspend fun create(@Body post : Pokemon): Pokemon
}


