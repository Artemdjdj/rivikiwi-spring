package org.example.rivkikiwijava.product;

import lombok.RequiredArgsConstructor;
import org.example.rivkikiwijava.product.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private ProductCategoryRepository repository;

    public List<CategoryResponse> list(){
        List<ProductCategory> eProductCategories = repository.findAll();
        List<CategoryResponse> responseCategories = new ArrayList<>();
        for (ProductCategory e_prod_cat: eProductCategories){
            responseCategories.add(new CategoryResponse(e_prod_cat.getId(), e_prod_cat.getName(), e_prod_cat.getSlug()));
        }
        return responseCategories;
    }

    public CategoryResponse create(String name, String slug){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);
        productCategory.setSlug(slug);
        var prodCatSaved = repository.save(productCategory);
        return new CategoryResponse(prodCatSaved.getId(), prodCatSaved.getName(), prodCatSaved.getSlug());
    }
}
