package museum.museum;

import museum.museum.Service.QuestionSetService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class ProcessTest extends MuseumApplicationTests {
    @Autowired
    QuestionSetService questionSetService;

    @Test
    public void getProcessTest(){
        questionSetService.getQuestionSetProgress("1");
    }
}
