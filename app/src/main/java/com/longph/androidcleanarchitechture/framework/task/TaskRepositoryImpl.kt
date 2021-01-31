package com.longph.androidcleanarchitechture.framework.task

import com.longph.core.data.TaskDataSource
import com.longph.core.data.TaskRepository
import com.longph.core.domain.task.Task
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource) : TaskRepository {

    override suspend fun addTask(task: Task) = taskDataSource.add(task)

    override suspend fun editTask(task: Task) = taskDataSource.edit(task)

    override suspend fun removeTask(task: Task) = taskDataSource.remove(task)

    override suspend fun getAllTasks(): Flow<List<Task>> = taskDataSource.readAll()
}