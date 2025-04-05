package br.edu.satc.todolistcompose.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.satc.todolistcompose.domain.entity.TaskData
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tbtasks")
    fun findAll(): Flow<List<TaskData>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(task: TaskData)

    @Delete
    suspend fun delete(task: TaskData)

    @Update
    suspend fun update(task: TaskData)
}