package emmanuel.avila.library.gallery.impl.data.mapper

import emmanuel.avila.core.domain.model.Album
import emmanuel.avila.library.gallery.impl.data.model.AlbumResponseApiModel

internal fun AlbumResponseApiModel.toDomain() =
    Album(
        id = id,
        title = title,
    )
