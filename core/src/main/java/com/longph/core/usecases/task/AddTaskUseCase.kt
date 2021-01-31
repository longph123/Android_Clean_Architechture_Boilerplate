package com.longph.core.usecases.task

import com.longph.core.data.TaskRepository
import com.longph.core.domain.task.Task
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task) = taskRepository.addTask(task)
}