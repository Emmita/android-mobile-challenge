package emmanuel.avila.library.gallery.impl.data

import emmanuel.avila.library.gallery.impl.data.model.AlbumResponseApiModel
import emmanuel.avila.library.gallery.impl.data.model.PhotoResponseApiModel
import retrofit2.http.GET

internal interface GalleryApiService {
    @GET("/albums")
    suspend fun getAlbums(): List<AlbumResponseApiModel>

    @GET("/photos")
    suspend fun getPhotos(): List<PhotoResponseApiModel>
}
