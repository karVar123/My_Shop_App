package ru.effectiv.domain.usecase

import ru.effectiv.domain.model.person.Person
import ru.effectiv.domain.repostory.PersonRepository

class GetAllPersonsUseCase (private val personRepository: PersonRepository) {
    suspend operator fun invoke(): List<Person> {
        val personEntities = personRepository.getAllPersons()
        return personEntities.map { entity ->
            Person(entity.id, entity.firstName, entity.lastName, entity.email)
        }
    }
}
