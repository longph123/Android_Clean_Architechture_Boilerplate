package com.longph.androidcleanarchitechture.presentation.task

import android.util.Log
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.longph.core.domain.task.Task
import com.longph.core.usecases.task.AddTaskUseCase
import com.longph.core.usecases.task.EditTaskUseCase
import com.longph.core.usecases.task.GetAllTasksUseCase
import com.longph.core.usecases.task.RemoveTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    val addTaskUseCase: AddTaskUseCase,
    val editTaskUseCase: EditTaskUseCase,
    val getAllTasksUseCase: GetAllTasksUseCase,
    val removeTaskUseCase: RemoveTaskUseCase
) : ViewModel(){
    private val TAG = this::class.simpleName
    private val mutableLoadingView = MutableLiveData<Int>(View.GONE)
    private var taskAdapter: TaskAdapter? = null

    init {
        getAllLocalTasks()
    }

    private fun getAllLocalTasks() = viewModelScope.launch {
        getAllTasksUseCase.invoke()
            .catch { cause -> Log.d(TAG, cause.toString()) }
            .collect { value ->
                getTaskListSuccess(value)
            }
    }

    fun addTask(task: Task) = viewModelScope.launch {
            addTaskUseCase.invoke(task)
    }

    fun removeTask(task: Task) = viewModelScope.launch {
        removeTaskUseCase.invoke(task)
    }

    private fun getTaskListSuccess(tasks: List<Task>){
        taskAdapter = taskAdapter ?: TaskAdapter(object : TaskAdapter.OnTaskClickListener{
            override fun onClick(task: Task) {
                removeTask(task)
            }
        })
        taskAdapter?.addData(tasks)
    }

    fun getTaskAdapter() = taskAdapter
}