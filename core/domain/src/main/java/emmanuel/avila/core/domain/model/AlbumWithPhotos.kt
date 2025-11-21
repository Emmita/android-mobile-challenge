package emmanuel.avila.core.domain.model

data class AlbumWithPhotos (
    val id: Int,
    val title: String,
    val photos: List<Photo>,
)