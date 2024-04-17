package br.com.kaue.graphql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;
    private ForumData.Post post;

    @BeforeEach
    @Test
    void createPost() {
        String postContent = "Meu post de teste";
        Collection<ForumData.Post> meuPostDeTeste = postService.createPost(postContent);
        this.post = meuPostDeTeste.stream().findAny().get();
        Assertions.assertEquals(this.post.content(), postContent);
    }

    @Test
    void postById() {
        ForumData.Post postRecorded = postService.postById(this.post.id());
        Assertions.assertEquals(postRecorded.content(), this.post.content());
    }
}