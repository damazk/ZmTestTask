package com.bulat.zmtesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulat.zmtesttask.domain.ApiRepository
import com.bulat.zmtesttask.domain.DeviceRepository
import com.bulat.zmtesttask.domain.SharedPrefsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository,
    private val apiRepository: ApiRepository,
    private val sharedPrefsRepository: SharedPrefsRepository
): ViewModel() {
    
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun sendDeviceInfoAndGetUrl() {
        viewModelScope.launch {

            try {
                val deviceInfo = deviceRepository.getDeviceInfo()

                delay(2000) // Simulate request progress

                sharedPrefsRepository.getUrl().let {
                    if (it.isNotEmpty()) {
                        _uiState.value = UiState.WebView(it)
                        return@launch
                    }
                }

                delay(2000) // Simulate request progress

                val url = apiRepository.sendDeviceInfo(deviceInfo).body()

                if (url != null) {
                    _uiState.update { UiState.WebView(url) }
                    sharedPrefsRepository.saveUrl(url)
                } else
                    _uiState.update { UiState.Home }


            } catch (e: Exception) {
                _uiState.update { UiState.Home }
            }
        }
    }
    
    sealed interface UiState {
        data object Home : UiState
        data object Loading : UiState
        data class WebView(val url: String) : UiState
    }
} 