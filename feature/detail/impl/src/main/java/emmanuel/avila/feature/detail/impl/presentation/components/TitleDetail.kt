package emmanuel.avila.feature.detail.impl.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
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
fun TitleDetail(title: String?) {
    Text(
        text = title ?: "No Title",
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
    )
}

@Preview
@Composable
private fun PreviewTitleDetail(){
    AndroidChallengeTheme {
        TitleDetail("title")
    }
}
