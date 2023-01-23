package com.yinkaolu.quickchemandroid.data.source

/**
 * Remove source for chemistry data
 */
interface QuickChemSource {
    suspend fun getElements() : SourceResponse
}