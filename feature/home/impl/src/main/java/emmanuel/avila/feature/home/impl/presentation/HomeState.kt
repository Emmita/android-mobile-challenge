package emmanuel.avila.feature.home.impl.presentation

import emmanuel.avila.core.domain.model.AlbumWithPhotos

sealed class HomeState {
    data object Idle : HomeState()

    data object Loading : HomeState()

    sealed class Error(
        open val message: String,
    ) : HomeState() {
        data class NetworkError(
            override val message: String,
        ) : Error(message)

        data class UnknownError(
            override val message: String,
        ) : Error(message)
    }

    data class Success(
        val albumWithPhotos: List<AlbumWithPhotos>,
    ) : HomeState()
}
