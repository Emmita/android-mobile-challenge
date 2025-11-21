package emmanuel.avila.feature.home.impl.presentation.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import emmanuel.avila.core.designsystem.AndroidChallengeTheme

@Composable
fun HomeError(error: String) {
    Text(
        text = error,
        color = MaterialTheme.colorScheme.error,
    )
}

@Preview
@Composable
private fun Preview() {
    AndroidChallengeTheme {
        HomeError(error = "error")
    }
}
