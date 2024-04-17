package br.com.kaue.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ForumController {

    private PostService postService;
    private CommentService commentService;

    public ForumController(PostService postService,
                           CommentService commentService) {

        this.postService = postService;
        this.commentService = commentService;
    }

    @QueryMapping
    public ForumData.Post postById(@Argument String id) {
        System.out.println("Metodo postById");
        return this.postService.postById(id);
    }

    @MutationMapping
    public Collection<ForumData.Post> createPost(@Argument String content) {
        return this.postService.createPost(content);
    }

    @MutationMapping
    public Collection<ForumData.Comment> createComment(@Argument String postId, @Argument String content) {
        return this.commentService.createComment(postId, content);
    }

    @SchemaMapping
    public Collection<ForumData.Comment> comments(ForumData.Post post) {
        System.out.println("Metodo comments");
        return this.commentService.findByPost(post.id());
    }
}
