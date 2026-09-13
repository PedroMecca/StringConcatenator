package br.edu.ifsp.scl.sc303500x.stringconcatenator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.edu.ifsp.scl.sc303500x.stringconcatenator.ui.AddWordScreen
import br.edu.ifsp.scl.sc303500x.stringconcatenator.ui.HomeScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {

        composable(Screen.Home.route) {
            var currentString by rememberSaveable { mutableStateOf("") }

            HomeScreen(
                currentString = currentString,
                onAddWordClick = {
                    navController.navigate(Screen.AddWord.createRoute(currentString))
                },
                onResetClick = {
                    currentString = ""
                }
            )
        }

        composable(
            route = Screen.AddWord.route,
            arguments = listOf(navArgument("currentString") { type = NavType.StringType })
        ) { backStackEntry ->
            val receivedString = backStackEntry.arguments?.getString("currentString") ?: ""

            AddWordScreen(
                currentString = receivedString,
                onConcatenateClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}