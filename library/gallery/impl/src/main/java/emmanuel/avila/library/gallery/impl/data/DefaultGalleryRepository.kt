package emmanuel.avila.library.gallery.impl.data

import arrow.core.Either
import emmanuel.avila.core.domain.model.AlbumWithPhotos
import emmanuel.avila.library.gallery.api.GalleryRepository
import javax.inject.Inject

internal class DefaultGalleryRepository
    @Inject
    constructor(
        private val galleryDataSource: GalleryDataSource,
    ) : GalleryRepository {
        override suspend fun getAlbumsWithPhotos(): Either<Throwable, List<AlbumWithPhotos>> = galleryDataSource.getAlbumsWithPhotos()
    }
