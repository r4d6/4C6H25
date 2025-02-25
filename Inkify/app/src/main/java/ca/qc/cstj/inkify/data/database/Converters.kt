package ca.qc.cstj.inkify.data.database

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime

class Converters {
    @TypeConverter
    fun toLocalDateTime(value: String) : LocalDateTime
    {
        return LocalDateTime.parse(value)
    }

    @TypeConverter
    fun fromLocalDateTime(dateTime: LocalDateTime) : String
    {
        return dateTime.toString()
    }
}