package com.yinkaolu.quickchemandroid.data.source

import com.yinkaolu.quickchemandroid.data.model.Element

/**
 * Remove source for chemistry data
 */
interface QuickChemSource {
    fun getElements(observer: Response)
}

interface Response {
    fun onSuccess(elements: ArrayList<Element>)
    fun onFailure(errorMessage: String?)
}