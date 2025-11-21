package emmanuel.avila.feature.detail.impl.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

@Composable
fun PhotoCardDetail(url: String?){
    ElevatedCard(
        modifier =
            Modifier
                .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        SubcomposeAsyncImage(
            model = url,
            contentDescription = null,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(250.dp),
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
private fun PreviewPhotoCardDetail(){
    AndroidChallengeTheme {
        PhotoCardDetail(url = "")
    }
}