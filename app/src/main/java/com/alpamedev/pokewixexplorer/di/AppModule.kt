package com.alpamedev.pokewixexplorer.di

import android.content.Context
import com.alpamedev.data.datasources.local.GenerationLocalDataSource
import com.alpamedev.data.datasources.local.PokemonLocalDataSource
import com.alpamedev.data.datasources.remote.GenerationRemoteDataSource
import com.alpamedev.data.datasources.remote.PokemonRemoteDataSource
import com.alpamedev.pokewixexplorer.framework.db.api.RetrofitConfig
import com.alpamedev.pokewixexplorer.framework.db.local.GenerationLocalDB
import com.alpamedev.pokewixexplorer.framework.db.local.PokemonLocalDB
import com.alpamedev.pokewixexplorer.framework.db.remote.GenerationRemoteDB
import com.alpamedev.pokewixexplorer.framework.db.remote.PokemonRemoteDB
import com.alpamedev.pokewixexplorer.framework.db.room.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providePokemonRemoteDataSource(): PokemonRemoteDataSource {
        return PokemonRemoteDB(RetrofitConfig)
    }

    @Provides
    fun provideGenerationRemoteDataSource(): GenerationRemoteDataSource {
        return GenerationRemoteDB(RetrofitConfig)
    }

    @Provides
    fun providePokemonLocalDataSource(@ApplicationContext context: Context): PokemonLocalDataSource {
        return PokemonLocalDB(AppDataBase.getInstance(context).getPokemonDao())
    }

    @Provides
    fun provideGenerationLocalDataSource(@ApplicationContext context: Context): GenerationLocalDataSource {
        return GenerationLocalDB(AppDataBase.getInstance(context).getGenerationDao(), AppDataBase.getInstance(context).getResultGenerationDao())
    }
}