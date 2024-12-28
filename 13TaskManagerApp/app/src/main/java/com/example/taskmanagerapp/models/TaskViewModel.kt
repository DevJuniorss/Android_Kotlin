package com.example.taskmanagerapp.models

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanagerapp.utils.DataStoreUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TasksViewModel(context: Context) : ViewModel() {
    private val _tasks = MutableStateFlow(
        listOf(
            // Categoria: TRABALHO
            Task("Reunião importante", false, TaskCategory.TRABALHO, TaskPriority.ALTA),
            Task("Preparar apresentação do projeto", false, TaskCategory.TRABALHO, TaskPriority.ALTA),
            Task("Enviar relatórios semanais", false, TaskCategory.TRABALHO, TaskPriority.MEDIA_ALTA),
            // Categoria: CASA
            Task("Limpar a casa", false, TaskCategory.CASA, TaskPriority.BAIXA),
            Task("Fazer compras no mercado", false, TaskCategory.CASA, TaskPriority.MEDIA),
            Task("Reparar torneira quebrada", false, TaskCategory.CASA, TaskPriority.URGENTE),
            // Categoria: ESTUDOS
            Task("Estudar Jetpack Compose", false, TaskCategory.ESTUDOS, TaskPriority.ALTA),
            Task("Revisar conceitos de algoritmos", false, TaskCategory.ESTUDOS, TaskPriority.MEDIA),
            Task("Fazer curso de Kotlin avançado", false, TaskCategory.ESTUDOS, TaskPriority.CRITICA),
            // Categoria: TREINOS
            Task("Treino de força na academia", false, TaskCategory.TREINOS, TaskPriority.MEDIA_ALTA),
            Task("Correr 5km no parque", false, TaskCategory.TREINOS, TaskPriority.MEDIA),
            Task("Alongamento matinal", false, TaskCategory.TREINOS, TaskPriority.BAIXA),
            // Categoria: INVESTIMENTOS
            Task("Analisar carteira de investimentos", false, TaskCategory.INVESTIMENTOS, TaskPriority.CRITICA),
            Task("Assistir a um webinar financeiro", false, TaskCategory.INVESTIMENTOS, TaskPriority.MEDIA_ALTA),
            Task("Revisar metas de longo prazo", false, TaskCategory.INVESTIMENTOS, TaskPriority.ALTA)
        )
    )
    val tasks: StateFlow<List<Task>> = _tasks
    private var lastDeletedTask: Task? = null
    fun removeTask(task: Task) {
        lastDeletedTask = task
        _tasks.value = _tasks.value - task
    }
    fun undoDelete() {
        lastDeletedTask?.let {
            _tasks.value = _tasks.value + it
            lastDeletedTask = null
        }
    }
    private val _progress = MutableStateFlow(0f)
    val progress: StateFlow<Float> = _progress
    val themeFlow: Flow<Boolean> = DataStoreUtils.readTheme(context)
    private val _isDarkTheme = MutableStateFlow(false)
    init {
        viewModelScope.launch {
            themeFlow.collect { _isDarkTheme.value = it }
            updateProgress()
        }
    }
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme
    fun addTask(task: Task) {
        _tasks.value = _tasks.value + task
        updateProgress()
    }
    fun toggleTaskCompletion(task: Task) {
        _tasks.value = _tasks.value.map {
            if (it == task) it.copy(isCompleted = !it.isCompleted) else it
        }
        updateProgress()
    }
    private fun updateProgress() {
        val completed = _tasks.value.count { it.isCompleted }
        _progress.value = if (_tasks.value.isNotEmpty()) completed.toFloat() / _tasks.value.size else 0f
    }
    fun toggleTheme(context: Context) {
        viewModelScope.launch {
            val newTheme = !_isDarkTheme.value
            _isDarkTheme.value = newTheme
            DataStoreUtils.saveTheme(context, newTheme)
        }
    }
}