package br.edu.ifsp.scl.sc303500x.stringconcatenator.navigation

import android.net.Uri

sealed class Screen(val route: String) {

    object Home : Screen("home")

    object AddWord : Screen("add_word/{currentString}") {
        fun createRoute(currentString: String): String {
            return "add_word/${Uri.encode(currentString)}"
        }
    }
}