package Post

abstract class Attachments(
    open val type: String,
    open val id: Int,
)

data class PhotoAttachment(
    override val type: String = "photo",
    override val id: Int,
    val ownerId: Int,
    val userId: Int,
    val date: Int,
    val width: Int,
    val height: Int,
) : Attachments(type, id)

data class VideoAttachment(
    override val type: String = "video",
    override val id: Int,
    val title: String,
    val description: String,
    val views: Int,
) : Attachments(type, id)

data class DocAttachment(
    override val type: String = "doc",
    override val id: Int,
    val title: String,
    val size: Int,
    val ext: String,
) : Attachments(type, id)


object Attachment {
    private var AttachArr = emptyArray<Attachments>()
    private var checkId = 1

    fun add(attachments: Attachments): Attachments {
        val newAttach = attachments
        AttachArr += newAttach
        return AttachArr.last()
    }


    fun getId(id: Int) {
        val Attach = AttachArr[id]
        return showAttachmentId(Attach)
    }

    fun toString(num: Int): String {
        val Attach: Attachments = AttachArr[num]
        return Attach.toString()
    }

}

fun showAttachmentId(attachments: Attachments) {
    when (attachments.type) {
        "video" -> (attachments as VideoAttachment).id
        "photo" -> (attachments as PhotoAttachment).id
        "doc" -> (attachments as DocAttachment).id
    }
}
