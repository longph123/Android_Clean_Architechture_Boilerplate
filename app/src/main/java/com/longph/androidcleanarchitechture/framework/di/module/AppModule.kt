package com.longph.androidcleanarchitechture.framework.di.module

import android.content.Context
import androidx.room.Room
import com.longph.androidcleanarchitechture.common.DATABASE_NAME
import com.longph.androidcleanarchitechture.framework.db.AppDatabase
import com.longph.androidcleanarchitechture.framework.db.dao.TaskDao
import com.longph.androidcleanarchitechture.framework.task.TaskDataSourceImpl
import com.longph.androidcleanarchitechture.framework.task.TaskRepositoryImpl
import com.longph.core.data.TaskDataSource
import com.longph.core.data.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context) : AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(database: AppDatabase) = database.taskDao()

    @Provides
    @Singleton
    fun provideTaskDataSource(taskDao: TaskDao) : TaskDataSource {
        return TaskDataSourceImpl(taskDao)
    }

    @Provides
    fun provideTaskRepository(taskDataSource: TaskDataSource) : TaskRepository {
        return TaskRepositoryImpl(taskDataSource)
    }
}