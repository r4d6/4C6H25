package ca.qc.cstj.composables.ui.navigation

import kotlinx.serialization.Serializable

sealed class Destination {
    @Serializable
    data object Title : Destination()
    @Serializable
    data class Main(val name: String) : Destination()
}