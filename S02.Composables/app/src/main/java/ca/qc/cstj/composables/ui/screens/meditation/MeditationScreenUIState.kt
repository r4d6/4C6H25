package ca.qc.cstj.composables.ui.screens.meditation

import ca.qc.cstj.composables.data.MockData
import ca.qc.cstj.composables.models.Meditation

data class MeditationScreenUIState(
    val searchValue:String = "",
    val currentMeditation:Meditation = MockData.meditations.random()
)
