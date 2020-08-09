package com.hussein.startup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import  kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.zoo.Animal
import com.example.zoo.AnimalInfo
import com.example.zoo.R
import com.example.zoo.adapters.AnimalsAdapter
import com.example.zoo.adapters.MainViews


class MainActivity : AppCompatActivity() {

    private var listOfAnimals = ArrayList<Animal>()
    var adapter: AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadAnimals()


        adapter = AnimalsAdapter(this, listOfAnimals)
        tvListAnimal.adapter = adapter
        tvListAnimal.setOnClickListener {
            showMessage(it)
        }

    }

    private fun loadAnimals() {
        listOfAnimals.add(
            Animal("Baboon", "Baboon live in  big place with tree", R.drawable.baboon, false)
        )
        listOfAnimals.add(
            Animal("Bulldog", "Bulldog live in  big place with tree", R.drawable.bulldog, false)
        )
        listOfAnimals.add(
            Animal("Panda", "Panda live in  big place with tree", R.drawable.panda, true)
        )
        listOfAnimals.add(
            Animal(
                "Swallow",
                "Swallow live in  big place with tree",
                R.drawable.swallow_bird,
                false
            )
        )
        listOfAnimals.add(
            Animal("Tiger", "Tiger live in  big place with tree", R.drawable.white_tiger, true)
        )
        listOfAnimals.add(
            Animal("Zebra", "Zebra live in  big place with tree", R.drawable.zebra, false)
        )
    }

    fun delete(index: Int) {
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun add(index: Int) {
        listOfAnimals.add(index, listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }
}