package com.longph.core.usecases.task

import com.longph.core.data.TaskRepository
import com.longph.core.domain.task.Task
import javax.inject.Inject

class RemoveTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task): Any = taskRepository.removeTask(task)
}