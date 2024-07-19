package org.example.instazam.repository;

import org.example.instazam.model.Follower;
import org.example.instazam.model.Like;

public class LikeRepository extends BaseRepository<Like> {
    private LikeRepository() {
        path += "/likes.json";
    }
    private static LikeRepository likeRepository = new LikeRepository();
    public static LikeRepository getInstance(){
        return likeRepository;
    }
    @Override
    protected boolean hasModel() {
        return false;
    }

    @Override
    protected Class<Like> getTypeClass() {
        return Like.class;
    }
}
