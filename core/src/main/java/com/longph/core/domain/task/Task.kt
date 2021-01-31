package com.longph.core.domain.task

data class Task (
    val _id: String,
    val name: String,
    val time: Long,
    val hasDone: Boolean
)