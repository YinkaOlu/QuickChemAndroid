package com.yinkaolu.quickchemandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yinkaolu.quickchemandroid.data.model.Element
import com.yinkaolu.quickchemandroid.data.model.PeriodicTable
import com.yinkaolu.quickchemandroid.data.repository.QuickChemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * View Model controlling data interaction between Periodic Table elements
 */
@HiltViewModel
class ElementsViewModel @Inject constructor(
    quickChemRepository: QuickChemRepository
): ViewModel() {
    init { quickChemRepository.loadElements() }

    val elements: LiveData<ArrayList<Element>> = quickChemRepository.getElements()

    val periodicTable: LiveData<PeriodicTable> = Transformations.map(elements){ elements ->
        PeriodicTable(elements)
    }
}