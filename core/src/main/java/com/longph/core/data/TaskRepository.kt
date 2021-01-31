package com.longph.core.data

import com.longph.core.domain.task.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun addTask(task: Task)

    suspend fun editTask(task: Task)

    suspend fun removeTask(task: Task)

    suspend fun getAllTasks() : Flow<List<Task>>
}