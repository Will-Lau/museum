package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Entity.MedalGet;
import museum.museum.Request.MedalGetRequest;
import museum.museum.Response.MedalResponse;
import museum.museum.Service.MedalGetService;
import museum.museum.Service.MedalService;
import museum.museum.UsefulUtils.Method;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/medalGet")
public class MedalGetController {
    @Resource
    private MedalGetService medalGetService;

    @Resource
    protected Mapper dozerMapper;

    @Autowired
    private Method method;

    @LoginRequired
    @GetMapping("/getMedalGets")
    @ApiOperation(value = "根据条件查询勋章获得信息", notes = "条件不需要都填", tags = "MedalGet")
    public List<MedalGet> getMedalGets(@RequestHeader String token, MedalGetRequest medalGetRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        MedalGet medalGet=dozerMapper.map(medalGetRequest,MedalGet.class);
        medalGet.setUserId(userId);
        return medalGetService.getMedalGets(medalGet);
    }

    @LoginRequired
    @PutMapping("/acceptMedalGet")
    @ApiOperation(value = "手动确认领取勋章", notes = "手动确认领取勋章", tags = "MedalGet")
    public String acceptMedalGet(@RequestHeader String token, long medalId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return medalGetService.setMedalGetTrue(userId,medalId);
    }

}
