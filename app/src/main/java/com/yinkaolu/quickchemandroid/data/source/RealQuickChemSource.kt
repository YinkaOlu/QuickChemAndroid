package com.yinkaolu.quickchemandroid.data.source

import com.yinkaolu.quickchemandroid.data.model.Element
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
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

    override fun getElements(observer: com.yinkaolu.quickchemandroid.data.source.Response) {
        quickChemAPI.getElements().enqueue(object : Callback<ArrayList<Element>> {
            override fun onFailure(call: Call<ArrayList<Element>>, t: Throwable) {
                observer.onFailure(t.message)
            }

            override fun onResponse(call: Call<ArrayList<Element>>, response: Response<ArrayList<Element>>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.let {
                        observer.onSuccess(it)
                    }
                } else {
                    observer.onFailure("Call to QuickChem API was unsuccessful")
                }

            }
        })
    }
}