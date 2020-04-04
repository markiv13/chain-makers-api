package chainmakers.supplychain.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RestD3Graph {

    @JsonProperty
    private String graphName;

    @JsonProperty
    private List<RestVertex> restVertices;

    @JsonProperty
    private List<RestEdge> restEdges;

    public RestD3Graph(){}

    public RestD3Graph(String graphName, List<RestVertex> restVertices, List<RestEdge> restEdges) {
        this.graphName = graphName;
        this.restVertices = restVertices;
        this.restEdges = restEdges;
    }
}
