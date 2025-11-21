package emmanuel.avila.library.gallery.impl.data.mapper

import emmanuel.avila.core.domain.model.Album
import emmanuel.avila.core.domain.model.AlbumWithPhotos
import emmanuel.avila.core.domain.model.Photo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class AlbumsToAlbumsWithPhotosMapperTest {

    @Test
    fun `GIVEN an array of albums and an array of photos WHEN mapAlbumsToAlbumsWithPhotos THEN get expected array of albumWithPhotos`() {
        val albums = listOf(
            Album(id = 1, title = "Album 1"),
            Album(id = 2, title = "Album 2"),
        )

        val photos = listOf(
            Photo(id = 101, albumId = 1, title = "Photo 101", url = "url_101", thumbnailUrl = "thumbnail_url_101", description = "description 101"),
            Photo(id = 102, albumId = 1, title = "Photo 102", url = "url_102", thumbnailUrl = "thumbnail_url_102", description = "description 102"),
            Photo(id = 201, albumId = 2, title = "Photo 201", url = "url_201", thumbnailUrl = "thumbnail_url_201", description = "description 201"),
            )

        val expectedAlbum1Photos = listOf(
            Photo(id = 101, albumId = 1, title = "Photo 101", url = "url_101", thumbnailUrl = "thumbnail_url_101", description = "description 101"),
            Photo(id = 102, albumId = 1, title = "Photo 102", url = "url_102", thumbnailUrl = "thumbnail_url_102", description = "description 102"),
        )
        val expectedAlbum2Photos = listOf(
            Photo(id = 201, albumId = 2, title = "Photo 201", url = "url_201", thumbnailUrl = "thumbnail_url_201", description = "description 201"),
        )


        val expectedResult = listOf(
            AlbumWithPhotos(id = 1, title = "Album 1", photos = expectedAlbum1Photos),
            AlbumWithPhotos(id = 2, title = "Album 2", photos = expectedAlbum2Photos),
        )

        val result = mapAlbumsToAlbumsWithPhotos(albums, photos)

        //Check the list size
        assertEquals(albums.size, result.size)

        //Check the mapping of the first album
        val actualAlbum1 = result.find { it.id == 1 }
        assertEquals(expectedResult[0], actualAlbum1)

        //Check the mapping of the second album
        val actualAlbum2 = result.find { it.id == 2 }
        assertEquals(expectedResult[1], actualAlbum2)

    }

}