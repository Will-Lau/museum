package museum.museum.Service;

import museum.museum.dao.RelicLikeMapper;
import museum.museum.dao.RelicMapper;
import museum.museum.Entity.*;
import museum.museum.Request.InsertLIkeRelicRequest;
import museum.museum.Response.RelicSimpleResponse;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RelicLikeService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected RelicLikeMapper relicLikeMapper;

    @Resource
    protected RelicMapper relicMapper;

    //收藏文物
    public String insertLikeRelic(String userId, InsertLIkeRelicRequest insertLIkeRelicRequest){
        RelicLike relicLike=new RelicLike();
        relicLike.setUserId(userId);
        relicLike.setrId(insertLIkeRelicRequest.getRId());
        relicLike.setLikeTime(insertLIkeRelicRequest.getLikeTime());
        relicLikeMapper.insertSelective(relicLike);
        return "添加成功";
    }

    //取消收藏
    public String deleteLikeRelic(String userId,long rId){

        RelicLikeKey relicLikeKey=new RelicLikeKey();
        relicLikeKey.setUserId(userId);
        relicLikeKey.setrId(rId);
        if(relicLikeMapper.selectByPrimaryKey(relicLikeKey)==null) return "收藏不存在";
        else {
            relicLikeMapper.deleteByPrimaryKey(relicLikeKey);
            return "删除成功";
        }
    }

    //得到所有收藏的文物
    public List<RelicSimpleResponse> getLikeRelic(String userId){
        RelicLikeExample relicLikeExample=new RelicLikeExample();
        relicLikeExample.createCriteria().andUserIdEqualTo(userId);
        List<RelicLike> relicLikes=relicLikeMapper.selectByExample(relicLikeExample);
        if(relicLikes==null||relicLikes.size()==0) return  null;
        List<RelicSimpleResponse> relicSimpleResponses=new ArrayList<>();
        for(RelicLike item:relicLikes){
            Relic relic=relicMapper.selectByPrimaryKey(item.getrId());
            RelicSimpleResponse relicSimpleResponse=dozerMapper.map(relic,RelicSimpleResponse.class);
            relicSimpleResponse.setLikeTime(item.getLikeTime());
            relicSimpleResponses.add(relicSimpleResponse);
        }
        return relicSimpleResponses;
    }

}
