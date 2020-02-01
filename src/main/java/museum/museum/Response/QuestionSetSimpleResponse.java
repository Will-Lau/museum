package museum.museum.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSetSimpleResponse {
    private Long qsId;

    private Date finishTime;

    private String status;

    private String kind;

    private Integer degree;

    private Date likeTime;

}
