package br.com.kaue.graphql;

public class ForumData {

    record Post(String id, String content){

    }

    record Comment(String id, String content, String postId) {

    }
}
