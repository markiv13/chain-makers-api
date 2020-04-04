package chainmakers.supplychain.api.rest;

import chainmakers.supplychain.api.model.RestD3Graph;
import chainmakers.supplychain.api.model.RestEdge;
import chainmakers.supplychain.api.model.RestVertex;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Graph Controller")
@CrossOrigin
public class CommonGraphController {

    @ApiOperation(value = "get masks supply chain", notes = "get graph from mask supply chain")
    @GetMapping("/graphs/masks")
    public RestD3Graph getMasksSupplyChain() {
        return testGraph();
    }

    private RestD3Graph testGraph() {

        RestVertex v1 = new RestVertex(1L, 1L, "Vertex1", 200.0, 200.0);
        RestVertex v2 = new RestVertex(2L, 2L, "Vertex2", 300.0, 300.0);
        RestEdge e1 = new RestEdge(1L, 2L, 1L);

        return new RestD3Graph("masks-supply-chain", List.of(v1,v2), List.of(e1));
    }
}
