package com.example.taskmanagerapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.taskmanagerapp.models.Task
import com.example.taskmanagerapp.models.TaskCategory
import com.example.taskmanagerapp.models.TaskPriority
import com.example.taskmanagerapp.models.TasksViewModel
import com.example.taskmanagerapp.ui.components.DropdownMenu
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(viewModel: TasksViewModel = TasksViewModel(LocalContext.current)) {
    val tasks by viewModel.tasks.collectAsState()
    val progress by viewModel.progress.collectAsState()
    val isDarkTheme by viewModel.isDarkTheme.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                TopAppBar(
                    title = { Text("Gerenciador de Tarefas") },
                    actions = {
                        IconButton(onClick = { viewModel.toggleTheme(context) }) {
                            Icon(Icons.Default.BrightnessHigh, contentDescription = "Alternar Tema")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6200EE))
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)
            ) {
                Text("Progresso das Tarefas")
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier.fillMaxWidth().height(8.dp).padding(bottom = 8.dp)
                )
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(tasks.size) { index ->
                        val task = tasks[index]
                        TaskItem(
                            task = task,
                            onToggleCompletion = { viewModel.toggleTaskCompletion(task) },
                            onDelete = {
                                viewModel.removeTask(task)
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Tarefa removida",
                                        actionLabel = "Desfazer",
                                        duration = SnackbarDuration.Short
                                    )
                                    if (result == SnackbarResult.ActionPerformed) {
                                        viewModel.undoDelete()
                                    }
                                }
                            }
                        )
                    }
                }
                AddTaskSection(onAddTask = { name, category, priority ->
                    viewModel.addTask(Task(name, false, category, priority))
                })
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onToggleCompletion: () -> Unit, onDelete: () -> Unit) {
    val scale by animateFloatAsState(if (task.isCompleted) 1.05f else 1f)
    val backgroundColor = when (task.priority) {
        TaskPriority.BAIXA -> Color(0xFFC8E6C9)
        TaskPriority.MEDIA_BAIXA -> Color(0xFFE6EE9C)
        TaskPriority.MEDIA -> Color(0xFFFFF59D)
        TaskPriority.MEDIA_ALTA -> Color(0xFFFFE082)
        TaskPriority.ALTA -> Color(0xFFFFCDD2)
        TaskPriority.URGENTE -> Color(0xFFFFAB91)
        TaskPriority.CRITICA -> Color(0xFFFF8A80)
    }

    AnimatedVisibility(visible = true) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).background(backgroundColor, RoundedCornerShape(8.dp)).pointerInput(Unit) {
                    detectHorizontalDragGestures { _, _ ->
                        onDelete()
                    }
                }.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = task.isCompleted, onCheckedChange = { onToggleCompletion() })
            Text(
                text = task.name,
                modifier = Modifier.weight(1f),
                color = if (task.isCompleted) Color.Gray else Color.Black
            )
        }
    }
}

@Composable
fun AddTaskSection(onAddTask: (String, TaskCategory, TaskPriority) -> Unit) {
    var taskName by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(TaskCategory.CASA) }
    var selectedPriority by remember { mutableStateOf(TaskPriority.MEDIA) }
    Column {
        OutlinedTextField(
            value = taskName,
            onValueChange = { taskName = it },
            label = { Text("Nova tarefa") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DropdownMenu("Categoria", TaskCategory.values().map { it.name }) {
                selectedCategory = TaskCategory.valueOf(it)
            }
            DropdownMenu("Prioridade", TaskPriority.values().map { it.name }) {
                selectedPriority = TaskPriority.valueOf(it)
            }
        }
        Button(
            onClick = {
                if (taskName.isNotBlank()) {
                    onAddTask(taskName, selectedCategory, selectedPriority)
                    taskName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Tarefa")
        }
    }
}