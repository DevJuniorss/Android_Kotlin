package br.com.devjuniorss.senstrack.ui.theme

import java.util.Calendar

fun getCurrentTheme(): Boolean{
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    return  currentHour in 18 <= .. <= 23 || currentHour in 0 =< .. =< 6
}