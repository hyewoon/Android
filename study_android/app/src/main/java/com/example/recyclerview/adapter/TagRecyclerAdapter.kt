package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.data.TagData
import com.example.recyclerview.databinding.TagItemBinding


/*
* 아이템 클릭이벤트 설정하는 방법
* 1.onBindViewHolder 에 setOnclickListenr()
*
* */
class TagRecyclerAdapter(private val itemList: List<TagData>) : RecyclerView.Adapter<TagRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : TagItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : TagData){
            binding.tag = item
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagRecyclerAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = TagItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: TagRecyclerAdapter.MyViewHolder, position: Int) {
        holder.bind(itemList[position])

    }

    override fun getItemCount(): Int {
        return itemList.size

    }
}