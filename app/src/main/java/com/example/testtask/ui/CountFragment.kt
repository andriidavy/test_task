package com.example.testtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testtask.databinding.FragmentCountBinding
import com.example.testtask.viewmodel.CountViewModel

class CountFragment : Fragment() {
    private lateinit var binding: FragmentCountBinding

    private val viewModel: CountViewModel by lazy {
        ViewModelProvider(requireActivity())[CountViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        // increase counter value
        btCount.setOnClickListener {
            viewModel.addCount()
        }

        // set current counter value to view
        viewModel.count.observe(viewLifecycleOwner) { result ->
            tvClickCount.text = result.toString()
        }

        setToolbarBackButton()
    }

    private fun setToolbarBackButton() = with(binding) {
        // set toolbar as action bar
        (activity as AppCompatActivity).setSupportActionBar(fragmentToolbar)

        // show button "back" in toolbar
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // set listener for button "back"
        fragmentToolbar.setNavigationOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }
}