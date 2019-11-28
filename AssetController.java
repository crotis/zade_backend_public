package Zade.Server;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import Zade.Server.Assets.Asset;
import Zade.Server.Assets.AssetNotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins = "http://46.101.8.127:3000")
@RestController
class AssetController {
    private final AssetRepository repository;
    private final AssetResourceAssembler assembler;

    AssetController(AssetRepository repository,
                       AssetResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    //Aggregate root
    @GetMapping("/assets")
    Resources<Resource<Asset>> all() {
        List<Resource<Asset>> assets = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        Asset newAsset = new Asset();
        Asset currentAsset = new Asset();
        for (int j = 21; j >= 1; j--) {
            Long id = Long.valueOf(j);
            currentAsset = repository.findById(id).get();
            Asset updatedAsset = repository.findById(id)
                    .map(asset -> {
                        asset.setZadePrice(asset.getPrice());
                        return repository.save(asset);
                    })
                    .orElseGet(() -> {
                        newAsset.setId(id);
                        return repository.save(newAsset);
                    });
        }
        return new Resources<>(assets,
                linkTo(methodOn(AssetController.class).all()).withSelfRel());
    }

    @PostMapping("/assets")
    ResponseEntity<?> newAsset(@RequestBody Asset newAsset) throws URISyntaxException {
        Resource<Asset> resource = assembler.toResource(repository.save(newAsset));
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    //Single item
    @GetMapping("/assets/{id}")
    Resource<Asset> one(@PathVariable Long id) {
        Asset asset = repository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));
        asset.setZadePrice(asset.getPrice());
        return assembler.toResource(asset);
    }

    @PutMapping("/assets/{id}")
    ResponseEntity<?> replaceAsset(@RequestBody Asset newAsset, @PathVariable Long id) throws URISyntaxException {
        Asset updatedAsset = repository.findById(id)
                .map(asset -> {
                    asset.setAssetFrom(newAsset.getAssetFrom());
                    asset.setAssetTo(newAsset.getAssetTo());
                    return repository.save(asset);
                })
                .orElseGet(() -> {
                    newAsset.setId(id);
                    return repository.save(newAsset);
                });
        Resource<Asset> resource = assembler.toResource(updatedAsset);
        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @DeleteMapping("/assets/{id}")
    void deleteAsset(@PathVariable Long id) {
        repository.deleteById(id);
    }
}