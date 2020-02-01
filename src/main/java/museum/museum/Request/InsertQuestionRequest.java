package museum.museum.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsertQuestionRequest {

    private String kind;
    private int degree;
    private String content;
    private String contentImage;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionAImage;
    private String optionBImage;
    private String optionCImage;
    private String optionDImage;
    private String answer;
    private String analysis;


}
