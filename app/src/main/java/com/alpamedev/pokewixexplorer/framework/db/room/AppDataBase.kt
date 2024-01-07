package com.alpamedev.pokewixexplorer.framework.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alpamedev.pokewixexplorer.framework.db.room.dao.GenerationDao
import com.alpamedev.pokewixexplorer.framework.db.room.dao.PokemonDao
import com.alpamedev.pokewixexplorer.framework.db.room.dao.ResultGenerationDao
import com.alpamedev.pokewixexplorer.framework.db.room.entities.generation.GenerationEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.generation.ResultGenerationEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.PokemonEntity

@Database(entities = [PokemonEntity::class, ResultGenerationEntity::class, GenerationEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [Converters::class])
abstract class AppDataBase: RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "app.db"
        private var instance: AppDataBase? = null

        private fun create(context: Context): AppDataBase =
            Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): AppDataBase =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun getGenerationDao(): GenerationDao
    abstract fun getResultGenerationDao(): ResultGenerationDao
    abstract fun getPokemonDao(): PokemonDao
}