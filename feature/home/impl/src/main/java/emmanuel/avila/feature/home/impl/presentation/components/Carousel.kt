package emmanuel.avila.feature.home.impl.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import emmanuel.avila.core.domain.model.Photo
import emmanuel.avila.feature.home.impl.presentation.navigation.PhotoNavigationHandler

@Composable
fun Carousel(
    photos: List<Photo>,
    navigationHandler: PhotoNavigationHandler,
) {
    val listState = rememberLazyListState()
    LazyRow(modifier = Modifier.height(180.dp), state = listState) {
        items(
            items = photos,
            key = { photo -> photo.id },
        ) { photo ->
            PhotoCard(photo = photo, navigationHandler = navigationHandler)
        }
    }
}

