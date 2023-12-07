package com.example.recyclerview.dataBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.databinding.DataItemBinding
import com.example.recyclerview.databinding.TagItemBinding

class FragmentAdapter(private val dataSet : List<UserData>) : RecyclerView.Adapter<FragmentAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding : DataItemBinding) : RecyclerView.ViewHolder(binding.root){

        //데이터바인딩을 통해 연결한 값들 정의
        fun dataBind(item : UserData){
            item.also { binding.myData = it }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataItemBinding = DataItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(dataItemBinding)
    }

    override fun onBindViewHolder(holder: FragmentAdapter.MyViewHolder, position: Int) {
        holder.dataBind(dataSet[position])
    }

    override fun getItemCount(): Int {
      return dataSet.size
    }

}