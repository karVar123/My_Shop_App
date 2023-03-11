package ru.effectiv.data.repository_impl

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import ru.effectiv.domain.repostory.SharedPerfRepository

class SharedPerfRepositoryImpl(private val context: Context) : SharedPerfRepository {
    private val MY_SHARED_PREF = "CURRENT_USER"
    private val CURRENT_USER_EMAIL = "CURRENT_USER_EMAIL"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    override suspend fun saveCurrentUserEmail(currentUserEmail: String) {
        sharedPreferences.edit().putString(CURRENT_USER_EMAIL, CURRENT_USER_EMAIL)
    }

    override suspend fun deleteCurrentUserEmail() {
        sharedPreferences.edit().clear().apply()
    }
}