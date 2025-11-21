package emmanuel.avila.feature.detail.impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import emmanuel.avila.feature.detail.impl.presentation.components.DescriptionDetail
import emmanuel.avila.feature.detail.impl.presentation.components.PhotoCardDetail
import emmanuel.avila.feature.detail.impl.presentation.components.TitleDetail

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    url: String?,
    title: String?,
    description: String?,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        TitleDetail(title = title)
        PhotoCardDetail(url = url)
        Spacer(modifier = Modifier.height(24.dp))
        DescriptionDetail(description = description)
    }
}
