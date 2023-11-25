package org.d3ifcool.modidemo.tutorial

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object TutorApi {

    private const val BASE_URL = "https://raw.githubusercontent.com/AlifFadhlan/ModiKeyDemo/static-api/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrotif = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service: TutorService by lazy {
        retrotif.create(TutorService::class.java)
    }

    fun getTutorUrl(imageId: String): String {
        return "$BASE_URL$imageId.png"
    }

    interface TutorService {
        @GET("tutor-api.json")
        suspend fun getTutor(): List<TutorModel>
    }
}