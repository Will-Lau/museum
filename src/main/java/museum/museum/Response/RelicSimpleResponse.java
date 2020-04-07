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
    private Long rId;

    private String name;

    private String time;

    private String size;

    private String kind;

    private String author;

    private String belongTo;

    private String description;

    private String pic;

    private Date likeTime;
}
