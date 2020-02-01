package museum.museum.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JudgeQuestionRequest {
    private long qsId;
    private long qId;
    private String userAnswer;

}
