package com.alpamedev.pokewixexplorer.ui.di

import com.alpamedev.data.datasources.GenerationRemoteDataSource
import com.alpamedev.data.datasources.PokemonRemoteDataSource
import com.alpamedev.pokewixexplorer.framework.db.RetrofitConfig
import com.alpamedev.pokewixexplorer.framework.db.remote.GenerationRemoteDB
import com.alpamedev.pokewixexplorer.framework.db.remote.PokemonRemoteDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UiModule {

    @Provides
    fun providePokemonRemoteDataSource(): PokemonRemoteDataSource {
        return PokemonRemoteDB(RetrofitConfig)
    }

    @Provides
    fun provideGenerationRemoteDataSource(): GenerationRemoteDataSource {
        return GenerationRemoteDB(RetrofitConfig)
    }
}