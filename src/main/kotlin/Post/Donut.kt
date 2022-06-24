package Post

data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int,
    val placeholder: Placeholder,
    val canPublishFreeCopy: Boolean = false,
    val editMode: String,
)