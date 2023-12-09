package com.example.test_app

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test_app.adapter.TagAdapter
import com.example.test_app.data.TagData
import com.example.test_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var data : List<TagData>

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //더미 데이터 입력
        data = listOf<TagData>(
            TagData(getDrawable(R.drawable.icon_coffe)!!, "level1"),
            TagData(getDrawable(R.drawable.icon_chair)!!, "level2"),
            TagData(getDrawable(R.drawable.icon_light)!!, "level3"),
            TagData(getDrawable(R.drawable.icon_mic)!!, "level4"),
            TagData(getDrawable(R.drawable.icon_pizza)!!, "level5"),
            TagData(getDrawable(R.drawable.icon_table)!!, "level6"),

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
                  //  0 ->  setFragment(SimpleFragment())
                0 -> setFragment(SimpleFragment())
                1 -> setDialog(1,"프래그먼크 + 데이터바인딩 + 뷰모델 적용", ViewModelFragment())
                2 -> setDialog(2,"viewModel + recyclerview + LiveData 적용", Test3Fragment())

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

    private fun setDialog(index : Int, message : String, fragment: Fragment){
        AlertDialog.Builder(this)
            .setTitle(data.get(index).tagName)
            .setMessage(message)
            .setPositiveButton("ok", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    setFragment(fragment)
                }
            })
            .create()
            .show()
    }
}