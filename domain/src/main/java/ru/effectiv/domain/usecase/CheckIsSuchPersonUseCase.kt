package ru.effectiv.domain.usecase

import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import ru.effectiv.domain.repostory.PersonRepository

class CheckIsSuchPersonUseCase(val personRepository: PersonRepository) {
    suspend fun execute(person: String): Boolean {
        return withContext(coroutineContext) {
            async {
                val existingPerson = personRepository.getPersonByEmail(person)
                return@async existingPerson == null
            }
        }.await()
    }
}