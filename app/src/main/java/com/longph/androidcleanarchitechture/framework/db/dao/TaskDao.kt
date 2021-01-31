package com.longph.androidcleanarchitechture.framework.db.dao

import androidx.room.*
import com.longph.androidcleanarchitechture.common.TABLE_TASK_NAME
import com.longph.androidcleanarchitechture.framework.db.entities.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM $TABLE_TASK_NAME")
    fun getAll(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(taskEntity: TaskEntity)
}