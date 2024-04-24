package com.example.to_do_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems)
        val btnaddTodo = findViewById<Button>(R.id.btnAddTodo)

        todoAdapter = TodoAdapter(mutableListOf())
        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnaddTodo.setOnClickListener {
            val etTodoTitle = findViewById<EditText>(R.id.etTodoTitle)
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        val btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeletDoneTodos)
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteTodos()
        }
    }
}