package com.yinkaolu.quickchemandroid.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yinkaolu.quickchemandroid.data.model.Element
import com.yinkaolu.quickchemandroid.data.source.QuickChemSource
import com.yinkaolu.quickchemandroid.data.source.SourceResponse
import kotlinx.coroutines.*
import javax.inject.Inject

class RealQuickChemRepository @Inject constructor(
    private val quickChemSource: QuickChemSource
) : QuickChemRepository {
    private val scope = CoroutineScope(Dispatchers.Main)

    private val _elements: MutableLiveData<ArrayList<Element>?> = MutableLiveData()
    override val elements: LiveData<ArrayList<Element>?> = _elements

    private val _loadError: MutableLiveData<String?> = MutableLiveData()
    override val loadError: LiveData<String?> = _loadError

    override fun loadElements() {
        _elements.postValue(null)
        _loadError.postValue(null)
        scope.launch{
            when(val sourceResponse = quickChemSource.getElements()) {
                is SourceResponse.Success ->
                    _elements.postValue(sourceResponse.elements)
                is SourceResponse.UnsuccessfulSourceResponse ->
                    _loadError.postValue("Call to Source was unsuccessful")
                is SourceResponse.SourceUnavailable ->
                    _loadError.postValue("Source is unavailable")
                is SourceResponse.MissingSourceResponse ->
                    _loadError.postValue("Source is missing element data")
            }
        }
    }
}