package com.example.test_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.data.TodoData
import com.example.test_app.databinding.TodoItemBinding

class Test3Adapter(private val items: ArrayList<TodoData>) : RecyclerView.Adapter<Test3Adapter.MyViewHolder>() {


    inner class MyViewHolder(val binding : TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(item : TodoData){
            binding.todo = item
        }

    }
    //리스트의 각 항목을 이루는 디자인(todo_item.xml) 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Test3Adapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = TodoItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    //리스트의 각 항목에 들어갈 데이터를 지정
    override fun onBindViewHolder(holder: Test3Adapter.MyViewHolder, position: Int) {
      holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return  items.size
    }
}