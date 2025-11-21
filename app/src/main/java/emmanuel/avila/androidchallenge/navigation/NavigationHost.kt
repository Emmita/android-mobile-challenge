package emmanuel.avila.androidchallenge.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import emmanuel.avila.feature.detail.impl.presentation.DetailScreen
import emmanuel.avila.feature.home.impl.presentation.HomeScreen
import emmanuel.avila.feature.home.impl.presentation.navigation.PhotoNavigationHandler

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    val photoNavigationHandler =
        remember(navController) {
            object : PhotoNavigationHandler {
                override fun onPhotoClicked(url: String?, title: String?, description: String?) {
                    val urlUri = Uri.encode(url)
                    val titleUri = Uri.encode(title)
                    val descriptionUri = Uri.encode(description)
                    navController.navigate("${NavigationDestination.Detail.route}/$urlUri/$titleUri/$descriptionUri")
                }
            }
        }

    NavHost(navController = navController, startDestination = NavigationDestination.Home.route) {
        composable(route = NavigationDestination.Home.route) { HomeScreen(navigationHandler = photoNavigationHandler) }
        composable(
            route = "${NavigationDestination.Detail.route}/{url}/{title}/{description}",
            arguments =
                listOf(
                    navArgument("url") {
                        type = NavType.StringType
                    },
                    navArgument("title") {
                        type = NavType.StringType
                    },
                    navArgument("description") {
                        type = NavType.StringType
                    },
                ),
        ) {
            val args = it.arguments
            DetailScreen(url = args?.getString("url"), title = args?.getString("title"), description = args?.getString("description"))
        }
    }
}
