package com.longph.androidcleanarchitechture.framework.db.mapper

import com.longph.androidcleanarchitechture.common.EMPTY_STRING
import com.longph.androidcleanarchitechture.framework.db.entities.TaskEntity
import com.longph.core.domain.task.Task
import java.util.*

internal class TaskEntityMapper {

    companion object {
        fun mapFromTask(task: Task) = TaskEntity(
            uid = task._id,
            name = task.name,
            time = task.time,
            hasDone = task.hasDone
        )

        fun mapToTask(taskEntity: TaskEntity) = Task(
            _id = taskEntity.uid,
            name = taskEntity.name ?: EMPTY_STRING,
            time = taskEntity.time,
            hasDone = taskEntity.hasDone
        )
    }

}