package museum.museum.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String avatar;
    private Integer QsFinish;
    private Integer QsTotalFinish;
    private Long starlet;
    private Double accuracy;
    private Integer transpondTime;
}
