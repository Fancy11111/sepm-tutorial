package at.spring.example.rest;

import at.spring.example.dto.DogDto;
import at.spring.example.service.DogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/dogs")
public class DogEndpoint {
    private final DogService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(DogEndpoint.class);


    public DogEndpoint(DogService service) {
        this.service = service;
    }

    @GetMapping
    public Stream<DogDto> allDogs() {
        return service.allDogs().stream();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto create(@RequestBody DogDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(path= "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
//        return service.create(dto);
    }
}
