package Zade.Server;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import Zade.Server.Assets.Asset;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;


@Component
class AssetResourceAssembler  implements ResourceAssembler<Asset, Resource<Asset>> {

    @Override
    public Resource<Asset> toResource(Asset asset) {

        return new Resource<>(asset,
                linkTo(methodOn(AssetController.class).one(asset.getId())).withSelfRel(),
                linkTo(methodOn(AssetController.class).all()).withRel("assets"));
    }
}