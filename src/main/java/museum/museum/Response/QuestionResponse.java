package museum.museum.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Long qId;

    private String kind;

    private Integer degree;

    private String content;

    private String contentImage;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionAImage;

    private String optionBImage;

    private String optionCImage;

    private String userAnswer;

    private String grade;

    private String answer;

    private String analysis;
}
