package org.example.instazam.repository;

import org.example.instazam.model.BlockedInfo;

public class BlockedInfoRepository extends BaseRepository<BlockedInfo> {
    private BlockedInfoRepository() {
        path += "/blockedInfos.json";
    }
    private BlockedInfoRepository blockedInfoRepository = new BlockedInfoRepository();
    public BlockedInfoRepository getInstance(){
        return blockedInfoRepository;
    }

    @Override
    protected boolean hasModel() {
        return false;
    }

    @Override
    protected Class<BlockedInfo> getTypeClass() {
        return BlockedInfo.class;
    }
}
