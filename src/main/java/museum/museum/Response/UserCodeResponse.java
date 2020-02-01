package museum.museum.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import museum.museum.UsefulUtils.WxError;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCodeResponse extends WxError {
    private String openid;
    private String session_key;
    private String unionid;

    @Override
    public String toString(){
        return "UserCode{"+
                "openid='" + openid + '\'' +
                ", session_key='" + session_key + '\'' +
                ", unionid='" + unionid + '\'' +
                '}' + "  " + super.toString();

    }
}
