package com.yinkaolu.quickchemandroid.data.repository

import androidx.lifecycle.LiveData
import com.yinkaolu.quickchemandroid.data.model.Element

/**
 * Repository gate keeping access to Chemistry data
 */
interface QuickChemRepository {
    val elements: LiveData<ArrayList<Element>?>
    val loadError: LiveData<String?>
    fun loadElements()
}