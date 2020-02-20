package museum.museum.Service;

import museum.museum.Entity.Question;
import museum.museum.Entity.QuestionExample;
import museum.museum.Entity.RelicExample;
import museum.museum.Request.GetQuestionsRule;
import museum.museum.dao.RelicMapper;
import museum.museum.Entity.Relic;
import museum.museum.Request.InsertRelicRequest;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RelicService {

    @Resource
    protected Mapper dozerMapper;

    @Autowired
    protected RelicMapper relicMapper;

    //新建relic，未做防错
    public String insertRelic(InsertRelicRequest insertRelicRequest){
        Relic relic=dozerMapper.map(insertRelicRequest,Relic.class);
        relicMapper.insertSelective(relic);
        return "添加完成";
    }

    //删除文物
    public String deleteRelic(long rId){
        if(relicMapper.selectByPrimaryKey(rId)==null) return "该文物不存在";
        else {
            relicMapper.deleteByPrimaryKey(rId);
            if(relicMapper.selectByPrimaryKey(rId)==null) return "删除成功";
            else return "删除失败";
        }
    }

    //修改文物
    public String updateRelic(Relic relic){
        if(relicMapper.selectByPrimaryKey(relic.getrId())==null) return "该文物不存在";
        else {
            relicMapper.updateByPrimaryKeySelective(relic);
            return "修改完成";
        }
    }

    //得到文物信息
    public Relic getRelic(long rId){
        return relicMapper.selectByPrimaryKey(rId);
    }


    //根据条件查询文物
    public List<Relic> getRelics(Relic relic){
        RelicExample relicExample =new RelicExample();
        RelicExample.Criteria criteria=relicExample.createCriteria();
        if(relic.getrId()!=null) criteria.andRIdEqualTo(relic.getrId());
        if(relic.getName()!=null) criteria.andNameLike(""+relic.getName()+"");
        if(relic.getTime()!=null) criteria.andTimeLike(""+relic.getTime()+"");
        if(relic.getSize()!=null) criteria.andSizeLike(""+relic.getSize()+"");
        if(relic.getKind()!=null) criteria.andKindLike(""+relic.getKind()+"");
        if(relic.getAuthor()!=null) criteria.andAuthorLike(""+relic.getAuthor()+"");
        if(relic.getBelongTo()!=null) criteria.andBelongToLike(""+relic.getBelongTo()+"");
        if(relic.getDescription()!=null) criteria.andDescriptionLike(relic.getDescription());
        if(relic.getPic()!=null) criteria.andPicEqualTo(relic.getPic());
        List<Relic> relics=relicMapper.selectByExample(relicExample);
        if(relics==null||relics.size()==0) return null;
        else return relics;

    }



}
