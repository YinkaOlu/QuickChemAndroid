package com.yinkaolu.quickchemandroid.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuickChemRepository {
    private val okhttpClient = OkHttpClient().newBuilder().build()
    private val retrofitClient = Retrofit.Builder()
        .client(okhttpClient)
        .baseUrl("https://quikchem.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val quickChemAPI = retrofitClient.create(QuickChemAPI::class.java)

    private val elements: MutableLiveData<ArrayList<Element>> = MutableLiveData()
    private val loadError: MutableLiveData<String?> = MutableLiveData()

    fun loadElements() {
        quickChemAPI.getElements().enqueue(object : Callback<ArrayList<Element>> {
            override fun onFailure(call: Call<ArrayList<Element>>, t: Throwable) {
                loadError.postValue(t.message)
            }

            override fun onResponse(call: Call<ArrayList<Element>>, response: Response<ArrayList<Element>>) {
                elements.postValue(response.body())
            }
        })
    }

    fun getElements(): LiveData<ArrayList<Element>> {
        return elements
    }
}