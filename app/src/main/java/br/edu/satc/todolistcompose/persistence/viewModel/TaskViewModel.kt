package br.edu.satc.todolistcompose.persistence.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.satc.todolistcompose.domain.entity.TaskData
import br.edu.satc.todolistcompose.persistence.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    val tasks = repository.allTasks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTask(task: TaskData) {
        viewModelScope.launch {
            repository.insert(task)
        }
    }

    fun updateTask(task: TaskData) {
        viewModelScope.launch {
            repository.update(task)
        }
    }

    fun deleteTask(task: TaskData) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }
}