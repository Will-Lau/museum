package museum.museum;

import museum.museum.Service.QuestionSetService;
import museum.museum.Service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

public class GetOpenIdTest extends MuseumApplicationTests {

    @Autowired
    UserService userService;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;
    @Test
    public void getProcessTest() throws Exception {
        userService.login("043c5a5U1Md1xZ0Co98U1Pxg5U1c5a5A");

    }
}
