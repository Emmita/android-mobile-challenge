package emmanuel.avila.library.gallery.impl.data.mapper

import emmanuel.avila.core.domain.model.Album
import emmanuel.avila.library.gallery.impl.data.model.AlbumResponseApiModel
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class AlbumResponseApiModelMapperTest {
    @Test
    fun `GIVEN a AlbumResponseApiModel WHEN toDomain THEN get the expected Album`() {
        val albumModel = AlbumResponseApiModel(
            id = 1,
            title = "The White Album"
        )

        val result = albumModel.toDomain()

        val album = Album(
            id = 1,
            title = "The White Album"
        )

        Assertions.assertEquals(album, result)
    }
}