package museum.museum.UsefulUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Service
public class Method {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static String getRandomUUid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String uploadPic(MultipartFile file){
        if(file.isEmpty()){
            return "上传文件为空";
        }
        String url;

        String fileName=file.getOriginalFilename();
        fileName=getRandomUUid()+"_"+fileName;
        String path="./fileUpload/"+fileName;
        File destination =new File(path);
        if(destination.exists()){
            return "文件已经存在";
        }

        if(!destination.getParentFile().exists()){
            destination.getParentFile().mkdir();
        }
        try{

            file.transferTo(destination.getAbsoluteFile());
            url="http://120.55.161.129:8080/images/"+fileName;
            return url;

        } catch (IOException e) {
            e.printStackTrace();
            return "上传错误";
        }
    }

    public String getUseridByToken(String token){
        String userId=stringRedisTemplate.opsForValue().get(token);

        if(userId==null) return null;
        else return userId;
    }
}
