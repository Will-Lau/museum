package museum.museum.Service;

import museum.museum.Entity.Medal;
import museum.museum.Entity.MedalExample;
import museum.museum.Request.MedalRequest;
import museum.museum.Response.MedalResponse;
import museum.museum.dao.MedalMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static museum.museum.UsefulUtils.DozerUtils.mapList;

@Service
public class MedalService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    protected MedalMapper medalMapper;

    //增
    public String insertNewMedal(MedalRequest insertMedalResquest){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(insertMedalResquest.getName());
        if(medalMapper.selectByExample(medalExample)!=null&&medalMapper.selectByExample(medalExample).size()!=0) return "该勋章已存在";
        else {
            Medal medal=dozerMapper.map(insertMedalResquest,Medal.class);
            medalMapper.insertSelective(medal);
            return "增加成功";
        }
    }

    //查
    public MedalResponse getMedal(String name){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(name);
        return dozerMapper.map(medalMapper.selectByExample(medalExample).get(0),MedalResponse.class);
    }

    //查所有
    public List<MedalResponse> getAllMedal(){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andMedalIdIsNotNull();
        return mapList(medalMapper.selectByExample(medalExample),MedalResponse.class);
    }

    //删
    public String deleteMedal(String name){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(name);
        medalMapper.deleteByExample(medalExample);
        if(medalMapper.selectByExample(medalExample)==null||medalMapper.selectByExample(medalExample).size()==0)
            return "删除完成";
        else return  "删除失败，请稍后重试";
    }

    //改
    public String updateMedal(MedalRequest medalRequest){
        MedalExample medalExample=new MedalExample();
        medalExample.createCriteria().andNameEqualTo(medalRequest.getName());
        Medal medal=medalMapper.selectByExample(medalExample).get(0);
        medal.setStar(medalRequest.getStar());
        medalMapper.updateByPrimaryKey(medal);
        return "更新完成";

    }

}
