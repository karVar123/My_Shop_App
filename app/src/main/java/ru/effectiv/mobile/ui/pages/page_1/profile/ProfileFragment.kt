package ru.effectiv.mobile.ui.pages.page_1.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effectiv.mobile.R
import ru.effectiv.mobile.databinding.FragmentProfileBinding
import ru.effectiv.mobile.ui.pages.page_1.Page1Fragment

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val GALLERIA_USER_REQ_CODE = 1000
    private val profileViewModel: ProfileViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        with(binding) {
            changeProfilePhoto.setOnClickListener {
                openGallery()
            }
            tvLogOut.setOnClickListener {
                lifecycleScope.launch {
                    if (profileViewModel.logOut()) Page1Fragment().navigateTo(R.id.action_nav_page_1_to_nav_sign_in)
                }
            }
        }
        return binding.root
    }

    private fun openGallery() {
        val iGallery = Intent(Intent.ACTION_PICK)
        iGallery.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(iGallery, GALLERIA_USER_REQ_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == GALLERIA_USER_REQ_CODE) {
                binding.profilePhoto.setImageURI(data?.data)

            }
        }
    }

}