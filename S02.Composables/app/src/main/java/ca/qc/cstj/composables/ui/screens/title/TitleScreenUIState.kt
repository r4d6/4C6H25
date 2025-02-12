package ca.qc.cstj.composables.ui.screens.title

data class TitleScreenUIState(
    val name: String = "",
    val password:String = "",
    val isPasswordVisible:Boolean = false,
    val isError:Boolean = true
) {
}