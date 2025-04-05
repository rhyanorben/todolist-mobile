package br.edu.satc.todolistcompose.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbtasks")
data class TaskData (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idtask")
    val id: Int = 0,

    @ColumnInfo(name = "dstitle")
    var title: String,

    @ColumnInfo(name = "dsdescricao")
    var description: String,

    @ColumnInfo(name = "flcomplete")
    var complete: Boolean
)