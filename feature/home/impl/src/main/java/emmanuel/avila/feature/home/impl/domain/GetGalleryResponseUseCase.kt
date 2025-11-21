package emmanuel.avila.feature.home.impl.domain

import arrow.core.Either
import emmanuel.avila.core.domain.model.AlbumWithPhotos
import emmanuel.avila.library.gallery.api.GalleryRepository
import javax.inject.Inject

class GetGalleryResponseUseCase
    @Inject
    constructor(
        private val galleryRepository: GalleryRepository,
    ) {
        suspend operator fun invoke(): Either<Throwable, List<AlbumWithPhotos>> =
                galleryRepository.getAlbumsWithPhotos()
    }
