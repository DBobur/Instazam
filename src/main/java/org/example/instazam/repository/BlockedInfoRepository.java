package org.example.instazam.repository;

import org.example.instazam.model.BlockedInfo;

public class BlockedInfoRepository extends BaseRepository<BlockedInfo> {
    private BlockedInfoRepository() {
        path += "/blockedInfos.json";
    }
    private static BlockedInfoRepository blockedInfoRepository = new BlockedInfoRepository();
    public static BlockedInfoRepository getInstance(){
        return blockedInfoRepository;
    }


    @Override
    protected boolean hasModel(BlockedInfo blockedInfo) {
        return false;
    }

    @Override
    protected Class<BlockedInfo> getTypeClass() {
        return BlockedInfo.class;
    }
}
