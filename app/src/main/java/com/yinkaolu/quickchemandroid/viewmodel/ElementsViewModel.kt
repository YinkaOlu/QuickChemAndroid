package com.yinkaolu.quickchemandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yinkaolu.quickchemandroid.data.Element
import com.yinkaolu.quickchemandroid.data.QuickChemRepository

class ElementsViewModel: ViewModel() {
    init {
        QuickChemRepository.loadElements()
    }
    fun getElements(): LiveData<ArrayList<Element>> {
        return QuickChemRepository.getElements()
    }
}