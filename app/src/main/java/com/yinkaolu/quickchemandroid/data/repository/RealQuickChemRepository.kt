package com.yinkaolu.quickchemandroid.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yinkaolu.quickchemandroid.data.model.Element
import com.yinkaolu.quickchemandroid.data.source.Response
import com.yinkaolu.quickchemandroid.data.source.QuickChemSource
import javax.inject.Inject

class RealQuickChemRepository @Inject constructor(
    private val quickChemSource: QuickChemSource
) : QuickChemRepository {

    private val elements: MutableLiveData<ArrayList<Element>> = MutableLiveData()
    private val loadError: MutableLiveData<String?> = MutableLiveData()

    override fun loadElements() {
        quickChemSource.getElements(object : Response {
            override fun onSuccess(elements: ArrayList<Element>) {
                this@RealQuickChemRepository.elements.postValue(elements)
            }

            override fun onFailure(errorMessage: String?) {
                loadError.postValue(errorMessage)
            }

        })
    }

    override fun getElements(): LiveData<ArrayList<Element>> = elements
}