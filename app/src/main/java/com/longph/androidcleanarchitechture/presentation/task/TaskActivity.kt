package com.longph.androidcleanarchitechture.presentation.task

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.longph.androidcleanarchitechture.R
import com.longph.androidcleanarchitechture.databinding.ActivityTaskBinding
import com.longph.core.domain.task.Task
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class TaskActivity : AppCompatActivity(){

    private lateinit var binding : ActivityTaskBinding
    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil
            .setContentView<ActivityTaskBinding>(this, R.layout.activity_task)
            .apply {
                viewModel = taskViewModel
                rcvList.layoutManager = LinearLayoutManager(this@TaskActivity)
                btnAdd.setOnClickListener {
                    if(!etInputTaskName.text.isNullOrEmpty()) {
                        val task = Task(
                            UUID.randomUUID().toString(),
                            etInputTaskName.text.toString(),
                            Calendar.getInstance().timeInMillis,
                            false
                        )
                        etInputTaskName.text?.clear()
                        taskViewModel.addTask(task)
                    }
                }
            }
    }
}