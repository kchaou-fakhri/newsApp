package com.dev0kch.learn.common

import com.dev0kch.learn.utils.Constants
import com.dev0kch.learn.utils.fackUrl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
/**
 * refactoringText is a function to refactor the input text to a specified length with ellipsis if needed.
 *
 * @param text The input text to be refactored.
 * @param requiredLength The desired length of the text after refactoring.
 * @return The refactored text with a maximum length of 'requiredLength' characters, appended with ellipsis if necessary.
 */
fun refactoringText(text: String?, requiredLength: Int): String {
    var refactText = ""

    // Check if the input text is not null or empty
    if (!text.isNullOrEmpty()) {
        // If the length of the text is greater than or equal to the required length,
        // truncate the text and add ellipsis, otherwise keep the original text
        refactText = if (text.length >= requiredLength) {
            text.substring(0, requiredLength) + "..."
        } else {
            text
        }
    }

    return refactText
}

/**
 * refactoringDate is a function to refactor the input date string into a formatted date string.
 *
 * @param inputDate The input date string to be refactored.
 * @return The refactored date string in the format: "DayOfWeek, DayOfMonth MonthAbbreviation Year".
 */
fun refactoringDate(inputDate: String?): String {
    var refactDate = ""

    // Check if the input date string is not null or empty
    if (!inputDate.isNullOrEmpty()) {
        // Parse the input date string into LocalDateTime
        val dateTime = LocalDateTime.parse(inputDate, DateTimeFormatter.ISO_DATE_TIME)
        // Extract day of week, month, day of month, and year from the parsed date
        val dayOfWeek = dateTime.dayOfWeek
        val month = dateTime.month
        val dayOfMonth = dateTime.dayOfMonth
        val year = dateTime.year

        // Format the date string with day of week, day of month, month abbreviation, and year
        refactDate = "${
            dayOfWeek.toString().substring(0, 3).lowercase().replaceFirstChar(Char::uppercase)
        }, $dayOfMonth ${
            month.toString().substring(0, 3).lowercase().replaceFirstChar(Char::uppercase)
        } $year"
    }

    return refactDate
}

/**
 * checkImage is a function to check and possibly modify an image URL.
 *
 * @param urlImage The input image URL to be checked.
 * @return The modified URL if the image type is unacceptable, otherwise the original URL.
 */
fun checkImage(urlImage: String?): String {
    var generateUrl: String? = urlImage

    // Check if the URL is not null or blank
    if (!urlImage.isNullOrBlank()) {
        // Check if the image type is in the list of unacceptable image types
        if (Constants.unAcceptedImageType.contains(
                urlImage.substring(
                    urlImage.length - 4,
                    urlImage.length
                )
            )
        ) {
            // If the image type is unacceptable, replace the URL with a fake URL
            generateUrl = fackUrl
        }
    } else {
        // If the URL is null or blank, replace it with a fake URL
        generateUrl = fackUrl
    }

    // Return the modified or original URL
    return generateUrl!!
}
