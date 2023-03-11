package ru.effectiv.domain.repostory.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.effectiv.domain.model.person.Person
import ru.effectiv.domain.model.person.PersonEntity

@Dao
interface PersonDao {
    @Insert
    suspend fun insert(person: PersonEntity)

    @Query("SELECT * FROM persons")
    suspend fun getAll(): List<PersonEntity>


    @Query("SELECT * FROM persons WHERE email = :email")
    suspend fun getPersonByEmail(email: String): PersonEntity?
}
