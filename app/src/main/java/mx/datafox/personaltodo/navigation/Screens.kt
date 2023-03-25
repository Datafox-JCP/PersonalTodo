package mx.datafox.personaltodo.navigation

import androidx.navigation.NavController
import mx.datafox.personaltodo.util.Action
import mx.datafox.personaltodo.util.Constants.LIST_SCREEN

class Screens(navController: NavController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}