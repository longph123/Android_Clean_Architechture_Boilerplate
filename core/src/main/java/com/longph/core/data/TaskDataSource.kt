package com.longph.core.data

import com.longph.core.domain.task.Task
import kotlinx.coroutines.flow.Flow

interface TaskDataSource {

    suspend fun add(task: Task)

    suspend fun edit(task: Task)

    suspend fun remove(task: Task)

    suspend fun readAll() : Flow<List<Task>>
}