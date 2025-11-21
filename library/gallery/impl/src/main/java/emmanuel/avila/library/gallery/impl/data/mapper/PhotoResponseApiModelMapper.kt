package emmanuel.avila.library.gallery.impl.data.mapper

import emmanuel.avila.core.domain.model.Photo
import emmanuel.avila.library.gallery.impl.data.model.PhotoResponseApiModel

internal fun PhotoResponseApiModel.toDomain() =
    Photo(
        albumId = albumId,
        id = id,
        title = title,
        url = "https://picsum.photos/id/${id}/200/300",
        thumbnailUrl = thumbnailUrl,
        description = "Description of $title image"
    )
