package museum.museum;

import museum.museum.Service.RelicService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RelicSearchTest {

    @Autowired
    private RelicService relicService;

    @Test
    public void SearchTest() throws Exception {
        relicService.searchRelic("str");

    }
}
