package org.example.instazam.repository;

import org.example.instazam.model.Follower;

public class FollowerRepository extends BaseRepository<Follower> {
    private FollowerRepository() {
        path += "/followers.json";
    }
    private static FollowerRepository followerRepository = new FollowerRepository();
    public static FollowerRepository getInstance(){
        return followerRepository;
    }
    @Override
    protected boolean hasModel() {
        return false;
    }

    @Override
    protected Class<Follower> getTypeClass() {
        return Follower.class;
    }
}
