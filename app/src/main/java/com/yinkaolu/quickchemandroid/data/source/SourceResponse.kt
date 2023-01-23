package com.yinkaolu.quickchemandroid.data.source

import com.yinkaolu.quickchemandroid.data.model.Element

sealed interface SourceResponse {
    data class Success(
       val elements: ArrayList<Element>
    ) : SourceResponse

    object SourceUnavailable : SourceResponse

    object MissingSourceResponse : SourceResponse

    object UnsuccessfulSourceResponse : SourceResponse
}