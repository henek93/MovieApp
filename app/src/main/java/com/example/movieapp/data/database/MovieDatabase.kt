package com.example.movieapp.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MovieDbModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MovieDatabase: RoomDatabase(){

    companion object{

        private val LOCK = Any()
        private val DB_NAME = "movies.db"
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(application: Application): MovieDatabase{
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK){
                INSTANCE?.let {
                    return it
                }

                val db = Room.databaseBuilder(
                    application,
                    MovieDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }

    abstract fun movieDao(): MovieDao
}