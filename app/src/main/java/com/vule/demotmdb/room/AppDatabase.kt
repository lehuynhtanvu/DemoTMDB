package com.vule.demotmdb.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vule.demotmdb.models.Movie
import com.vule.demotmdb.room.converters.*

@Database(entities = [(Movie::class)],
    version = 1, exportSchema = false)
@TypeConverters(value = [(StringListConverter::class), (IntegerListConverter::class),
    (KeywordListConverter::class), (VideoListConverter::class), (ReviewListConverter::class)])
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
