package br.com.kaue.graphql;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
class PostService {
    Map<String, ForumData.Post> posts = new HashMap<>();

    Collection<ForumData.Post> createPost(String content) {
        var newPost = new ForumData.Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);
        return posts.values();
    }

    ForumData.Post postById(String id) {
        return posts.get(id);
    }
}

@Service
class CommentService {
    Map<String, ForumData.Comment> comments = new HashMap<>();

    Collection<ForumData.Comment> createComment(String postId, String content) {
        var newComment = new ForumData.Comment(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);
        return comments.values();
    }

    Collection<ForumData.Comment> findByPost(String postId) {
        return comments.values().stream()
                .filter(e -> e.postId().equals(postId))
                .toList();
    }
}
