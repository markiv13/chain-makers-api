package chainmakers.supplychain.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;
import scala.Serializable;

public class RestVertex implements Serializable{

    @JsonProperty
    @Nullable
    private Long persistenceId;

    @JsonProperty
    @Nullable
    private Long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private double fx;

    @JsonProperty
    private double fy;


    /**Empty constructor needed for rest*/
    public RestVertex(){}

    public RestVertex(@Nullable Long persistenceId, @Nullable Long id, String title, double fx, double fy) {
        this.persistenceId = persistenceId;
        this.id = id;
        this.title = title;
        this.fx = fx;
        this.fy = fy;
    }
}
