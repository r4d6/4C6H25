package ca.qc.cstj.composables.ui.screens.title

import androidx.lifecycle.ViewModel
import ca.qc.cstj.composables.models.Meditation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TitleScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TitleScreenUIState())
    val uiState = _uiState.asStateFlow()

    fun updateName(newName: String)
    {
        _uiState.update {
            _uiState.value.copy(name = newName)
        }
    }

    fun updatePassword(newPassword: String)
    {
        _uiState.update {
            _uiState.value.copy(password = newPassword)
        }
    }

    fun togglePasswordVisibility()
    {
        _uiState.update {
            _uiState.value.copy(isPasswordVisible = !_uiState.value.isPasswordVisible)
        }
    }

    fun login()
    {
        if(_uiState.value.password == "hhbbgdgdbas")
        {
            _uiState.update {
                _uiState.value.copy(isError = false)
            }
        }
    }
}