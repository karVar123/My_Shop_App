package ru.effectiv.mobile.ui.pages.log_in

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effectiv.mobile.R
import ru.effectiv.mobile.databinding.FragmentLogInBinding
import java.util.regex.Matcher
import java.util.regex.Pattern

class LogInFragment : Fragment() {
    private val logInViewModel: LogInViewModel by viewModel()
    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLogInBinding.inflate(layoutInflater)

        with(binding) {
            btnLogIn.setOnClickListener {
                lifecycleScope.launch {
                    val response = logInViewModel.checkIsExistAccount(email = signInFirstName.text.toString())
                    delay(1000)
                    if (response) {
                        postToastMessage("Log in successful")
                        findNavController().navigate(R.id.action_nav_log_in_to_nav_page_1)
                    } else {
                        postToastMessage("No such account found")
                    }
                }
            }
        }
        return binding.root
    }

    private fun postToastMessage(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }


}