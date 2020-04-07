package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Entity.Question;
import museum.museum.Request.InsertQuestionRequest;
import museum.museum.Request.MedalRequest;
import museum.museum.Response.MedalResponse;
import museum.museum.Service.MedalService;
import museum.museum.Service.UserService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medal")
public class MedalController {

    @Autowired
    private MedalService medalService;

    @Autowired
    private Method method;

    @PostMapping("/insertMedal")
    @ApiOperation(value = "添加勋章", notes = "添加勋章", tags = "Medal")
    public String insertMedal(@RequestHeader String token, @RequestBody MedalRequest medalRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return medalService.insertNewMedal(medalRequest);
    }

    @LoginRequired
    @GetMapping("/getAllMedal")
    @ApiOperation(value = "获得所有勋章信息", notes = "获得所有勋章信息", tags = "Medal")
    public List<MedalResponse> getAllMedal(@RequestHeader String token){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return medalService.getAllMedal();
    }

    @LoginRequired
    @GetMapping("/getMedal")
    @ApiOperation(value = "根据勋章名获得勋章信息", notes = "根据勋章名获得勋章信息", tags = "Medal")
    public MedalResponse getMedal(@RequestHeader String token,String name){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return medalService.getMedal(name);
    }


    @DeleteMapping("/deleteMedal")
    @ApiOperation(value = "删除勋章", notes = "删除一个勋章", tags = "Medal")
    public String deleteMedal(@RequestHeader String token,String name){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return medalService.deleteMedal(name);
    }

    @PutMapping("/updateMedal")
    @ApiOperation(value = "修改勋章", notes = "只需要token和需要修改的字段，其余字段置空即可。", tags = "Medal")
    public String updateMedal(@RequestHeader String token,MedalRequest medalRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return medalService.updateMedal(medalRequest);
    }
}
