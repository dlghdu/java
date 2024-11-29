package com.example.webfrontservice.service;

import com.example.webfrontservice.client.CatalogClient;
import com.example.webfrontservice.dto.CreateCatalogRequestDTO;
import com.example.webfrontservice.dto.CreateCatalogResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogClient catalogClient;

    public CreateCatalogResponseDTO createCatalog(String authorizationHeader, CreateCatalogRequestDTO createCatalogRequestDTO) {
        return catalogClient.createCatalog(authorizationHeader, createCatalogRequestDTO);
    }

}