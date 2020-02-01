package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Entity.Question;
import museum.museum.Request.InsertQuestionRequest;
import museum.museum.Request.JudgeQuestionRequest;
import museum.museum.Service.QuestionMatchService;
import museum.museum.Service.QuestionService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionMatchService questionMatchService;

    @Autowired
    private Method method;

    @PostMapping("/insertQuestion")
    @ApiOperation(value = "添加问题", notes = "添加问题", tags = "Question")
    public String insertQuestion(@RequestHeader String token,@RequestBody InsertQuestionRequest insertQuestionRequest){

        return questionService.insertQuestion(insertQuestionRequest);
    }

    @DeleteMapping("/deleteQuestion")
    @ApiOperation(value = "删除问题", notes = "输入问题qId", tags = "Question")
    public String deleteQuestion(@RequestHeader String token,long qId){

        return questionService.deleteQuestion(qId);
    }

    @PutMapping("/updateQuestion")
    @ApiOperation(value = "修改问题", notes = "只需要qId和需要修改的字段，其余字段置空即可。", tags = "Question")
    public String updateQuestion(@RequestHeader String token,Question question){

        return questionService.updateQuestion(question);
    }

    @LoginRequired
    @GetMapping("/getQuestion")
    @ApiOperation(value = "获得问题", notes = "输入问题qId", tags = "Question")
    public Question getQuestion(@RequestHeader String token,long qId){

        return questionService.getQuestion(qId);
    }

    @LoginRequired
    @PutMapping("/submitQuestion")
    @ApiOperation(value = "判断做题结果", notes = "", tags = "Question")
    public String updateQuestion(@RequestHeader String token,@RequestBody JudgeQuestionRequest judgeQuestionRequest){

        return questionMatchService.updateQuestionMatchGrade(judgeQuestionRequest);
    }



}
