package com.longph.core.usecases.task

import com.longph.core.data.TaskRepository
import com.longph.core.domain.task.Task
import com.longph.core.usecases.task.BaseTaskUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(): Flow<List<Task>> = taskRepository.getAllTasks()
}