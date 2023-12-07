package com.example.recyclerview.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.MainActivity
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)


        //프래그먼트 이동
        binding.btnFragment.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelayout, DataFragment())
                .commit()
}

        val array = ArrayList<String>()
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")
        array.add("f")
        array.add("g")
        array.add("h")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")
        array.add("f")
        array.add("g")
        array.add("h")


        val dataAdapter  = DataBindingAdapter(array)

        //xml리사이클러뷰 연결
        //val rv = binding.recyclerView

       /* rv.apply {
            adapter = dataAdapter
            layoutManager = LinearLayoutManager(context)
        }
*/


    }
}