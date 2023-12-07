package com.example.recyclerview.ViewBinding

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview.R
import com.example.recyclerview.databinding.TextRowItemBinding


class CustomAdapter (private val dataSet : ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

    inner class MyViewHolder(binding : TextRowItemBinding) : RecyclerView.ViewHolder(binding.root){

        val myText : TextView = binding.myText
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{

       // val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        val view = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
      holder.myText.text = dataSet[position]


    }

    override fun getItemCount(): Int {
       return dataSet.size
    }
}
