package com.longph.core.usecases.task

import com.longph.core.data.TaskRepository
import com.longph.core.domain.task.Task
import com.longph.core.usecases.task.BaseTaskUseCase
import javax.inject.Inject

class EditTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(task: Task): Any = taskRepository.editTask(task)
}