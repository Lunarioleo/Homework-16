package com.example.plantshandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plantshandbook.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: MyViewModel =ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.getData()
        var adapter: RecyclerViewAdapter
        viewModel.Uistate.observe(this){
            when (it){
                is MyViewModel.UiState.Result ->{
                    adapter = RecyclerViewAdapter(it.character)
                    binding.rcView.adapter = adapter
                }
            }
        }
       binding.rcView.layoutManager = GridLayoutManager(this, 4)
    }
}


typealias CharacterResponse= ArrayList<Character>
data class Character(
    val name: String,
    val images: Images,
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String,
)


