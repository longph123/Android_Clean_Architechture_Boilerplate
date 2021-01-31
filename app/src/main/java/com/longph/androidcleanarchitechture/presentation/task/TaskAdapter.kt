package com.longph.androidcleanarchitechture.presentation.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.longph.androidcleanarchitechture.databinding.ItemTaskBinding
import com.longph.core.domain.task.Task

class TaskAdapter(private var clickListener: OnTaskClickListener?) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var tasks = arrayListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.binds(task, View.OnClickListener {
            clickListener?.onClick(task)
        })
    }

    fun addData(tasks: List<Task>){
        this.tasks.clear()
        this.tasks.addAll(tasks)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

        fun binds(task: Task, onClick: View.OnClickListener){
            binding.task = task
            binding.clickListener = onClick
        }
    }

    interface OnTaskClickListener{
        fun onClick(task: Task)
    }
}