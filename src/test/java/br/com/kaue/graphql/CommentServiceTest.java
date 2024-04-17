package br.com.kaue.graphql;

import graphql.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
@SpringBootTest
class CommentServiceTest {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    private final ForumData.Post post = MockTestData.umPost();
    private ForumData.Comment comment;

    @BeforeEach
    @Test
    void createComment() {
        String commentContent = "Meu comentario de teste";
        Collection<ForumData.Comment> meuComentarioDeTeste = commentService.createComment(this.post.id(),
                commentContent);
        Assert.assertNotEmpty(meuComentarioDeTeste);
        Assertions.assertEquals(meuComentarioDeTeste.stream().findFirst().get().content(), commentContent);
        this.comment = meuComentarioDeTeste.stream().findFirst().get();
    }

    @Test
    void findByPost() {
        Collection<ForumData.Comment> comments = commentService.findByPost(this.post.id());
        Assert.assertNotEmpty(comments);
        Assertions.assertEquals(comments.stream().findFirst().get().content(), this.comment.content());
    }
}