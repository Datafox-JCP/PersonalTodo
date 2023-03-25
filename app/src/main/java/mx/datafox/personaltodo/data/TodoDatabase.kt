package mx.datafox.personaltodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.datafox.personaltodo.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}