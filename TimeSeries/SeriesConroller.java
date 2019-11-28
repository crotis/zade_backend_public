package Zade.Server.TimeSeries;

import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SeriesConroller {
    private final SeriesRepository repository;
    private final SeriesResourceAssembler assembler;

    SeriesConroller(SeriesRepository repository,
                    SeriesResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }
    //Single item
    @GetMapping("/series/{id}")
    Resource<Series> one(@PathVariable Long id) {
        Series series = repository.findById(id)
                .orElseThrow(() -> new SeriesNotFoundException(id));
//        asset.setZadePrice(asset.getPrice());
        return assembler.toResource(series);
    }

}
