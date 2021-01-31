package com.longph.androidcleanarchitechture.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.longph.androidcleanarchitechture.framework.db.dao.TaskDao
import com.longph.androidcleanarchitechture.framework.db.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun taskDao() : TaskDao
}