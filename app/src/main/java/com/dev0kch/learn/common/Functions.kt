package com.dev0kch.learn.common

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun refactoringText(text: String?, requiedLenght: Int): String {
    var refactText = ""
    if (!text.isNullOrEmpty()) {
        refactText = if (text.length >= requiedLenght) {
            text.substring(0, requiedLenght) + "..."
        } else {
            text
        }

    }

    return refactText
}


fun refactoringDate(inputDate: String?): String {
    var refactDate = ""
    if (!inputDate.isNullOrEmpty()) {
        val dateTime = LocalDateTime.parse(inputDate, DateTimeFormatter.ISO_DATE_TIME)
        val dayOfWeek = dateTime.dayOfWeek
        val month = dateTime.month
        val dayOfMonth = dateTime.dayOfMonth
        val year = dateTime.year

        refactDate = "${dayOfWeek.toString().substring(0, 3).lowercase().replaceFirstChar(Char::uppercase) }, $dayOfMonth ${
            month.toString().substring(0, 3).lowercase().replaceFirstChar(Char::uppercase)
        } $year"
    }
    return refactDate
}