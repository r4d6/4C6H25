package ca.qc.cstj.inkify.core

import androidx.compose.ui.graphics.Color
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter

val String.toColor
    get() = Color(android.graphics.Color.parseColor(this))

fun LocalDateTime.format(format:String) : String
{
    val formatter = DateTimeFormatter.ofPattern(format)
    return this.toJavaLocalDateTime().format(formatter)
}
