package com.example.zoo.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.zoo.Animal
import com.example.zoo.AnimalInfo
import com.example.zoo.R
import kotlinx.android.synthetic.main.animal_ticket.view.*

class AnimalsAdapter(context: Context, var listOfAnimals: ArrayList<Animal>) : BaseAdapter() {
    var context: Context? = context
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val animal = listOfAnimals[p0]
        if (animal.isKiller) {
            val inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val myView = inflator.inflate(R.layout.animal_killer_ticket, null)
            myView.tvDes.text = animal.name
            myView.tvName.text = animal.des
            myView.ivAnimalImage.setImageResource(animal.image)
            myView.ivAnimalImage.setOnClickListener {

                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("des", animal.des)
                intent.putExtra("image", animal.image)
                context!!.startActivity(intent)


            }
            return myView

        } else {
            val inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val myView = inflator.inflate(R.layout.animal_ticket, null)
            myView.tvDes.text = animal.name
            myView.tvDes.text = animal.des
            myView.ivAnimalImage.setImageResource(animal.image)
            myView.ivAnimalImage.setOnClickListener {
                showMessage(p0)

                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("des", animal.des)
                intent.putExtra("image", animal.image)
                context!!.startActivity(intent)


            }
            return myView
        }
    }

    override fun getItem(p0: Int): Any {
        return listOfAnimals[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {

        return listOfAnimals.size
    }

    fun showMessage(message: Int): Int {
        return message
    }

}

    interface MainViews {
    fun showMessage(message: Int?)
}

