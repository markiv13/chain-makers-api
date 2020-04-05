package chainmakers.supplychain.api.rest;

import chainmakers.supplychain.api.model.RestD3Graph;
import chainmakers.supplychain.api.model.RestEdge;
import chainmakers.supplychain.api.model.RestProduct;
import chainmakers.supplychain.api.model.RestVertex;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.Nullable;
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
        return testGraph2();
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

        RestVertex v1 = new RestVertex(1L, 1L, "Mask N95", 400.0, 400.0);
        RestVertex v2 = new RestVertex(2L, 2L, "Main Fiber Unit", 200.0, 200.0);
        RestVertex v3 = new RestVertex(3L, 3L, "Front Nose Bar", 200.0, 400.0);
        RestVertex v4 = new RestVertex(4L, 4L, "Back Nose Bar", 200.0, 600.0);
        RestVertex v5 = new RestVertex(5L, 5L, "Tightening Strips", 100.0, 400.0);
        RestVertex v6 = new RestVertex(6L, 6L, "Anders", 300.0, 50.0);
        RestEdge e1 = new RestEdge(1L, 2L, 1L);
        RestEdge e2 = new RestEdge(2L, 5L, 2L);
        RestEdge e3 = new RestEdge(3L, 3L, 1L);
        RestEdge e4 = new RestEdge(4L, 4L, 1L);
        RestEdge e5 = new RestEdge(5L, 6L, 2L);

        return new RestD3Graph("masks-supply-chain", List.of(v1,v2, v3, v4, v5, v6), List.of(e1, e2, e3, e4, e5));
    }

    private RestD3Graph testGraph2() {

        RestVertex v = new RestVertex(0L, "Karolinska Sjukhuset", 600.0, 400.0, "CONSUMER",
                "n95.jpg", 0L, 0L, "");

        RestVertex v1 = new RestVertex(1L,"N95 Mask", 400.0, 400.0, "ACTIVITY",
                "n95.jpg", 10000L, 2000L, "https://docs.google.com/document/d/1SGh4GStsBs3gYS_tbB017lVFNSfC1aVbbUiCtN9fZlA/edit#heading=h.j8gffz8wky6d");
        RestVertex v2 = new RestVertex(2L, "N95 Fiber Unit", 200.0, 200.0, "ACTIVITY",
                "n95.jpg", 10000L, 8000L, "https://docs.google.com/document/d/1SGh4GStsBs3gYS_tbB017lVFNSfC1aVbbUiCtN9fZlA/edit#heading=h.j8gffz8wky6d");
        RestVertex v3 = new RestVertex(3L, "Front Nose Bar", 200.0, 400.0, "ACTIVITY",
                "n95.jpg", 10000L, 15000L, "https://docs.google.com/document/d/1SGh4GStsBs3gYS_tbB017lVFNSfC1aVbbUiCtN9fZlA/edit#heading=h.j8gffz8wky6d");
        RestVertex v4 = new RestVertex(4L, "Back Nose Bar", 200.0, 600.0, "ACTIVITY",
                "n95.jpg", 10000L, 9000L, "https://docs.google.com/document/d/1SGh4GStsBs3gYS_tbB017lVFNSfC1aVbbUiCtN9fZlA/edit#heading=h.j8gffz8wky6d");
        RestVertex v5 = new RestVertex(5L, "Tightening Strips", 100.0, 200.0, "ACTIVITY",
                "n95.jpg", 10000L, 12000L, "https://docs.google.com/document/d/1SGh4GStsBs3gYS_tbB017lVFNSfC1aVbbUiCtN9fZlA/edit#heading=h.j8gffz8wky6d");


        RestVertex v6 = new RestVertex(6L, "ANDERS", 50.0, 50.0, "ACTOR",
                "n95.jpg", 10000L, 12000L, "https://docs.google.com/document/d/1SGh4GStsBs3gYS_tbB017lVFNSfC1aVbbUiCtN9fZlA/edit#heading=h.j8gffz8wky6d");

        RestEdge e = new RestEdge(0L, 1L, 0L, 10000L, 8000L);
        RestEdge e1 = new RestEdge(1L, 2L, 1L, 10000L, 8000L);
        RestEdge e2 = new RestEdge(2L, 5L, 2L, 10000L, 8000L);
        RestEdge e3 = new RestEdge(3L, 3L, 1L, 10000L, 8000L);
        RestEdge e4 = new RestEdge(4L, 4L, 1L, 10000L, 8000L);
        RestEdge e5 = new RestEdge(5L, 6L, 2L, 10000L, 8000L);

        return new RestD3Graph("masks-supply-chain", List.of(v, v1,v2, v3, v4, v5, v6), List.of(e, e1, e2, e3, e4, e5));
    }
}
