package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Request.CreateQuestionSetRequest;
import museum.museum.Response.QuestionSetResponse;
import museum.museum.Response.QuestionSetProcessResponse;
import museum.museum.Service.QuestionSetService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionSet")
public class QuestionSetController {
    @Autowired
    private QuestionSetService questionSetService;

    @Autowired
    private Method method;

    @LoginRequired
    @PostMapping("/createQuestion")
    @ApiOperation(value = "创建题集", notes = "输入类别和难度及userId，组卷\r\nnum为题目数量，返回值不包括答案和解析", tags = "QuestionSet")
    public QuestionSetResponse createQuestion(@RequestHeader String token,@RequestBody CreateQuestionSetRequest createQuestionSetRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return questionSetService.createQuestionSet(userId,createQuestionSetRequest);
    }


    @DeleteMapping("/deleteQuestionSet")
    @ApiOperation(value = "删除题集", notes = "输入qsId和userId", tags = "QuestionSet")
    public String deleteQuestionSet(@RequestHeader String token,long qsId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return questionSetService.deleteQuestionSet(qsId,userId);
    }

    @LoginRequired
    @PutMapping("/quitQuestionSet")
    @ApiOperation(value = "放弃做一个题集", notes = "输入qsId和userId", tags = "QuestionSet")
    public String quitQuestionSet(@RequestHeader String token,long qsId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return questionSetService.quitQuestionSet(qsId,userId);
    }

    @LoginRequired
    @GetMapping("/getQuestionSet")
    @ApiOperation(value = "获得题集", notes = "输入qId和userId，做了的题会给出结果、答案和解析", tags = "QuestionSet")
    public QuestionSetResponse getQuestionSet(@RequestHeader String token,long qId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return questionSetService.getQuestionSet(qId,userId);
    }


    @LoginRequired
    @GetMapping("/getProgress")
    @ApiOperation(value = "获得做题进度", notes = "输入userId，获得进度", tags = "QuestionSet")
    public List<QuestionSetProcessResponse> getProgress(@RequestHeader String token){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return questionSetService.getQuestionSetProgress(userId);
    }


    @LoginRequired
    @PutMapping("/completeQuestionSet")
    @ApiOperation(value = "该题集做完", notes = "在一个题集完成后，返回正确率", tags = "QuestionSet")
    public double completeQuestionSet(@RequestHeader String token,long qsId){

        return questionSetService.updateQuestionStatusToFinished(qsId);
    }

}
