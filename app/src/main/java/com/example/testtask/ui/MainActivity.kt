package com.example.testtask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.testtask.R
import com.example.testtask.databinding.ActivityMainBinding
import com.example.testtask.viewmodel.CountViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: CountViewModel by lazy {
        ViewModelProvider(this)[CountViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // open fragment and reset counter
        binding.btToFragment.setOnClickListener {
            viewModel.resetCounter()
            showFragment()
        }

        // set current counter value to view
        viewModel.count.observe(this) { result ->
            binding.tvCountResult.text = result.toString()
        }
    }

    private fun showFragment() {
        //creating FragmentTransaction instance for begin transaction
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        //replacing the content of the fragment container with an instance of CountFragment()
        transaction.replace(R.id.fragmentContainer, CountFragment())

        //adding a transaction to the fragment return stack (for "back" button)
        transaction.addToBackStack(null)

        //applying a transaction to display the fragment on the screen.
        transaction.commit()
    }
}