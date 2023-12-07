package com.example.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test_app.adapter.TagAdapter
import com.example.test_app.data.TagData
import com.example.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //더미 데이터 입력
        var data = listOf<TagData>(
            TagData(getDrawable(R.drawable.icon_coffe)!!, "dataBinding + fragement"),
            TagData(getDrawable(R.drawable.icon_chair)!!, "리사이클러뷰"),
            TagData(getDrawable(R.drawable.icon_light)!!, "dataBinding + fragement"),
            TagData(getDrawable(R.drawable.icon_mic)!!, "리사이클러뷰"),
            TagData(getDrawable(R.drawable.icon_pizza)!!, "dataBinding + fragement"),
            TagData(getDrawable(R.drawable.icon_table)!!, "리사이클러뷰"),

            )
        //리사이클러뷰 추가
        val adapter = TagAdapter(data)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(this, 3)

       /* binding.recycler.apply {
            adapter = TagAdapter(data)
            layoutManager = GridLayoutManager(context, 3)
        }*/

        adapter.itemClick = object : TagAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                when(position){
                    0 ->  setFragment(SimpleFragment())
                    else -> Toast.makeText(this@MainActivity, data[position].tagName.toString(), Toast.LENGTH_LONG).show()
                }

            }
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment, fragment)
            setReorderingAllowed(true)
            addToBackStack("")


        }

    }
}