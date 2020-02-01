package museum.museum.Service;

import museum.museum.Response.StarletRuleResponse;
import org.springframework.stereotype.Service;

@Service
public class StarletService {

    public static Double OneStar=0.6;
    public static Double TwoStar=0.8;
    public static Double ThreeStar=1.0;


    public String setStarRule(Double oneStar,Double twoStar,Double threeStar){
        if(oneStar!=null) OneStar=oneStar;
        if(twoStar!=null) TwoStar=twoStar;
        if(threeStar!=null) ThreeStar=threeStar;
        return "修改完成";
    }

    public StarletRuleResponse getRule(){
        StarletRuleResponse starletRuleResponse=StarletRuleResponse.builder()
                                                                   .oneStar(OneStar)
                                                                   .twoStar(TwoStar)
                                                                   .threeStar(ThreeStar)
                                                                   .build();
        return starletRuleResponse;
    }
}
