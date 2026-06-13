package org.example.rivkikiwijava.product;

import lombok.RequiredArgsConstructor;
import org.example.rivkikiwijava.product.dto.CityRequest;
import org.example.rivkikiwijava.product.dto.CityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public List<CityResponse> list(){
        List<City> cities = repository.findAll();
        List<CityResponse> cityResponses = new ArrayList<>();
        for (City city : cities){
            cityResponses.add(toResponse(city));
        }
        return cityResponses;
    }

    public CityResponse getBySlug(String slug){
        City city = repository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Город не найден: " + slug));
        return toResponse(city);
    }

    public CityResponse create(CityRequest cityRequest){
        if (repository.existsCityBySlug(cityRequest.slug())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Город с таким slug уже есть: " + cityRequest.slug());
        }
        City city = new City();
        city.setName(cityRequest.name());
        city.setSlug(cityRequest.slug());
        return toResponse(repository.save(city));
    }

    public CityResponse update(String slug, CityRequest cityRequest){
        City city = repository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Город не найден: " + slug));
        city.setName(cityRequest.name());
        city.setSlug(cityRequest.slug());
        return toResponse(repository.save(city));
    }

    public void delete(String slug){
        City city = repository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Город не найден: " + slug));
        repository.delete(city);
    }

    private CityResponse toResponse(City city){
        return new CityResponse(city.getId(), city.getName(), city.getSlug());
    }
}
