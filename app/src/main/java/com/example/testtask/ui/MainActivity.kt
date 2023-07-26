package com.example.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentTransaction
import com.example.testtask.R
import com.example.testtask.databinding.ActivityMainBinding
import com.example.testtask.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btOpenFragment.setOnClickListener {
            openFragment()
        }

        viewModel.counter.observe(this) { result ->
            binding.tvCountResult.text = result.toString()
        }
    }

    private fun openFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, CounterFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}