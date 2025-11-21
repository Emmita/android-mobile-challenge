package emmanuel.avila.feature.detail.impl.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import emmanuel.avila.core.designsystem.AndroidChallengeTheme

@Composable
fun DescriptionDetail(description: String?){
    Text(
        text = description ?: "No description provided.",
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
private fun PreviewDescriptionDetail(){
    AndroidChallengeTheme {
        DescriptionDetail("description")
    }
}
