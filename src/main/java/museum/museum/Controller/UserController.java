package museum.museum.Controller;

import io.swagger.annotations.ApiOperation;
import museum.museum.Entity.Question;
import museum.museum.Response.UserResponse;
import museum.museum.Response.UserTokenResponse;
import museum.museum.Service.UserService;
import museum.museum.UsefulUtils.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Method method;

    @GetMapping("/login")
    @ApiOperation(value = "登录", notes = "输入code返回token,得到的token在后续请求中放入请求头用于验证身份\n\rtoken在一定时间内有效，过期需重新登录", tags = "User")
    public UserTokenResponse login(String code) throws Exception {

        return userService.login(code);
    }

    @PutMapping("/updateAvatar")
    @ApiOperation(value = "修改头像", notes = "输入图片的url", tags = "User")
    public String updateAvatar(@RequestHeader String token, String pic){
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return userService.updateAvatar(userId,pic);
    }

    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获得用户信息", notes = "获得用户信息", tags = "User")
    public UserResponse getUserInfo(@RequestHeader String token) {
        System.out.println(token);
        String userId= method.getUseridByToken(token);
        if(userId==null) return null;
        return userService.getUserInfo(userId);
    }


}
