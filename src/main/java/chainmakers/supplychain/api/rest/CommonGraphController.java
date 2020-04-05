package chainmakers.supplychain.api.rest;

import chainmakers.supplychain.api.model.RestD3Graph;
import chainmakers.supplychain.api.model.RestEdge;
import chainmakers.supplychain.api.model.RestProduct;
import chainmakers.supplychain.api.model.RestVertex;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @ApiOperation(value = "get masks supply chain", notes = "get graph from mask supply chain")
    @GetMapping("/products")
    public List<RestProduct> getEndProducts() {
        return List.of(
                new RestProduct(
                        1L, "Mask", "Breathing mask", List.of(
                                new RestProduct(10L, "MaskComp1", "textile cuts", List.of(), "cutting instruction", false),
                                new RestProduct(12L, "MaskComp2", "strips", Collections.emptyList(), "cutting instruction", false),
                                new RestProduct(13L, "MaskComp3", "buttons", Collections.emptyList(), "attach instruction", false)),
                        "assemble parts", true),
                new RestProduct(
                        2L, "Apron", "Protecting apron", List.of(
                        new RestProduct(10L, "main part", "textile cuts", List.of(), "cutting instruction", false)),
                        "assemble parts", true)
        );
    }

    @ApiOperation(value = "get masks supply chain", notes = "get graph from mask supply chain")
    @GetMapping("/products/{compId}")
    public RestProduct getComponent(@PathVariable Long compId) {
        return new RestProduct(
                        1L, "Mask", "Breathing mask", List.of(
                        new RestProduct(10L, "MaskComp1", "textile cuts", List.of(), "cutting instruction", false),
                        new RestProduct(12L, "MaskComp2", "strips", Collections.emptyList(), "cutting instruction", false),
                        new RestProduct(13L, "MaskComp3", "buttons", Collections.emptyList(), "attach instruction", false)),
                        "assemble parts", true);

    }

    @ApiOperation(value = "get masks supply chain", notes = "get graph from mask supply chain")
    @PostMapping("/products")
    public RestProduct addComponent(@RequestBody RestProduct restProduct) {
        return restProduct;
    }

    private RestD3Graph testGraph() {

        RestVertex v1 = new RestVertex(1L, 1L, "Vertex1", 200.0, 200.0);
        RestVertex v2 = new RestVertex(2L, 2L, "Vertex2", 300.0, 300.0);
        RestEdge e1 = new RestEdge(1L, 2L, 1L);

        return new RestD3Graph("masks-supply-chain", List.of(v1,v2), List.of(e1));
    }
}
