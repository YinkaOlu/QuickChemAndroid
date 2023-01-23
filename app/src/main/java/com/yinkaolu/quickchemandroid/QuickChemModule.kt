package com.yinkaolu.quickchemandroid

import com.yinkaolu.quickchemandroid.data.repository.QuickChemRepository
import com.yinkaolu.quickchemandroid.data.repository.RealQuickChemRepository
import com.yinkaolu.quickchemandroid.data.source.QuickChemSource
import com.yinkaolu.quickchemandroid.data.source.RealQuickChemSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class QuickChemModule {
    @Provides
    fun provideQuickChemSource() : QuickChemSource = RealQuickChemSource()

    @Provides
    @Singleton
    fun provideQuickChemRepository(source: QuickChemSource) : QuickChemRepository =
        RealQuickChemRepository(
            quickChemSource = source
        )
}