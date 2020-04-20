package com.yinkaolu.quickchemandroid.data

import retrofit2.Call
import retrofit2.http.GET

interface QuickChemAPI {
    @GET("allElements")
    fun getElements(): Call<ArrayList<Element>>
}