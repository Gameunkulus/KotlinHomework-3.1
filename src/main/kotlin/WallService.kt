import Post.Attachment
import Post.Comments
import Post.Post
import Post.showAttachmentId
import org.hamcrest.core.AnyOf

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()
    private var checkId: Int = 0

    fun add(post: Post): Post {
        checkId++
        val newPost = post.copy(id = checkId)
        posts += newPost
        return posts.last()
    }

    fun likeById(id: Int) {
        for ((index, Post) in posts.withIndex()) if (Post.id == id) {
            val post: Post = Post.copy(Post.id, likes = Post.likes.copy( count = Post.likes.count + 1))
            posts[index] = post
        }
    }

    fun update(post: Post): Boolean {

        for ((index,Post) in posts.withIndex())
        {
            if (Post.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    //fun SetPostType(type: String){
    //    val arrayType = arrayOf("post", "copy", "reply", "postpone", "suggest")
    //    for ((id) in posts.asList()){
    //        if (arrayType.contains(type)){
    //        posts[id].postType = type
    //        }
    //    }
    //}

    fun createComment(postId: Int, comment: Comments): Comments{
        for((index, Post) in posts.withIndex())
                try{
                    if (Post.id == postId){
                        val post: Post = Post.copy(Post.id, likes = Post.likes.copy( count = Post.likes.count + 1))
                        posts[index] = post
                    }
                }catch(PostNotFoundException: RuntimeException){
                    println("Post not found")
                }

    }

    fun toString(num: Int): String {
        val check = num - 1
        val post : Post = posts[check]
        return post.toString()
    }

    fun attachToString(num: Int, num2: Int): String{
        val check = num - 1
        val post : Post = posts[check]
        val attachId =  post.attachments.toString(num2)
        return attachId
    }
}