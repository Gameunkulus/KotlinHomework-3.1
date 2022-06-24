import Post.*

fun main() {


    val attachment1: Attachment = Attachment
    val attachment2: Attachment = Attachment

    val att1: Attachments = PhotoAttachment(
        id = 1,
        ownerId = 100101,
        userId = 110101,
        date = 16,
        width = 180,
        height = 180
    )
    val att2: Attachments = VideoAttachment(
        id = 2,
        title = "BlackComedian:Alien",
        description = "OneOfTheBestReviews",
        views = 10000
    )
    val att3: Attachments = PhotoAttachment(
        id = 3,
        ownerId = 100111,
        userId = 111101,
        date = 17,
        width = 210,
        height = 210
    )
    val att4: Attachments = DocAttachment(
        id = 4,
        title = "LatestNews",
        size = 179869184,
        ext = "pdf"
    )
    attachment1.add(att1)
    attachment1.add(att2)
    attachment2.add(att3)
    attachment2.add(att4)

    val post1: Post = Post(
        0,
        ownerId = 100001,
        fromId = 100002,
        createdBy = 100042,
        date = 5042022,
        text = "Wazzuuup",
        replyOwnerId = 100002,
        replyPostId = 100002,
        comments = null,
        copyright = null,
        likes = Likes(10000, true, true, true),
        reposts = Reposts(101, true),
        views = null,
        postType = "post",
        signerId = 100088,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = true,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut(
            isDonut = true,
            paidDuration = 300,
            placeholder = Placeholder(),
            canPublishFreeCopy = true,
            editMode = "all"
        ),
        postponedId = 60,
        attachments = attachment1
    )

    val post2: Post = Post(
        1,
        ownerId = 100002,
        fromId = 100003,
        createdBy = 100086,
        date = 6042022,
        text = "Wazzuuuuuuup",
        replyOwnerId = 100002,
        replyPostId = 100002,
        comments = Comments(101, true, true, true, true),
        copyright = Copyright(100005, "link2", "name2", "type2"),
        likes = Likes(10001, true, true, true),
        reposts = Reposts(101, true),
        views = Views(88),
        postType = "post",
        signerId = 100088,
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = true,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut(
            isDonut = true,
            paidDuration = 300,
            placeholder = Placeholder(),
            canPublishFreeCopy = true,
            editMode = "all"
        ),
        postponedId = 70,
        attachments = attachment2
    )

    val service: WallService = WallService

    service.add(post1)
    println(service.toString(1))
    println(service.attachToString(1,1))
    service.update(post2)
    println(service.toString(1))


    //WallService.add(post1)
    //WallService.add(post2)
    //println(WallService.toString(2))
    //WallService.likeById(100002)
    //println(WallService.toString(2))с
}