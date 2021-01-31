package com.longph.androidcleanarchitechture

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.longph.androidcleanarchitechture.presentation.task.TaskAdapter

@BindingAdapter("taskAdapter")
fun setTaskAdapter(view: RecyclerView, taskAdapter: TaskAdapter?) {
    taskAdapter?.let {
        view.adapter = it
    }
}

@BindingAdapter("mutableText")
fun setText(view: AppCompatTextView, text: String?) {
    text?.let {
        view.text = it
    }
}

@BindingAdapter("mutableTimeMillis")
fun setTimeMillis(view: AppCompatTextView, timeMillis: Long) {
    view.text = timeMillis.toString()
}