package museum.museum;

import museum.museum.Entity.QuestionSet;
import museum.museum.Response.QuestionSetProcessResponse;
import museum.museum.Service.QuestionSetService;
import museum.museum.dao.QuestionMapper;
import museum.museum.dao.QuestionSetMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class ProcessTest extends MuseumApplicationTests {
    @Autowired
    QuestionSetService questionSetService;

    @Autowired
    QuestionSetMapper questionSetMapper;

    @Test
    public void getProcessTest(){

        List<QuestionSet> q= questionSetMapper.getProgressByKind("oEy_F5B8iyDmPDnZp2npc3aEBHFk","成都博物馆");
        for(QuestionSet i:q){
            System.out.print(i.getKind()+":"+i.getDegree());
        }
    }
}
