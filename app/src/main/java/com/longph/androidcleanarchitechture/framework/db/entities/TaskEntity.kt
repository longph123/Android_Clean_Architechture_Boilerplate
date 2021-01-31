package com.longph.androidcleanarchitechture.framework.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.longph.androidcleanarchitechture.common.TABLE_TASK_NAME

@Entity(tableName = TABLE_TASK_NAME)
data class TaskEntity (
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "time") val time: Long = 0L,
    @ColumnInfo(name = "done") val hasDone: Boolean = false
)