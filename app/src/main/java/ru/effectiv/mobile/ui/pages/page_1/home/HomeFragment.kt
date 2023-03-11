package ru.effectiv.mobile.ui.pages.page_1.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effectiv.mobile.R
import ru.effectiv.mobile.databinding.FragmentHomeBinding
import ru.effectiv.mobile.ui.adapter.FlashSaleAdapter
import ru.effectiv.mobile.ui.adapter.LatestAdapter
import ru.effectiv.mobile.ui.adapter.SuggestionsAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var suggestionsAdapter: SuggestionsAdapter

    private lateinit var binding: FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        initRecyclerView()
        initHintRecyclerView()
    }

    private var backPressedTime: Long = 0
    private val DOUBLE_BACK_PRESS_THRESHOLD: Long = 2000

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val activity = context as AppCompatActivity
        activity.onBackPressedDispatcher.addCallback(this) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - backPressedTime < DOUBLE_BACK_PRESS_THRESHOLD) {
                activity.finish()
            } else {
                backPressedTime = currentTime
                Toast.makeText(context, "Press back again to exit", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun initRecyclerView() = with(binding) {

        homeViewModel.latest.observe(viewLifecycleOwner) { latest ->
            latestRecyclerView.apply {
                adapter = activity?.supportFragmentManager?.let { fragmentManager ->
                    LatestAdapter(
                        latest, fragmentManager
                    )
                }
                Log.e("HOME", "onCreateView: check size :: ${latest.size}")

                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
            brandsRecyclerView.apply {
                adapter = activity?.supportFragmentManager?.let { fragmentManager ->
                    LatestAdapter(
                        latest, fragmentManager
                    )
                }
                Log.e("HOME", "onCreateView: check size :: ${latest.size}")

                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }
        }
        flashSaleRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        homeViewModel.flashSale.observe(viewLifecycleOwner) { latest ->
            flashSaleRecyclerView.adapter = activity?.supportFragmentManager?.let { _ ->
                FlashSaleAdapter(latest)
            }
            Log.e("HOME", "onCreateView: check size :: ${latest.size}")
        }
    }

    private fun initHintRecyclerView() {
        with(binding) {
            suggestionsAdapter = SuggestionsAdapter(emptyList(), homeSearch)
            suggestionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            suggestionRecyclerView.adapter = suggestionsAdapter

            homeSearch.doOnTextChanged { text, _, _, _ ->
                if (text?.isEmpty() == true) {
                    suggestionRecyclerView.visibility = View.GONE
                } else {
                    lifecycleScope.launch {
                        val filteredList = homeViewModel.filterSuggestion(text.toString())
                        delay(1000)
                        suggestionRecyclerView.visibility = View.VISIBLE
                        suggestionsAdapter.setFilteredList(filteredList)
                    }
                }
            }
        }
    }
}