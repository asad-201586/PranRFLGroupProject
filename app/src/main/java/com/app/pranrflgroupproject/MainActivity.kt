package com.app.pranrflgroupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.app.pranrflgroupproject.databinding.ActivityMainBinding
import com.app.pranrflgroupproject.network.Resource
import com.app.pranrflgroupproject.view_model.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val TAG: String = "main_db"
    private val viewModel: HomeViewModel by viewModel()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getHomeData().observe(this) { resource ->
            when(resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d(TAG, "onCreate: data is loading")
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, resource.errorMessage, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "onCreate: error: ${resource.errorMessage}")
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.textData.text = resource.data.message
                    Log.d(TAG, "onCreate: success")
                }
            }
        }

    }
}