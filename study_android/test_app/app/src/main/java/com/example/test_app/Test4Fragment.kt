package com.example.test_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_app.adapter.GiftAdapter
import com.example.test_app.data.GiftData
import com.example.test_app.databinding.FragmentTest4Binding
import com.example.test_app.viewModel.Test4ViewModel
import java.lang.Exception

class Test4Fragment : Fragment() {
   private lateinit var binding : FragmentTest4Binding
    private val viewModel by viewModels<Test4ViewModel>() //viewModel 초기화

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test4, container, false)

        /*
        * 첫번째 방법
        * 기존 adapter에 직접 접근하여 add 하는 방법
        *
        *  var adapter = GiftAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this.context)

        adapter.giftList = arrayListOf(
            GiftData("안녕하세요", 123.4),
            GiftData("안녕하세요", 123.4),
            GiftData("안녕하세요", 123.4),
            GiftData("안녕하세요", 123.4))

          binding.itemButton.setOnClickListener {
            adapter.giftList.add(GiftData("크리스마스", 234.3))

           }
           * ---> 하지만 데이터가 변화를 감지하지 못함
           * ----> 라이브데이터 이용

        * */

        //두 번째 방법  : 데이터 저장과 recyler에서 보여주는 로직을 분리함
        val giftData : ArrayList<GiftData> = arrayListOf()
       //viewModel.itemList = arrayListOf()

        val adapter = GiftAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this.context)

          /*  binding.itemButton.setOnClickListener {
                val itemName : String = binding.itemName.text.toString()
                val itemPrice : Double = binding.itemPrice.text.toString().toDouble()
                //데이터 넣기
                giftData.add(GiftData(itemName, itemPrice))
                Log.d("item", giftData[0].itemName.toString())
                //recyclerview로 보여주기
                adapter.notifyItemInserted(giftData.size-1)
            }*/

        binding.itemButton.setOnClickListener {
            val itemName : String = binding.itemName.text.toString()
            val itemPrice : Double = binding.itemPrice.text.toString().toDouble()

            val item = GiftData(itemName, itemPrice)

            viewModel.btnClicked(item)

            viewModel.itemList.observe(this, Observer {
               adapter.set(it)
            })

        }

        /* viewModel.btnClicked(itemName, itemPrice)
         Log.d("item",viewModel.itemList[0].itemName.toString() + viewModel.itemList[0].itemPrice.toString())
         adapter.notifyItemInserted(viewModel.itemList.size-1)*/






        return binding.root
    }

}