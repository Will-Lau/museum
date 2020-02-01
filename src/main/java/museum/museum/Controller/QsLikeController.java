package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Request.InsertLikeQuestionSetRequest;
import museum.museum.Request.MedalRequest;
import museum.museum.Response.MedalResponse;
import museum.museum.Response.QuestionSetSimpleResponse;
import museum.museum.Service.MedalService;
import museum.museum.Service.QsLikeService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qsLike")
public class QsLikeController {

    @Autowired
    private QsLikeService qsLikeService;


    @Autowired
    private Method method;

    @PostMapping("/insertQsLike")
    @ApiOperation(value = "收藏题集", notes = "收藏题集", tags = "QsLike")
    public String insertQsLike(@RequestHeader String token, @RequestBody InsertLikeQuestionSetRequest insertLikeQuestionSetRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return qsLikeService.insertLikeQuestion(userId,insertLikeQuestionSetRequest);
    }

    @DeleteMapping("/deleteQsLike")
    @ApiOperation(value = "取消收藏题集", notes = "取消收藏一个题集", tags = "QsLike")
    public String deleteQsLike(@RequestHeader String token,long qsId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return qsLikeService.deleteLikeQuestion(userId,qsId);
    }

    @LoginRequired
    @GetMapping("/getAllQsLike")
    @ApiOperation(value = "获得所有题集收藏信息", notes = "获得所有题集收藏信息", tags = "QsLike")
    public List<QuestionSetSimpleResponse> getAllQsLike(@RequestHeader String token){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return qsLikeService.getLikeQuestionSet(userId);
    }
}
