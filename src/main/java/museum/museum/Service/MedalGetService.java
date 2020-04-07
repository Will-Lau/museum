package museum.museum.Service;

import museum.museum.Entity.*;
import museum.museum.dao.MedalGetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedalGetService {
    @Autowired
    private MedalGetMapper medalGetMapper;

    //条件查
    public List<MedalGet> getMedalGets(MedalGet medalGet){
        MedalGetExample medalGetExample=new MedalGetExample();
        MedalGetExample.Criteria criteria=medalGetExample.createCriteria();
        if(medalGet.getMedalId()!=null) criteria.andMedalIdEqualTo(medalGet.getMedalId());
        if(medalGet.getUserId()!=null) criteria.andUserIdEqualTo(medalGet.getUserId());
        if(medalGet.getName()!=null) criteria.andNameEqualTo(medalGet.getName());
        if(medalGet.getAccept()!=null) criteria.andAcceptEqualTo(medalGet.getAccept());
        List<MedalGet> medalGets=medalGetMapper.selectByExample(medalGetExample);
        if(medalGets==null||medalGets.size()==0) return null;
        return medalGets;
    }

    public String setMedalGetTrue(String userId,long medalId){
        MedalGetKey medalGetKey=new MedalGetKey();
        medalGetKey.setMedalId(medalId);
        medalGetKey.setUserId(userId);
        MedalGet medalGet=medalGetMapper.selectByPrimaryKey(medalGetKey);
        if(medalGet==null) return "未获得该勋章";
        if(medalGet.getAccept()) return "已经获得的勋章不能再次获得";
        medalGet.setAccept(true);
        medalGetMapper.updateByPrimaryKey(medalGet);
        return "获得成功";
    }
}
