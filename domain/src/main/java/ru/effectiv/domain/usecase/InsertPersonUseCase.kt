package ru.effectiv.domain.usecase

import android.util.Log
import ru.effectiv.domain.model.person.Person
import ru.effectiv.domain.model.person.PersonEntity
import ru.effectiv.domain.repostory.PersonRepository

class InsertPersonUseCase(private val personRepository: PersonRepository) {
    suspend operator fun invoke(person: Person) {
        val entity = PersonEntity(person.id, person.firstName, person.lastName, person.email)
        Log.e("person", "invoke: saved ::${entity.email}")
        personRepository.insertPerson(entity)
    }
}
