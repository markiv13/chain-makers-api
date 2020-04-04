package chainmakers.supplychain.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import scala.Serializable;

public class RestEdge implements Serializable {

    @JsonProperty
    @Nullable
    private Long id;

    @JsonProperty
    private Long source;

    @JsonProperty
    private Long target;

    /**Empty constructor needed for rest*/
    public RestEdge(){}

    public RestEdge(@Nullable Long id, Long source, Long target) {
        this.id = id;
        this.source = source;
        this.target = target;
    }
}
