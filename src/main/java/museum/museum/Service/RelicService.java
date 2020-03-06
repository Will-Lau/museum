package museum.museum.Service;

import museum.museum.Comparator.RelicDescriptionComparator;
import museum.museum.Entity.Question;
import museum.museum.Entity.QuestionExample;
import museum.museum.Entity.RelicExample;
import museum.museum.Request.GetQuestionsRule;
import museum.museum.UsefulUtils.TempRelic;
import museum.museum.dao.RelicMapper;
import museum.museum.Entity.Relic;
import museum.museum.Request.InsertRelicRequest;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static museum.museum.UsefulUtils.DozerUtils.mapList;
import static museum.museum.UsefulUtils.Method.KMPSearch;
import static museum.museum.UsefulUtils.Method.getMatchingRate;

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
        if(relic.getName()!=null) criteria.andNameLike("%"+relic.getName()+"%");
        if(relic.getTime()!=null) criteria.andTimeLike("%"+relic.getTime()+"%");
        if(relic.getSize()!=null) criteria.andSizeLike("%"+relic.getSize()+"%");
        if(relic.getKind()!=null) criteria.andKindLike("%"+relic.getKind()+"%");
        if(relic.getAuthor()!=null) criteria.andAuthorLike("%"+relic.getAuthor()+"%");
        if(relic.getBelongTo()!=null) criteria.andBelongToLike("%"+relic.getBelongTo()+"%");
        if(relic.getDescription()!=null) criteria.andDescriptionLike(relic.getDescription());
        if(relic.getPic()!=null) criteria.andPicEqualTo(relic.getPic());
        List<Relic> relics=relicMapper.selectByExample(relicExample);
        if(relics==null||relics.size()==0) return null;
        else return relics;

    }

    //搜索
    public List<Relic> searchRelic(String word){

        //先搜名字
        RelicExample relicExample1=new RelicExample();
        relicExample1.createCriteria().andNameLike("%"+word+"%");
        List<Relic> relics1=relicMapper.selectByExample(relicExample1);
        List<TempRelic> tempRelics1=mapList(relics1,TempRelic.class);
        for(TempRelic item:tempRelics1){
            item.setTempValue(getMatchingRate(word,item.getName()));
        }
        Collections.sort(tempRelics1,new RelicDescriptionComparator());
        List<Relic> sortRelics1=mapList(tempRelics1,Relic.class);
        Set<Relic> relicSortedSet1=new LinkedHashSet<>(sortRelics1);

        //再搜年代
        RelicExample relicExample2=new RelicExample();
        relicExample2.createCriteria().andTimeLike("%"+word+"%");
        List<Relic> relics2=relicMapper.selectByExample(relicExample2);
        List<TempRelic> tempRelics2=mapList(relics2,TempRelic.class);
        for(TempRelic item:tempRelics2){
            item.setTempValue(getMatchingRate(word,item.getTime()));
        }
        Collections.sort(tempRelics2,new RelicDescriptionComparator());
        List<Relic> sortRelics2=mapList(tempRelics2,Relic.class);
        Set<Relic> relicSortedSet2=new LinkedHashSet<>(sortRelics2);
        relicSortedSet1.addAll(relicSortedSet2);

        //然后搜尺寸
        RelicExample relicExample3=new RelicExample();
        relicExample3.createCriteria().andSizeLike("%"+word+"%");
        List<Relic> relics3=relicMapper.selectByExample(relicExample3);
        List<TempRelic> tempRelics3=mapList(relics3,TempRelic.class);
        for(TempRelic item:tempRelics3){
            item.setTempValue(getMatchingRate(word,item.getSize()));
        }
        Collections.sort(tempRelics3,new RelicDescriptionComparator());
        List<Relic> sortRelics3=mapList(tempRelics3,Relic.class);
        Set<Relic> relicSortedSet3=new LinkedHashSet<>(sortRelics3);
        relicSortedSet1.addAll(relicSortedSet3);

        //然后搜类别
        RelicExample relicExample4=new RelicExample();
        relicExample4.createCriteria().andKindLike("%"+word+"%");
        List<Relic> relics4=relicMapper.selectByExample(relicExample4);
        List<TempRelic> tempRelics4=mapList(relics4,TempRelic.class);
        for(TempRelic item:tempRelics4){
            item.setTempValue(getMatchingRate(word,item.getKind()));
        }
        Collections.sort(tempRelics4,new RelicDescriptionComparator());
        List<Relic> sortRelics4=mapList(tempRelics4,Relic.class);
        Set<Relic> relicSortedSet4=new LinkedHashSet<>(sortRelics4);
        relicSortedSet1.addAll(relicSortedSet4);

        //然后搜作者
        RelicExample relicExample5=new RelicExample();
        relicExample5.createCriteria().andAuthorLike("%"+word+"%");
        List<Relic> relics5=relicMapper.selectByExample(relicExample5);
        List<TempRelic> tempRelics5=mapList(relics5,TempRelic.class);
        for(TempRelic item:tempRelics5){
            item.setTempValue(getMatchingRate(word,item.getAuthor()));
        }
        Collections.sort(tempRelics5,new RelicDescriptionComparator());
        List<Relic> sortRelics5=mapList(tempRelics5,Relic.class);
        Set<Relic> relicSortedSet5=new LinkedHashSet<>(sortRelics5);
        relicSortedSet1.addAll(relicSortedSet5);

        //搜归属
        RelicExample relicExample6=new RelicExample();
        relicExample6.createCriteria().andBelongToLike("%"+word+"%");
        List<Relic> relics6=relicMapper.selectByExample(relicExample6);
        List<TempRelic> tempRelics6=mapList(relics6,TempRelic.class);
        for(TempRelic item:tempRelics6){
            item.setTempValue(getMatchingRate(word,item.getBelongTo()));
        }
        Collections.sort(tempRelics6,new RelicDescriptionComparator());
        List<Relic> sortRelics6=mapList(tempRelics6,Relic.class);
        Set<Relic> relicSortedSet6=new LinkedHashSet<>(sortRelics6);
        relicSortedSet1.addAll(relicSortedSet6);

        //最后搜描述
        RelicExample relicExample7=new RelicExample();
        relicExample7.createCriteria().andDescriptionLike("%"+word+"%");
        List<Relic> relics7=relicMapper.selectByExample(relicExample7);
        List<TempRelic> tempRelics7=mapList(relics7,TempRelic.class);
        for(TempRelic item:tempRelics7){
            item.setTempValue(KMPSearch(word,item.getDescription()));
        }
        Collections.sort(tempRelics7,new RelicDescriptionComparator());
        List<Relic> sortRelics7=mapList(tempRelics7,Relic.class);
        Set<Relic> relicSortedSet7=new LinkedHashSet<>(sortRelics7);
        relicSortedSet1.addAll(relicSortedSet7);


        List<Relic> searchResult=new ArrayList<>(relicSortedSet1);

        return searchResult;


    }


}
