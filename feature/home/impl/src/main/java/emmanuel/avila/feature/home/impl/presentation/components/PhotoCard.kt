package emmanuel.avila.feature.home.impl.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import emmanuel.avila.core.designsystem.AndroidChallengeTheme
import emmanuel.avila.core.domain.model.Photo
import emmanuel.avila.feature.home.impl.presentation.navigation.PhotoNavigationHandler

@Composable
fun PhotoCard(
    photo: Photo,
    navigationHandler: PhotoNavigationHandler,
) {
    ElevatedCard(
        modifier =
            Modifier
                .size(150.dp)
                .padding(8.dp)
                .clickable {
                    navigationHandler.onPhotoClicked(
                        url = photo.url,
                        title = photo.title,
                        description = photo.description,
                    )
                },
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 6.dp,
            ),
    ) {
        SubcomposeAsyncImage(
            model = photo.url,
            contentDescription = null,
            modifier =
                Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            loading = {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            },
        )
    }
}

@Preview
@Composable
private fun PreviewCard() {
    val photo = Photo(id = 0, albumId = 0, title = "title", url = "url", thumbnailUrl = "url", description = "description")
    val navigationHandler =
        object : PhotoNavigationHandler {
            override fun onPhotoClicked(
                url: String?,
                title: String?,
                description: String?,
            ) {
            }
        }
    AndroidChallengeTheme {
        PhotoCard(
            photo = photo,
            navigationHandler = navigationHandler,
        )
    }
}
