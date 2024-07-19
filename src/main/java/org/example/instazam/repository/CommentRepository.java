package org.example.instazam.repository;

import org.example.instazam.model.Comment;

public class CommentRepository extends BaseRepository<Comment> {
    private CommentRepository() {
        path += "/comments.json";
    }
    private static CommentRepository commentRepository = new CommentRepository();
    public static CommentRepository getInstance(){
        return commentRepository;
    }


    @Override
    protected boolean hasModel(Comment comment) {
        return false;
    }

    @Override
    protected Class<Comment> getTypeClass() {
        return Comment.class;
    }
}
