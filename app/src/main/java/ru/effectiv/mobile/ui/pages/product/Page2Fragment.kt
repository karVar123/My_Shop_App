package ru.effectiv.mobile.ui.pages.product

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effectiv.mobile.R
import ru.effectiv.mobile.databinding.FragmentPage2Binding
import ru.effectiv.mobile.ui.adapter.ImagePagerAdapter
import kotlin.math.floor


class Page2Fragment : Fragment() {
    private val page2ViewModel: Page2ViewModel by viewModel()
    private lateinit var binding: FragmentPage2Binding
    private lateinit var imagePagerAdapter: ImagePagerAdapter


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPage2Binding.inflate(inflater)

        with(binding) {
            btnGoBack.setOnClickListener {
                findNavController().navigate(R.id.action_nav_page_2_to_nav_home)
            }
            page2ViewModel.product.observe(viewLifecycleOwner) {
                initImageRecyclerView(it.image_urls)
                productName.text = it.name
                productPrice.text = "$ ${it.price}"
                productDescription.text = it.description
                productRating.text = it.rating.toString()
                productReviewsQuantity.text = "(${it.number_of_reviews}) reviews"
                color1.setBackgroundColor(Color.parseColor(it.colors[0]))
                color2.setBackgroundColor(Color.parseColor(it.colors[1]))
                color3.setBackgroundColor(Color.parseColor(it.colors[2]))
            }

        }

        return binding.root
    }


    private fun initImageRecyclerView(list: List<String>) {
        with(binding) {
            imagePagerAdapter = ImagePagerAdapter(
                images = list as ArrayList<String>,
                mainImageView = productMainImage,
                selectedItemPosition = floor(list.size.toDouble() / 2).toInt()
            )
            imagesRecyclerView.apply {
                adapter = imagePagerAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = context as AppCompatActivity
        activity.onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_nav_page_2_to_nav_home)
        }
    }
}