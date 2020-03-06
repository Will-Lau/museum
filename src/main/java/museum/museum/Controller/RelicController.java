package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Annotation.LoginRequired;
import museum.museum.Entity.Relic;
import museum.museum.Request.InsertRelicRequest;
import museum.museum.Request.MedalRequest;
import museum.museum.Response.MedalResponse;
import museum.museum.Service.QuestionSetService;
import museum.museum.Service.RelicService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relic")
public class RelicController {

    @Autowired
    private RelicService relicService;

    @Autowired
    private Method method;

    @PostMapping("/insertRelic")
    @ApiOperation(value = "添加文物", notes = "添加文物", tags = "Relic")
    public String insertRelic(@RequestHeader String token, @RequestBody InsertRelicRequest insertRelicRequest){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return relicService.insertRelic(insertRelicRequest);
    }


    @LoginRequired
    @GetMapping("/getRelic")
    @ApiOperation(value = "根据rId获得文物章信息", notes = "根据rId获得文物信息", tags = "Relic")
    public Relic getRelic(@RequestHeader String token, long rId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return relicService.getRelic(rId);
    }


    @GetMapping("/searchRelic")
    @ApiOperation(value = "搜索", notes = "搜索文物", tags = "Relic")
    public List<Relic> searchRelic(String word){
        //String userId= method.getUseridByToken(token);
        //if(userId==null) return null;
        return relicService.searchRelic(word);
    }


    @DeleteMapping("/deleteRelic")
    @ApiOperation(value = "删除文物", notes = "删除一个文物", tags = "Relic")
    public String deleteRelic(@RequestHeader String token,long rId){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return relicService.deleteRelic(rId);
    }

    @PutMapping("/updateRelic")
    @ApiOperation(value = "修改文物信息", notes = "只需要token，rId和需要修改的字段，其余字段置空即可。", tags = "Relic")
    public String updateRelic(@RequestHeader String token,Relic relic){

        return relicService.updateRelic(relic);
    }
}
