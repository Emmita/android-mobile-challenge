package emmanuel.avila.feature.home.impl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import emmanuel.avila.feature.home.impl.presentation.navigation.PhotoNavigationHandler
import emmanuel.avila.feature.home.impl.presentation.ui.HomeError
import emmanuel.avila.feature.home.impl.presentation.ui.HomeLoading
import emmanuel.avila.feature.home.impl.presentation.ui.HomeSuccess

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigationHandler: PhotoNavigationHandler,
) {
    val state = homeViewModel.state.collectAsState().value

    Column(modifier = modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        when (state) {
            is HomeState.Idle -> Unit
            is HomeState.Loading -> HomeLoading()
            is HomeState.Error -> HomeError(error = state.message)
            is HomeState.Success -> HomeSuccess(state.albumWithPhotos, navigationHandler = navigationHandler)
        }
    }
}
