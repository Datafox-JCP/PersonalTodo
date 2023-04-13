package mx.datafox.personaltodo.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import mx.datafox.personaltodo.R
import mx.datafox.personaltodo.data.models.Priority
import mx.datafox.personaltodo.data.models.TodoTask
import mx.datafox.personaltodo.ui.viewmodels.SharedViewModel
import mx.datafox.personaltodo.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: TodoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String = sharedViewModel.title
    val description: String = sharedViewModel.description
    val priority: Priority = sharedViewModel.priority

    val context = LocalContext.current

    BackHandler {
        navigateToListScreen(Action.NO_ACTION)
    }

    Scaffold(
        topBar = {
                 TaskAppBar(
                     selectedTask = selectedTask,
                     navigateToListScreen = {action ->
                         if (action == Action.NO_ACTION) {
                             navigateToListScreen(action)
                         } else {
                             if (sharedViewModel.validateFields()) {
                                 navigateToListScreen(action)
                             } else {
                                 displayToast(context = context)
                             }
                         }
                     }
                 )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.updateTitle(it)
                },
                description = description,
                onDescriptionChange = {
                    sharedViewModel.updateDescription(newDescription = it)
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.updatePriority(newPriority = it)
                }
            )
        }
    )
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        context.getString(R.string.fields_empty),
        Toast.LENGTH_SHORT
    ).show()
}

