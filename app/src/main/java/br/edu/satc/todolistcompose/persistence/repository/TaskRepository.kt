package br.edu.satc.todolistcompose.persistence.repository

import br.edu.satc.todolistcompose.domain.entity.TaskData
import br.edu.satc.todolistcompose.persistence.dao.TaskDao

class TaskRepository(private val dao: TaskDao) {

    val allTasks = dao.findAll()

    suspend fun insert(task: TaskData) = dao.insert(task)

    suspend fun update(task: TaskData) = dao.update(task)

    suspend fun delete(task: TaskData) = dao.delete(task)
}