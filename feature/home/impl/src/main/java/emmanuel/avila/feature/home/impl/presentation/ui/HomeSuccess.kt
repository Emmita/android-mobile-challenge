package emmanuel.avila.feature.home.impl.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import emmanuel.avila.core.domain.model.AlbumWithPhotos
import emmanuel.avila.feature.home.impl.presentation.components.AlbumTitle
import emmanuel.avila.feature.home.impl.presentation.components.Carousel
import emmanuel.avila.feature.home.impl.presentation.navigation.PhotoNavigationHandler

@Composable
fun HomeSuccess(
    albumWithPhotos: List<AlbumWithPhotos>,
    navigationHandler: PhotoNavigationHandler,
) {
    LazyColumn {
        items(albumWithPhotos, key = { album -> album.title }) { album ->
            AlbumTitle(album.title)
            Carousel(album.photos, navigationHandler = navigationHandler)
        }
    }
}

