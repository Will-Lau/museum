package museum.museum.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Entity.*;
import museum.museum.Request.GetQuestionsRule;
import museum.museum.Response.QuestionSetResponsePlus;
import museum.museum.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "不需要token就能调用的接口")
@RestController
@RequestMapping("/dev")
public class DevController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionSetService questionSetService;

    @Autowired
    private QsLikeService qsLikeService;

    @Autowired
    private RelicService relicService;

    @Autowired
    private RelicLikeService relicLikeService;

    @Autowired
    private MedalService medalService;

    @Autowired
    private UserService userService;


    @GetMapping("/getQuestions")
    @ApiOperation(value = "根据条件查询问题", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<Question> getQuestions(GetQuestionsRule getQuestionsRule){

        return questionService.getQuestions(getQuestionsRule);
    }


    @GetMapping("/getQuestionSets")
    @ApiOperation(value = "根据条件查询题集", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<QuestionSetResponsePlus> getQuestions( QuestionSet questionSet){

        return questionSetService.getQuestionSets(questionSet);
    }


    @GetMapping("/getMedals")
    @ApiOperation(value = "根据条件查询勋章", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<Medal> getQuestions( Medal medal){

        return medalService.getMedals(medal);
    }

    @GetMapping("/getQsLikes")
    @ApiOperation(value = "根据条件查询题集收藏", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<QsLike> getQsLikes(QsLike qsLike){

        return qsLikeService.getQsLikes(qsLike);
    }


    @GetMapping("/getRelics")
    @ApiOperation(value = "根据条件查询文物", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<Relic> getRelics( Relic relic){

        return relicService.getRelics(relic);
    }


    @GetMapping("/getRelicLikes")
    @ApiOperation(value = "根据条件查询文物收藏", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<RelicLike> getRelicLikes(RelicLike relicLike){

        return relicLikeService.getRelicLikes(relicLike);
    }


    @GetMapping("/getUsers")
    @ApiOperation(value = "根据条件查询用户", notes = "不需要的条件可不填,都不填就获取所有", tags = "Dev")
    public List<User> getUsers(User user){

        return userService.getUsers(user);
    }

    @GetMapping("/getUserId")
    @ApiOperation(value = "根据token获得userId", notes = "userId是User主键，项目实际运行时一般不会暴露给前端；注意这里的token不是请求头而是参数。", tags = "Dev")
    public String getUsers(String token){

        return userService.getUserId(token);
    }
}
