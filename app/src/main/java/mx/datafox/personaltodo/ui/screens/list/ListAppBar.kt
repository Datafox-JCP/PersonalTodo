package mx.datafox.personaltodo.ui.screens.list

import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mx.datafox.personaltodo.ui.theme.topAppBarBackgroundColor
import mx.datafox.personaltodo.ui.theme.topAppBarContentColor

@Composable
fun ListAppBar() {
    DefaultListAppbar()
}

@Composable
fun DefaultListAppbar() {
    TopAppBar(
        title = {
            Text(
                "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
@Preview
fun DefaultListAppbarPreview() {
    DefaultListAppbar()
}