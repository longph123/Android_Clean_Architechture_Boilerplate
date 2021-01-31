package com.longph.core.usecases.task

abstract class BaseTaskUseCase<I, O>() {
    abstract suspend operator fun invoke(task: I?) : O
}