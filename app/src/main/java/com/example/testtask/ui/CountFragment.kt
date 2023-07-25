package com.example.testtask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.testtask.databinding.FragmentCountBinding
import com.example.testtask.viewmodel.CountViewModel

class CountFragment : Fragment() {
    private lateinit var binding: FragmentCountBinding

    private val viewModel by viewModels<CountViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        btCount.setOnClickListener {
            viewModel.addCount()
        }

        viewModel.count.observe(viewLifecycleOwner) { result ->
            tvClickCount.text = result.toString()
        }

        setToolbarBackButton()
    }

    private fun setToolbarBackButton() = with(binding) {
        // Установка тулбара в качестве action bar
        (activity as AppCompatActivity).setSupportActionBar(fragmentToolbar)

        // Показать кнопку "назад" (стрелку) в тулбаре
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Установить обработчик для кнопки "назад" (стрелки)
        fragmentToolbar.setNavigationOnClickListener {
            // Вернуться на предыдущий фрагмент или активити при нажатии кнопки "назад"
            activity?.onBackPressed()
        }
    }
}