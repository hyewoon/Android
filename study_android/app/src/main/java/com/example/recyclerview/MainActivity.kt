package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.TagRecyclerAdapter
import com.example.recyclerview.data.TagData
import com.example.recyclerview.dataBinding.DataFragment
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var manager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //기본 데이터 바인딩 로직
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //리사이클러뷰dp 데이터바인딩 연결
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager =GridLayoutManager(this, 3)

        var data = listOf<TagData>(
            TagData(getDrawable(R.drawable.icon_chair)!!,"의자가 편해요"),
            TagData(getDrawable(R.drawable.icon_bakery)!!,"디저트가 맛있어요"),
            TagData(getDrawable(R.drawable.icon_light)!!,"눈이 편해요"),
            TagData(getDrawable(R.drawable.icon_menu)!!,"메뉴가 다양해요 "),
            TagData(getDrawable(R.drawable.icon_table)!!,"테이블이 편해요"),
            TagData(getDrawable(R.drawable.icon_time)!!,"아침일찍 오픈해요"),

        )

        //리사이클러뷰 연결
        binding.recyclerView.apply {
            adapter = TagRecyclerAdapter(data)
            layoutManager = manager
        }


        //프래그먼트 이동
        binding.fragment.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelayout, DataFragment())
                .commit()
        }

        val name : String?= null


    }

}

