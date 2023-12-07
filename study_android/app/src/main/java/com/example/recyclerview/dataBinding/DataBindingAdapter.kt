package com.example.recyclerview.dataBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview.R
import com.example.recyclerview.databinding.TextRowItemBinding

class DataBindingAdapter(private val dataSet : ArrayList<String>) : RecyclerView.Adapter<DataBindingAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding : TextRowItemBinding) : RecyclerView.ViewHolder(binding.root){

        val myText : TextView = binding.myText

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       // val view = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val view : TextRowItemBinding = DataBindingUtil.inflate<TextRowItemBinding>(LayoutInflater.from(parent.context),
            R.layout.text_row_item, parent, false)
        return MyViewHolder(view)


    }

    override fun onBindViewHolder(holder: DataBindingAdapter.MyViewHolder, position: Int) {
       holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}