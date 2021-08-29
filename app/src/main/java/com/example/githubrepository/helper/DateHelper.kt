package com.example.githubrepository.helper

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

const val utcDateFormat = "yyyy-MM-dd'T'HH:mm:ss"
const val utc = "UTC"

fun formatUtcToDate(date: String?): String? {
    if (date.isNullOrBlank()) return "Not available"
    val parser = SimpleDateFormat(utcDateFormat, Locale.ENGLISH)
    parser.timeZone = TimeZone.getTimeZone(utc)
    val serverDate = parser.parse(date) ?: Date()
    return DateFormat.getDateTimeInstance().format(serverDate)
}