package ru.effectiv.mobile.ui.pages.page_1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import androidx.navigation.Navigation
import ru.effectiv.mobile.R
import ru.effectiv.mobile.databinding.FragmentPage1Binding


class Page1Fragment : Fragment() {
    private val page1NavController by lazy {
        Navigation.findNavController(requireView().findViewById(R.id.nav_host_page_1))
    }

    private val TAG = "Page1"
    var selectedBottomItem = 0
    private var binding: FragmentPage1Binding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPage1Binding.inflate(layoutInflater)
        buttonsClick()



        return binding?.root
    }

    fun navigateTo(id: Int) {
        page1NavController.navigate(id)
    }

    private fun buttonsClick() {
        with(binding?.bottomNavigation) {
            this?.homeLayout?.setOnClickListener {
                if (selectedBottomItem == 0) {
                    Toast.makeText(context, "You are already here", Toast.LENGTH_SHORT).show()
                } else {
                    selectedBottomItem = 0
                    logicBottomNavigation()
                }
                Log.e(TAG, "buttonsClick: clicked Home")
            }
            this?.favoriteLayout?.setOnClickListener {
                if (selectedBottomItem == 1) {
                    Toast.makeText(context, "You are already here", Toast.LENGTH_SHORT).show()
                } else {
                    selectedBottomItem = 1
                    logicBottomNavigation()

                }
                Log.e(TAG, "buttonsClick: clicked favorite")
            }
            this?.cartLayout?.setOnClickListener {
                if (selectedBottomItem == 2) {
                    Toast.makeText(context, "You are already here", Toast.LENGTH_SHORT).show()
                } else {
                    selectedBottomItem = 2
                    logicBottomNavigation()
                    Log.e(TAG, "buttonsClick: clicked cart")

                }
            }
            this?.messageLayout?.setOnClickListener {
                if (selectedBottomItem == 3) {
                    Toast.makeText(context, "You are already here", Toast.LENGTH_SHORT).show()
                } else {
                    selectedBottomItem = 3
                    logicBottomNavigation()

                    Log.e(TAG, "buttonsClick: clicked message")
                }
            }
            this?.profileLayout?.setOnClickListener {
                if (selectedBottomItem == 4) {
                    Toast.makeText(context, "You are already here", Toast.LENGTH_SHORT).show()
                } else {
                    selectedBottomItem = 4
                    logicBottomNavigation()

                    Log.e(TAG, "buttonsClick: clicked profile")
                }
            }
        }
    }

    private fun logicBottomNavigation() {
        when (selectedBottomItem) {
            0 -> {
                /*HOME*/
                setBackgroundByBoolean(
                    isHome = true,
                    isFavorite = false,
                    isCart = false,
                    isMessage = false,
                    isProfile = false
                )
            }
            1 -> {
                /*FAVORITE*/

                setBackgroundByBoolean(
                    isHome = false,
                    isFavorite = true,
                    isCart = false,
                    isMessage = false,
                    isProfile = false
                )
            }
            2 -> {
                /*CART*/

                setBackgroundByBoolean(
                    isHome = false,
                    isFavorite = false,
                    isCart = true,
                    isMessage = false,
                    isProfile = false
                )
            }
            3 -> {
                /*MESSAGE*/

                setBackgroundByBoolean(
                    isHome = false,
                    isFavorite = false,
                    isCart = false,
                    isMessage = true,
                    isProfile = false
                )
            }
            4 -> {
                /*PROFILE*/

                setBackgroundByBoolean(
                    isHome = false,
                    isFavorite = false,
                    isCart = false,
                    isMessage = false,
                    isProfile = true
                )
            }
        }
    }

    private fun setBackgroundByBoolean(
        isHome: Boolean,
        isFavorite: Boolean,
        isCart: Boolean,
        isMessage: Boolean,
        isProfile: Boolean,
    ) {
        val animation =
            ScaleAnimation(
                0.8f,
                1f,
                1f,
                1f,
                Animation.RELATIVE_TO_SELF,
                0.0f,
                Animation.RELATIVE_TO_SELF,
                0.0f
            )
        animation.duration = 200
        animation.fillAfter = true

        with(binding?.bottomNavigation) {
            if (isHome) {
                this?.homeLayout?.setBackgroundResource(R.drawable.bottom_navigation_selected_bg)
                this?.homeLayout?.startAnimation(animation)
                this?.favoriteLayout?.setBackgroundColor(Color.WHITE)
                this?.cartLayout?.setBackgroundColor(Color.WHITE)
                this?.messageLayout?.setBackgroundColor(Color.WHITE)
                this?.profileLayout?.setBackgroundColor(Color.WHITE)
                navigateTo(R.id.nav_home)

            } else if (isFavorite) {
                this?.favoriteLayout?.setBackgroundResource(R.drawable.bottom_navigation_selected_bg)
                this?.favoriteLayout?.startAnimation(animation)
                this?.homeLayout?.setBackgroundColor(Color.WHITE)
                this?.cartLayout?.setBackgroundColor(Color.WHITE)
                this?.messageLayout?.setBackgroundColor(Color.WHITE)
                this?.profileLayout?.setBackgroundColor(Color.WHITE)
                navigateTo(R.id.nav_favorite)

            } else if (isCart) {

                this?.cartLayout?.setBackgroundResource(R.drawable.bottom_navigation_selected_bg)
                this?.cartLayout?.startAnimation(animation)
                this?.favoriteLayout?.setBackgroundColor(Color.WHITE)
                this?.homeLayout?.setBackgroundColor(Color.WHITE)
                this?.messageLayout?.setBackgroundColor(Color.WHITE)
                this?.profileLayout?.setBackgroundColor(Color.WHITE)
                navigateTo(R.id.nav_cart)

            } else if (isMessage) {
                this?.messageLayout?.setBackgroundResource(R.drawable.bottom_navigation_selected_bg)
                this?.messageLayout?.startAnimation(animation)
                this?.favoriteLayout?.setBackgroundColor(Color.WHITE)
                this?.cartLayout?.setBackgroundColor(Color.WHITE)
                this?.homeLayout?.setBackgroundColor(Color.WHITE)
                this?.profileLayout?.setBackgroundColor(Color.WHITE)
                navigateTo(R.id.nav_message)

            } else if (isProfile) {
                this?.profileLayout?.setBackgroundResource(R.drawable.bottom_navigation_selected_bg)
                this?.profileLayout?.startAnimation(animation)
                this?.favoriteLayout?.setBackgroundColor(Color.WHITE)
                this?.cartLayout?.setBackgroundColor(Color.WHITE)
                this?.messageLayout?.setBackgroundColor(Color.WHITE)
                this?.homeLayout?.setBackgroundColor(Color.WHITE)
                navigateTo(R.id.nav_profile)
            } else {

            }
        }
    }


}