package com.example.ejemploadapterconlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemploadapterconlista.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter = StringAdapter()

    private val stringList = mutableListOf("Elemento 1","Elemento 2","Elemento 3","Elemento 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()
        adapter.updateData(stringList)

        binding.bAddMore.setOnClickListener {
            stringList.add("Elemento Random ${Random.nextInt()}")
            adapter.updateData(stringList)
        }
    }

    private fun createRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

}