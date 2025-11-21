package emmanuel.avila.androidchallenge.navigation

sealed class NavigationDestination(val route: String) {
    object Home: NavigationDestination("home_screen")
    object Detail: NavigationDestination("detail_screen")
}