package ru.effectiv.mobile.ui.pages.sign_in

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effectiv.domain.model.person.Person
import ru.effectiv.mobile.R
import ru.effectiv.mobile.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private val signInViewModel: SignInViewModel by viewModel()
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding.btnSignIn.setOnClickListener {
            if (checkFieldsState()) {
                lifecycleScope.launch {
                    signInViewModel.userRegistration(createPerson())
                    if (signInViewModel.userRegistration(createPerson())) {
                        postToastMessage("You have successfully registered")
                        findNavController().navigate(R.id.nav_page_1)
                    }
                }
            }
        }
        binding.btnLogIn.setOnClickListener {
            findNavController().navigate(R.id.nav_log_in)

        }

        return binding.root
    }

    private fun checkFieldsState(): Boolean {
        with(binding) {
            return if (signInFirstName.text.isEmpty()) {
                postToastMessage("The First Name field cannot be empty")
                false
            } else if (etSignInLastName.text.isEmpty()) {
                postToastMessage("The Last name field cannot be empty")
                false
            } else if (etSignInEmail.text.isEmpty()) {
                postToastMessage("The Last name field cannot be empty")
                false
            } else {
                true
            }
        }
    }

    private fun postToastMessage(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun createPerson(): Person {
        with(binding) {
            return Person(
                id = 0,
                firstName = signInFirstName.text.toString(),
                lastName = etSignInLastName.text.toString(),
                email = etSignInEmail.text.toString()
            )

        }
    }


}