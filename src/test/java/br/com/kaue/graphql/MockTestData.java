package br.com.kaue.graphql;

public class MockTestData {
    public static ForumData.Post umPost() {
       return new ForumData.Post(
               "1b51ff7a-08d4-4a40-b509-7db57df67874",
               "Meu primeiro post");
    }

    public static ForumData.Comment umComment() {
        return new ForumData.Comment(
                "bcb92caa-db2f-4f6d-afdc-d136417fb0e5",
                "Meu primeiro comment",
                umPost().id());
    }
}
