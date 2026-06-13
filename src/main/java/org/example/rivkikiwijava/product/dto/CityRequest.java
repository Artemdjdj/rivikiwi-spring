package org.example.rivkikiwijava.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CityRequest(
    @NotBlank(message="name обязателен")
    @Size(max = 35, message = "name не длиннее 35 символов")
    String name,

    @NotBlank(message="slug обязателен")
    String slug)

{}
