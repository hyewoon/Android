package com.example.test_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_app.adapter.TagAdapter
import com.example.test_app.adapter.UserAdapter
import com.example.test_app.data.User
import com.example.test_app.databinding.FragmentSimpleBinding

/*
* fragement는 activity와 다르게 setContentView가 없다
* ---> 그러므로 직접 xml 파일을 객체를생성해주는 inflate 해줘야 한다.
* ---> 어디서 ?? onCreateView에서
* */

class SimpleFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSimpleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_simple, container, false)

        val userData = ArrayList<User>()
        userData.add(User("Kim", 28, "java"))
        userData.add(User("John", 32, "python"))
        userData.add(User("hong", 24, "kotlin"))
        userData.add(User("Jennie", 42, "dataScience"))
        userData.add(User("Mike", 28, "dataBase"))
        userData.add(User("kelly", 32, "python"))
        userData.add(User("Jake", 35, "kotlin"))
        userData.add(User("Kate", 19, "c++"))
        userData.add(User("Kim", 28, "java"))
        userData.add(User("John", 32, "python"))
        userData.add(User("hong", 24, "kotlin"))
        userData.add(User("Jennie", 42, "dataScience"))
        userData.add(User("Mike", 28, "dataBase"))
        userData.add(User("kelly", 32, "python"))
        userData.add(User("Jake", 35, "kotlin"))
        userData.add(User("Kate", 19, "c++"))

        val adapter = UserAdapter(userData)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this.context)


        adapter.itemClick = object :UserAdapter.ItemClick, TagAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(activity, userData[position].userSubject.toString(), Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }


}