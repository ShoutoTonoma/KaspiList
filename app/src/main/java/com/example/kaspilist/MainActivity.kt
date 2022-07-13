package com.example.kaspilist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kaspilist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = NotebookAdapter()
    private val imageIdList = listOf(
        R.drawable.notebook1,
        R.drawable.notebook2,
        R.drawable.notebook3,
        R.drawable.notebook4,
        R.drawable.notebook5,
    )
    private val titleList = listOf(
        "Lenovo V14-ADA 82C6S03900 серый",
        "Acer Nitro 5 AN515-55-50ZA NH...",
        "Apple MacBook Air 13 MGN63 серый",
        "HP 15s-fq3045u 5A9G6EA серый   ",
        "Lenovo IdeaPad Gaming 3 15....."
    )
    private val priceList = listOf(
        "154 390 ₸",
        "388 800 ₸",
        "569 800 ₸",
        "218 000 ₸",
        "429 990 ₸"
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            btnAddNotebook.setOnClickListener {
                if (index > 4) index = 0
                val notebook = Notebook(imageIdList[index], titleList[index], priceList[index])
                adapter.addNotebook(notebook)
                index++
            }
        }
    }
}