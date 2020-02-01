package museum.museum.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsertRelicRequest {

    private String name;

    private String time;

    private String size;

    private String kind;

    private String author;

    private String belongTo;

    private String description;

    private String pic;
}
