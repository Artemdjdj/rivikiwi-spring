package org.example.rivkikiwijava.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.rivkikiwijava.product.dto.CityRequest;
import org.example.rivkikiwijava.product.dto.CityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities/")
@RequiredArgsConstructor
public class CityController {
    private final CityService service;

    @GetMapping
    public List<CityResponse> list(){
        return service.list();
    }

    @GetMapping("/{slug}")
    public CityResponse getCity(@PathVariable String slug){
        return service.getBySlug(slug);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponse create(@Valid @RequestBody CityRequest request) {
        return service.create(request);
    }

    @PutMapping("/{slug}")
    public CityResponse update(@PathVariable String slug,  @Valid @RequestBody CityRequest request){
        return service.update(slug,request);
    }

    @DeleteMapping("/{slug}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String slug){
        service.delete(slug);
    }
}
