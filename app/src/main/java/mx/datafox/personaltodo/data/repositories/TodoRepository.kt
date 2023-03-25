package mx.datafox.personaltodo.data.repositories

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import mx.datafox.personaltodo.data.TodoDao
import mx.datafox.personaltodo.data.models.TodoTask
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    val getAllTasks: Flow<List<TodoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TodoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TodoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TodoTask> {
        return todoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(todoTask: TodoTask) {
        return todoDao.addTask(todoTask = todoTask)
    }

    suspend fun updateTask(todoTask: TodoTask) {
        return todoDao.updateTask(todoTask = todoTask)
    }

    suspend fun deleteTask(todoTask: TodoTask) {
        return todoDao.deleteTask(todoTask = todoTask)
    }

    suspend fun deleteAllTasks() {
        return todoDao.deleteAllTask()
    }

    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>> {
        return todoDao.searchDatabase(searchQuery = searchQuery)
    }
}