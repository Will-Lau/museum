package museum.museum.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedalGetRequest {
    private Long medalId;

    private String name;

    private Boolean accept;
}
