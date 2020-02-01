package museum.museum.Service;

import museum.museum.dao.RelicMapper;
import museum.museum.Entity.Relic;
import museum.museum.Request.InsertRelicRequest;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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



}
