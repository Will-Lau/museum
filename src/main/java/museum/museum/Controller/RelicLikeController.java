package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Request.InsertLIkeRelicRequest;
import museum.museum.Request.InsertLikeQuestionSetRequest;
import museum.museum.Response.QuestionSetSimpleResponse;
import museum.museum.Response.RelicSimpleResponse;
import museum.museum.Service.QsLikeService;
import museum.museum.Service.RelicLikeService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relicLike")
public class RelicLikeController {

    @Autowired
    private RelicLikeService relicLikeService;

    @Autowired
    private Method method;

    @PostMapping("/insertRelicLike")
    @ApiOperation(value = "收藏文物", notes = "收藏文物", tags = "RelicLike")
    public String insertRelicLike(@RequestHeader String token, @RequestBody InsertLIkeRelicRequest insertLIkeRelicRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return relicLikeService.insertLikeRelic(userId,insertLIkeRelicRequest);
    }

    @DeleteMapping("/deleteRelicLike")
    @ApiOperation(value = "取消收藏文物", notes = "取消收藏一个文物", tags = "RelicLike")
    public String deleteRelicLike(@RequestHeader String token,long rId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return relicLikeService.deleteLikeRelic(userId,rId);
    }

    @LoginRequired
    @GetMapping("/getAllRelicLike")
    @ApiOperation(value = "获得所有文物收藏信息", notes = "获得所有文物收藏信息", tags = "RelicLike")
    public List<RelicSimpleResponse> getAllRelicLike(@RequestHeader String token){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return relicLikeService.getLikeRelic(userId);
    }
}
