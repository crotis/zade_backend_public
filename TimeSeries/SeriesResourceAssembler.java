package Zade.Server.TimeSeries;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
class SeriesResourceAssembler implements ResourceAssembler<Series, Resource<Series>> {

    @Override
    public Resource<Series> toResource(Series series) {

        return new Resource<>(series,
                linkTo(methodOn(SeriesConroller.class).one(series.getId())).withSelfRel());
    }
}


