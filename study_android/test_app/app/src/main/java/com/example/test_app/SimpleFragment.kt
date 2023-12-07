package com.example.test_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        return binding.root
    }


}