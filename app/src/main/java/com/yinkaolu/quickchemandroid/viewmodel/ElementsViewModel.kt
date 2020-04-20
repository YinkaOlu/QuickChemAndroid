package com.yinkaolu.quickchemandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yinkaolu.quickchemandroid.data.model.Element
import com.yinkaolu.quickchemandroid.data.model.PeriodicTable
import com.yinkaolu.quickchemandroid.data.repository.QuickChemRepository

class ElementsViewModel: ViewModel() {
    init {
        QuickChemRepository.loadElements()
    }

    val elements: LiveData<ArrayList<Element>> = QuickChemRepository.getElements()

    val periodicTable: LiveData<PeriodicTable> = Transformations.map(elements){ elements ->
        PeriodicTable(elements)
    }
}