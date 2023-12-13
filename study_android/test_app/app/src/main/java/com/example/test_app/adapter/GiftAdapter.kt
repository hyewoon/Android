package com.example.test_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.data.GiftData
import com.example.test_app.databinding.FragmentTest4Binding
import com.example.test_app.databinding.GiftItemBinding

class GiftAdapter( ): RecyclerView.Adapter<GiftAdapter.MyViewHolder>() {

     var giftList = ArrayList<GiftData>()

    //setData 함수 추가
    // 이함수에 LiveData를 recyclerAdapter로 가져온후 기존데이터를 새로운데이터로 바꿔주도록 기능을만듭니다.
    // 그리고 위에 관찰 UI에서 실행하도록 합니다.
    fun set(newData : ArrayList<GiftData>){
        giftList = newData
        notifyDataSetChanged()
    }


    inner class MyViewHolder(var binding: GiftItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(items : GiftData){
            binding.item = items
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itembinding = GiftItemBinding.inflate(inflater,parent, false )
        return MyViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: GiftAdapter.MyViewHolder, position: Int) {
        holder.bind(giftList[position])
    }

    override fun getItemCount(): Int {
        return  giftList.size
    }
}