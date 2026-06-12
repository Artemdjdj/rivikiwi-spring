package org.example.rivkikiwijava.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private ProductCategoryRepository repository;
}
