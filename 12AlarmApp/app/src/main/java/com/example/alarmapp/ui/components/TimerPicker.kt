package com.example.alarmapp.ui.components

import android.app.TimePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.util.*

@Composable
fun TimePicker(
    show: Boolean,
    onTimeSelected: (Int, Int) -> Unit,
    onDismiss: () -> Unit
) {
    if (show) {
        val context = LocalContext.current
        val calendar = remember { Calendar.getInstance() }
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(
            context,
            { _, selectedHour, selectedMinute ->
                onTimeSelected(selectedHour, selectedMinute)
            },
            currentHour,
            currentMinute,
            true
        )
        timePickerDialog.setOnDismissListener { onDismiss() }
        timePickerDialog.show()
    }
}