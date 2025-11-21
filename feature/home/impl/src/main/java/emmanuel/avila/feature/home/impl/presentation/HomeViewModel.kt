package emmanuel.avila.feature.home.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import emmanuel.avila.feature.home.impl.domain.GetGalleryResponseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getGalleryResponseUseCase: GetGalleryResponseUseCase,
    ) : ViewModel() {
        private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Idle)
        val state = _state.asStateFlow()

        init {
            getGalleryResponse()
        }

        private fun getGalleryResponse() {
            _state.value = HomeState.Loading
            viewModelScope.launch(Dispatchers.IO) {
                getGalleryResponseUseCase().fold(
                    {
                        val errorState =
                            when (it) {
                                Throwable("Failed to fetch data from the server."),
                                -> HomeState.Error.NetworkError(it.message ?: "Network error")
                                else -> HomeState.Error.UnknownError(it.message ?: "Unknown error")
                            }
                        _state.value = errorState
                    },
                    { albumWithPhotos ->
                        _state.value = HomeState.Success(albumWithPhotos)
                    },
                )
            }
        }
    }
