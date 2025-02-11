package ca.qc.cstj.composables.ui.screens.meditation

import androidx.lifecycle.ViewModel
import ca.qc.cstj.composables.data.MockData
import ca.qc.cstj.composables.models.Meditation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MeditationScreenViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MeditationScreenUIState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update {
            _uiState.value.copy(
                meditations = MockData.meditations,
                tags = MockData.meditationTags
            )
        }
    }

    fun updateSearchValue(newValue:String)
    {
        _uiState.update {
            _uiState.value.copy(
                searchValue = newValue
            )
        }
        _uiState.update {
            _uiState.value.copy(
                meditations = filterMeditation()
            )
        }
    }

    fun startMeditation(meditation: Meditation)
    {
        _uiState.update {
            _uiState.value.copy(currentMeditation = meditation)
        }
    }

    fun changeSelectedTag(selectedTag: String)
    {
        _uiState.update {
            _uiState.value.copy(
                selectedTag = selectedTag
            )
        }
        _uiState.update {
            _uiState.value.copy(
                meditations = filterMeditation()
            )
        }
    }

    private fun filterMeditation() : List<Meditation>
    {
        return MockData.meditations.filter { m ->
            m.tags.contains(uiState.value.selectedTag) &&
                    m.title.contains(uiState.value.searchValue) }
    }
}