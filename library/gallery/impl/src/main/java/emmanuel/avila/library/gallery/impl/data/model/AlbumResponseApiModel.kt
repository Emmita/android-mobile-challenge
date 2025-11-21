package emmanuel.avila.library.gallery.impl.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class AlbumResponseApiModel(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
)
