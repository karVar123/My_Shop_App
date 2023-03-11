package ru.effectiv.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.effectiv.domain.model.person.PersonEntity
import ru.effectiv.domain.repostory.dao.PersonDao

@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        @Volatile
        private var instance: PersonDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context): PersonDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PersonDatabase::class.java,
                "person_database"
            ).build()
        }
    }
}
