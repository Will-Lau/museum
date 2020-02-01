package museum.museum.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import museum.museum.Entity.Question;

import java.util.List;
import java.util.Queue;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSetResponse {
    private long qsId;
    private List<QuestionResponse> questionResponses;
}
