package ru.effectiv.domain.repostory

import android.util.Log
import ru.effectiv.domain.model.person.PersonEntity
import ru.effectiv.domain.repostory.dao.PersonDao

class PersonRepository(private val personDao: PersonDao) {
    suspend fun getAllPersons(): List<PersonEntity> {
        return personDao.getAll()
    }

    suspend fun insertPerson(person: PersonEntity) = personDao.insert(person)

    suspend fun getPersonByEmail(person: String) = personDao.getPersonByEmail(person)

}
