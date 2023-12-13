package com.example.test_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_app.adapter.Test3Adapter
import com.example.test_app.data.TodoData
import com.example.test_app.databinding.FragmentTest3Binding


class Test3Fragment : Fragment() {
     private lateinit var binding : FragmentTest3Binding //데이터 바인딩

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test3, container, false)

        val todoData = arrayListOf<TodoData>()

        val adapter = Test3Adapter(todoData)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this.context)


        binding.todoBtn.setOnClickListener {
            val todo: String = binding.todoInput.text.toString()

             if(todo.isBlank()){
                    Toast.makeText(context, "할일을 입력 하세요!", Toast.LENGTH_LONG).show()
                }else {
                    todoData.add(TodoData(todo))
                    adapter.notifyItemInserted(todoData.size)
                }
            /*todo?.let {
                todoData.add(TodoData(it))
                adapter.notifyItemInserted(todoData.size-1)

            }*/
        }

        return binding.root
    }
}