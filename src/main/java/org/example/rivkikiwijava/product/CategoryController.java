package org.example.rivkikiwijava.product;

import lombok.RequiredArgsConstructor;
import org.example.rivkikiwijava.product.dto.CategoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

//    public CategoryController(CategoryService service){
//        this.service = service;
//    }

    @GetMapping
    public List<CategoryResponse> list(){
        return service.list();
    }

    @PostMapping
    public CategoryResponse create(@RequestParam String name, @RequestParam String slug){
        return service.create(name, slug);
    }
}
