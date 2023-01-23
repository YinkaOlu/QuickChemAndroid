package com.yinkaolu.quickchemandroid.data.source

import androidx.lifecycle.MutableLiveData
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RealQuickChemSource @Inject constructor() : QuickChemSource {
    private val okhttpClient = OkHttpClient().newBuilder().build()
    private val retrofitClient = Retrofit.Builder()
        .client(okhttpClient)
        .baseUrl("https://us-central1-quickchemapi.cloudfunctions.net/app/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val quickChemAPI = retrofitClient.create(QuickChemAPI::class.java)

    override suspend fun getElements(): SourceResponse {
        val response = quickChemAPI.getElements().awaitResponse()
        return if (!response.isSuccessful) SourceResponse.UnsuccessfulSourceResponse
        else {
            response.body()?.let {
                SourceResponse.Success(it)
            } ?: SourceResponse.MissingSourceResponse
        }
    }
}