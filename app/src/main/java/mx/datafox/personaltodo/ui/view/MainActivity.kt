package mx.datafox.personaltodo.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mx.datafox.personaltodo.navigation.SetupNavigation
import mx.datafox.personaltodo.ui.theme.PersonalTodoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalTodoTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}