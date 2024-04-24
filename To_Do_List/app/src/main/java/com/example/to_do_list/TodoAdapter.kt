package com.example.to_do_list

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos: MutableList<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHoleder>() {

    class TodoViewHoleder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHoleder {
       return TodoViewHoleder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.item_todo,
               parent,
               false
           )
       )
    }

    fun addTodo(todo:Todo){
        todos.add(todo)
        notifyItemInserted(todos.size-1)
    }


    fun deleteTodos(){
        todos.removeAll { todo ->
            todo.isChecked

        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked:Boolean){
        if(isChecked){
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHoleder, position: Int) {
        val curTodo = todos[position]
       holder.itemView.apply {
          val tvTodoTitle = findViewById<TextView>(R.id.tvTodoTitle)
           val cbDone = findViewById<CheckBox>(R.id.cbDone)
           tvTodoTitle.text = curTodo.title
           cbDone.isChecked = curTodo.isChecked
           toggleStrikeThrough(tvTodoTitle,curTodo.isChecked)
           cbDone.setOnCheckedChangeListener { _, isChecked ->

               toggleStrikeThrough(tvTodoTitle,isChecked)
               curTodo.isChecked = !curTodo.isChecked
           }




       }

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}