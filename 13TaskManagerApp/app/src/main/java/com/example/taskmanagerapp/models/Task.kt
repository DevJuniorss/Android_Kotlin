package com.example.taskmanagerapp.models
enum class TaskPriority { BAIXA, MEDIA_BAIXA, MEDIA, MEDIA_ALTA, ALTA, URGENTE, CRITICA }
enum class TaskCategory { TRABALHO, CASA, ESTUDOS, TREINOS, INVESTIMENTOS }

data class Task(
    val name: String,
    val isCompleted: Boolean = false,
    val category: TaskCategory = TaskCategory.CASA,
    val priority: TaskPriority = TaskPriority.MEDIA
)
