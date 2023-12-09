package com.example.test_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.test_app.databinding.FragmentViewModelBinding
import com.example.test_app.viewModel.MainViewModel


class ViewModelFragment : Fragment() {

    private lateinit var binding : FragmentViewModelBinding //데이터바인딩
    private val viewModel by viewModels<MainViewModel>() //viewModel 초기화

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_model, container, false)

        binding.run {
            btnPlus.setOnClickListener {
                viewModel.plus()
                input.text = viewModel.getNum().toString()


            }
        }

/*        binding.btnPlus.setOnClickListener {
            viewModel.plus()

            binding.input.text = viewModel.getNum().toString()
        }

        binding.apply {
            btnPlus.setOnClickListener {
                viewModel.plus()
                input.text = viewModel.getNum().toString()
            }
        }*/

        // Inflate the layout for this fragment
        return binding.root
    }


}