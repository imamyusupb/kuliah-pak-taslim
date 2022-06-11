package com.lp3i.simplenote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1, exportSchema = false,
    entities = [Makanan::class, FamilyMember::class]
)
abstract class FoodNoteDB : RoomDatabase() {

    abstract fun makananDao(): MakananDao

    companion object {
        @Volatile
        private var INSTANCE: FoodNoteDB? = null

        fun getDatabase(context: Context): FoodNoteDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodNoteDB::class.java, "food_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}