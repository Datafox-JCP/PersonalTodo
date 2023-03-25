package mx.datafox.personaltodo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import mx.datafox.personaltodo.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
