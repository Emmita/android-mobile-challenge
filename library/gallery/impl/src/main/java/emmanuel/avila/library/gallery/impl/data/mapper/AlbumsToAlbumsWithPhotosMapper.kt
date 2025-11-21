package emmanuel.avila.library.gallery.impl.data.mapper

import emmanuel.avila.core.domain.model.Album
import emmanuel.avila.core.domain.model.AlbumWithPhotos
import emmanuel.avila.core.domain.model.Photo

internal fun mapAlbumsToAlbumsWithPhotos(
    albums: List<Album>,
    photos: List<Photo>,
): List<AlbumWithPhotos> {
    val photosByAlbumId = photos.groupBy { it.albumId }
    return albums.map { album ->
        AlbumWithPhotos(
            id = album.id,
            title = album.title,
            photos =
                photosByAlbumId.getOrElse(album.id) {
                    emptyList()
                },
        )
    }
}
