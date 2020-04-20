package com.yinkaolu.quickchemandroid.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yinkaolu.quickchemandroid.data.source.QuickChemAPI
import com.yinkaolu.quickchemandroid.data.model.Element
import com.yinkaolu.quickchemandroid.data.source.QuickChemSource
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuickChemRepository {

    private val elements: MutableLiveData<ArrayList<Element>> = MutableLiveData()
    private val loadError: MutableLiveData<String?> = MutableLiveData()

    fun loadElements() {
        QuickChemSource.getElements(object : QuickChemSource.Observer {
            override fun onSuccess(elements: ArrayList<Element>) {
                QuickChemRepository.elements.postValue(elements)
            }

            override fun onFailure(errorMessage: String?) {
                loadError.postValue(errorMessage)
            }

        })
    }

    fun getElements(): LiveData<ArrayList<Element>> {
        return elements
    }
}