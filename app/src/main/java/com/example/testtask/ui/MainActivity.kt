package com.example.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.testtask.R
import com.example.testtask.databinding.ActivityMainBinding
import com.example.testtask.viewmodel.CountViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<CountViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btToFragment.setOnClickListener {
            showFragment()
        }

        viewModel.count.observe(this) { result ->
            binding.tvCountResult.text = result.toString()
        }
    }

    private fun showFragment(){
        val fragment = CountFragment()
        val fragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment) // замените R.id.fragmentContainer на id вашего контейнера
        transaction.addToBackStack(null)
        transaction.commit()
    }
}