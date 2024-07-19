package org.example.instazam.repository;

import org.example.instazam.model.Post;

public class PostRepository extends BaseRepository<Post> {
    private PostRepository() {
        path += "/posts.json";
    }
    private static PostRepository postRepository = new PostRepository();
    public static PostRepository getInstance(){
        return postRepository;
    }


    @Override
    protected boolean hasModel(Post post) {
        return false;
    }

    @Override
    protected Class<Post> getTypeClass() {
        return Post.class;
    }
}
