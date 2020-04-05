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

    @JsonProperty
    private String type;

    @JsonProperty
    private String icon;

    @JsonProperty
    private Long requiredCapacity;

    @JsonProperty
    private Long availableCapacity;

    @JsonProperty
    private String instruction;


    /**Empty constructor needed for rest*/
    public RestVertex(){}

    public RestVertex(@Nullable Long persistenceId, @Nullable Long id, String title, double fx, double fy) {
        this.persistenceId = persistenceId;
        this.id = id;
        this.title = title;
        this.fx = fx;
        this.fy = fy;
    }

    public RestVertex(@Nullable Long id, String title, double fx, double fy, String type,
                      String icon, Long requiredCapacity, Long availableCapacity, String instruction) {

        this.id = id;
        this.title = title;
        this.fx = fx;
        this.fy = fy;
        this.type = type;
        this.icon = icon;
        this.requiredCapacity = requiredCapacity;
        this.availableCapacity = availableCapacity;
        this.instruction = instruction;
    }
}
