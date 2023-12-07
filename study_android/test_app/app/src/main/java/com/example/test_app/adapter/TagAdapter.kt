package com.example.test_app.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_app.data.TagData
import com.example.test_app.databinding.TagItemBinding

/*
*  Recyclerview는 listview나 gridview처럼

직접 뷰에 setOnItemClickListenr나 setOnLongItemClickListener를 붙여줄 수가 없었다.



결론만 정리하면

Adapter 코드의 ViewHolder에서 itemView에 onClickListener를 달아야 한다. (Long일경우 LongClickListnenr)
*
*
* --> 클릭이벤트시 프래그먼트 이동하는 로직 만들려면 Activity에서 클릭이벤트 가져와 해결해야 하다
* --> interface로 구현한 다음 activity에서 가져와 쓴다
* */

class TagAdapter(private val itemList : List<TagData>) : RecyclerView.Adapter<TagAdapter.MyViewHolder>() {

    //클릭이벤트 추가 부분
    interface ItemClick{
        fun onClick(view : View, position : Int){
        }
    }

    var itemClick : ItemClick? = null //클릭이벤트 추가 부분

    inner class MyViewHolder(var binding : TagItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : TagData){
            binding.tag = item
        }

        /*init {
            binding = this.binding
            binding.tagContainer.setOnClickListener {
                val position  = adapterPosition
                Log.d("click", "$position:click")
            }
        }*/
    }


/*
* onCreateViewHolder
* xml 파일을 inflate 하여 viewHolder를 만든다
* */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = TagItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }

    /*
    * onBindViewHolder
        : bind함수를 통해 위의 onCreateViewHolder에서 만든 View와 실제 입력되는 각각의 데이터를 연결한다.
    * */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])

        holder.itemView.setOnClickListener { //클릭이벤트 추가
            itemClick?.onClick(it, position)
            }
        }
    }
