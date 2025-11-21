package emmanuel.avila.library.gallery.impl.data

import arrow.core.Either
import emmanuel.avila.core.domain.model.AlbumWithPhotos

internal interface GalleryDataSource {
    suspend fun getAlbumsWithPhotos(): Either<Throwable, List<AlbumWithPhotos>>
}
