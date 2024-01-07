package com.alpamedev.pokewixexplorer.framework.db.room

import androidx.room.TypeConverter
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.AbilityEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.MoveEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.SpritesEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.StatEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.pokemon.TypeEntity
import com.alpamedev.pokewixexplorer.framework.db.room.entities.specie.SpecieEntity
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun specieEntityListToJson(value: List<SpecieEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToSpecieEntityList(value: String) = Gson().fromJson(value, Array<SpecieEntity>::class.java).toList()

    @TypeConverter
    fun abilityEntityListToJson(value: List<AbilityEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToAbilityEntityList(value: String) = Gson().fromJson(value, Array<AbilityEntity>::class.java).toList()

    @TypeConverter
    fun moveEntityListToJson(value: List<MoveEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToMoveEntityList(value: String) = Gson().fromJson(value, Array<MoveEntity>::class.java).toList()

    @TypeConverter
    fun specieEntityToJson(value: SpecieEntity) = Gson().toJson(value)

    @TypeConverter
    fun jsonToSpecieEntity(value: String) = Gson().fromJson(value, SpecieEntity::class.java)

    @TypeConverter
    fun spritesEntityToJson(value: SpritesEntity) = Gson().toJson(value)

    @TypeConverter
    fun jsonToSpritesEntity(value: String) = Gson().fromJson(value, SpritesEntity::class.java)

    @TypeConverter
    fun statEntityListToJson(value: List<StatEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToStatEntityList(value: String) = Gson().fromJson(value, Array<StatEntity>::class.java).toList()

    @TypeConverter
    fun typeEntityListToJson(value: List<TypeEntity>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToTypeEntityList(value: String) = Gson().fromJson(value, Array<TypeEntity>::class.java).toList()
}