package emmanuel.avila.feature.home.impl.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import emmanuel.avila.core.designsystem.AndroidChallengeTheme

@Composable
fun AlbumTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
    )
}

@Preview
@Composable
private fun PreviewAlbumTitle() {
    AndroidChallengeTheme {
        AlbumTitle("Title")
    }
}
