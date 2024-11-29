package com.example.webfrontservice.client;

import com.example.webfrontservice.dto.CreateCatalogRequestDTO;
import com.example.webfrontservice.dto.CreateCatalogResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "catalogClient", url = "${polar.catalog-service-url}")
public interface CatalogClient {

    @PostMapping
    CreateCatalogResponseDTO createCatalog(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody CreateCatalogRequestDTO createCatalogRequestDTO
    );

}