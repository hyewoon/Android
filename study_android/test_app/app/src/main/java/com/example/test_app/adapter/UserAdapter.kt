package com.example.test_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.data.User
import com.example.test_app.databinding.UserItemBinding

class UserAdapter(private val userList : List<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    //클릭 이벤트 만들기
    interface ItemClick{
        fun onClick(view : View, position : Int){
        }
    }
    var itemClick : TagAdapter.ItemClick? = null //클릭이벤트 추가 부분

    inner class MyViewHolder(var binding : UserItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : User){
            binding.user = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context,)
        val listItemBinding = UserItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(userList[position])

        holder.itemView.setOnClickListener { //클릭이벤트 추가
            itemClick?.onClick(it, position)
        }

    }
}