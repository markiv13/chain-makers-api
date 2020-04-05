package chainmakers.supplychain.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RestProduct {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private List<RestProduct> components;

    @JsonProperty
    private String instruction;

    @JsonProperty
    private boolean endProduct;

    public RestProduct() {
    }

    public RestProduct(Long id, String name, String description, List<RestProduct> components, String instruction, boolean endProduct) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.components = components;
        this.instruction = instruction;
        this.endProduct = endProduct;
    }
}
