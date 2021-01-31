package com.longph.androidcleanarchitechture.framework.task

import com.longph.androidcleanarchitechture.framework.db.AppDatabase
import com.longph.androidcleanarchitechture.framework.db.dao.TaskDao
import com.longph.androidcleanarchitechture.framework.db.mapper.TaskEntityMapper
import com.longph.core.data.TaskDataSource
import com.longph.core.domain.task.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.transform

class TaskDataSourceImpl(private val taskDao: TaskDao) : TaskDataSource{

    override suspend fun add(task: Task) {
        val entity = TaskEntityMapper.mapFromTask(task)
        taskDao.addTask(entity)
    }

    override suspend fun edit(task: Task) {
        val entity = TaskEntityMapper.mapFromTask(task)
        taskDao.updateTask(entity)
    }

    override suspend fun remove(task: Task) {
        val entity = TaskEntityMapper.mapFromTask(task)
        taskDao.deleteTask(entity)
    }

    override suspend fun readAll(): Flow<List<Task>> {
        return taskDao.getAll()
            .transform {
                val tasks = it.map { it2 -> TaskEntityMapper.mapToTask(it2) }
                emit(tasks)
            }
    }
}