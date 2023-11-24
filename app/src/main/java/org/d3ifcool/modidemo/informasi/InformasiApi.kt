package org.d3ifcool.modidemo.informasi


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


object InformasiApi {

    private const val BASE_URL = "https://raw.githubusercontent.com/AlifFadhlan/ModiKeyDemo/static-api/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrotif = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service: InformasiService by lazy {
        retrotif.create(InformasiService::class.java)
    }

    fun getInformasiUrl(imageId: String): String {
        return "$BASE_URL$imageId.png"
    }

    interface InformasiService {
        @GET("static-api.json")
        suspend fun getInformasi(): List<InfoModel>
    }
}