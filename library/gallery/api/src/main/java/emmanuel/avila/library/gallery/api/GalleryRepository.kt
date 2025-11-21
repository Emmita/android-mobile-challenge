package emmanuel.avila.library.gallery.api

import arrow.core.Either
import emmanuel.avila.core.domain.model.AlbumWithPhotos

interface GalleryRepository {
    suspend fun getAlbumsWithPhotos(): Either<Throwable, List<AlbumWithPhotos>>
}