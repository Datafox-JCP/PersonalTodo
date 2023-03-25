package mx.datafox.personaltodo.data.models


import androidx.compose.ui.graphics.Color
import mx.datafox.personaltodo.ui.theme.HighPriorityColor
import mx.datafox.personaltodo.ui.theme.LowPriorityColor
import mx.datafox.personaltodo.ui.theme.MediumPriorityColor
import mx.datafox.personaltodo.ui.theme.NonePriorityColor

enum class Priority (val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}