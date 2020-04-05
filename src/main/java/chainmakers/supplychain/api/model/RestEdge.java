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

    @JsonProperty
    private Long requiredCapacity;

    @JsonProperty
    private Long availableCapacity;

    /**Empty constructor needed for rest*/
    public RestEdge(){}

    public RestEdge(@Nullable Long id, Long source, Long target) {
        this.id = id;
        this.source = source;
        this.target = target;
    }

    public RestEdge(@Nullable Long id, Long source, Long target, Long requiredCapacity, Long availableCapacity) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.requiredCapacity = requiredCapacity;
        this.availableCapacity = availableCapacity;
    }
}
