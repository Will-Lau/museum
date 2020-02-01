package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Request.InsertLIkeRelicRequest;
import museum.museum.Response.StarletRuleResponse;
import museum.museum.Service.RelicLikeService;
import museum.museum.Service.StarletService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.Nullable;

@RestController
@RequestMapping("/starlet")
public class StarletController {
    @Autowired
    private StarletService starletService;

    @Autowired
    private Method method;

    @PutMapping("/updateRule")
    @ApiOperation(value = "修改获得不同数量小星星的正确率要求", notes = "不修改的可以置空", tags = "Starlet")
    public String updateRule(@RequestHeader String token,  Double oneStar, Double twoStar, Double threeStar){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;


            return starletService.setStarRule(oneStar,twoStar,threeStar);
    }

    @GetMapping("/getRule")
    @ApiOperation(value = "获得当前规则", notes = "返回获得不同数量小星星的正确率要求规则", tags = "Starlet")
    public StarletRuleResponse getRule(@RequestHeader String token){

        return starletService.getRule();
    }
}
