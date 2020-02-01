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
public class RelicSimpleResponse {
    private long rId;

    private String name;

    private String pic;
    private Date likeTime;
}
