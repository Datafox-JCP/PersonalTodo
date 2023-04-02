package mx.datafox.personaltodo.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import mx.datafox.personaltodo.R
import mx.datafox.personaltodo.ui.theme.fabBackgroundColor
import mx.datafox.personaltodo.ui.viewmodels.SharedViewModel
import mx.datafox.personaltodo.util.SearchAppBarState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTasks()
    }

    val allTasks by sharedViewModel.allTasks.collectAsState()
    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
                 ListAppBar(
                     sharedViewModel = sharedViewModel,
                     searchAppBarState = searchAppBarState,
                     searchTextState = searchTextState
                 )
        },
        content = {
                  ListContent(
                      tasks = allTasks,
                      navigateToTaskScreen
                  )
        },
        floatingActionButton = {
            ListFab(
                onFavClicked = navigateToTaskScreen
            )
        }
    )
}

@Composable
fun ListFab(
    onFavClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFavClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task),
            tint = Color.White
        )
    }
}
