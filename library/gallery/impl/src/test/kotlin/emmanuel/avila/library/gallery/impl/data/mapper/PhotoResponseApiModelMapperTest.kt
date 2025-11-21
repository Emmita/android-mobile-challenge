package emmanuel.avila.library.gallery.impl.data.mapper

import emmanuel.avila.core.domain.model.Album
import emmanuel.avila.core.domain.model.Photo
import emmanuel.avila.library.gallery.impl.data.model.AlbumResponseApiModel
import emmanuel.avila.library.gallery.impl.data.model.PhotoResponseApiModel
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class PhotoResponseApiModelMapperTest {
    @Test
    fun `GIVEN a PhotoResponseApiModel WHEN toDomain THEN get the expected Photo`() {
        val photoModel = PhotoResponseApiModel(
            albumId = 1,
            id = 1,
            title = "title",
            url = "url",
            thumbnailUrl = "url"
        )

        val result = photoModel.toDomain()

        val photo = Photo(
            albumId = 1,
            id = 1,
            title = "title",
            url = "https://picsum.photos/id/1/200/300",
            thumbnailUrl = "url",
            description = "Description of title image"
        )

        Assertions.assertEquals(photo, result)
    }
}