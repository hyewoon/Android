package com.example.recyclerview.dataBinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.databinding.FragmentDataBinding

//프래그먼트는 inflate통해서 xml 파일과 연결시켜줘야 한다 .

class DataFragment : Fragment() {

    private lateinit var binding :FragmentDataBinding
    private lateinit var manager : RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // 여기에서 xml 및 데이터 바인딩 연결 , 기본 데이터바인딩 연결
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_data, container,false)
        manager = LinearLayoutManager(this.context)

        //데이터 넣기
        val data : List<UserData> = listOf(
            UserData("Kim", 27,  "java"),
            UserData("mike", 20,"kotlin"),
            UserData("henry",  40,"android"),
            UserData("john",  19,"ios"),
            UserData("jennie", 22,"datascience"),
            UserData("sunny",  29,"nodejs"),
            UserData("kate",  34,"java")
        )

        binding.fragRecycler.adapter = FragmentAdapter(data)
        binding.fragRecycler.layoutManager = manager

        return binding.root
    }








}