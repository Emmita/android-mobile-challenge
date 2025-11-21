package emmanuel.avila.library.gallery.impl.data

import arrow.core.Either
import emmanuel.avila.core.domain.model.Album
import emmanuel.avila.core.domain.model.AlbumWithPhotos
import emmanuel.avila.core.domain.model.Photo
import emmanuel.avila.library.gallery.impl.data.mapper.mapAlbumsToAlbumsWithPhotos
import emmanuel.avila.library.gallery.impl.data.mapper.toDomain
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

internal class DefaultGalleryDataSource
    @Inject
    constructor(
        private val galleryApiService: GalleryApiService,
    ) : GalleryDataSource {
        private suspend fun getAlbums(): Either<Throwable, List<Album>> =
            try {
                Either.Right(galleryApiService.getAlbums().map { album -> album.toDomain() })
            } catch (e: Exception) {
                Either.Left(e)
            }

        private suspend fun getPhotos(): Either<Throwable, List<Photo>> =
            try {
                Either.Right(galleryApiService.getPhotos().map { photo -> photo.toDomain() })
            } catch (e: Exception) {
                Either.Left(e)
            }

        override suspend fun getAlbumsWithPhotos(): Either<Throwable, List<AlbumWithPhotos>> =
            coroutineScope {
                val albumsResult = async { getAlbums() }.await()
                val photosResult = async { getPhotos() }.await()

                return@coroutineScope when {
                    albumsResult is Either.Left -> albumsResult
                    photosResult is Either.Left -> photosResult

                    albumsResult is Either.Right && photosResult is Either.Right -> {
                        val albums = albumsResult.value
                        val photos = photosResult.value

                        val albumsWithPhotos = mapAlbumsToAlbumsWithPhotos(albums = albums, photos = photos)
                        Either.Right(albumsWithPhotos)
                    }

                    else -> Either.Left(UnknownError())
                }
            }


    }
