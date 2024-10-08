package org.example.tobi.springbootfeignclient.service;

import lombok.RequiredArgsConstructor;
import org.example.tobi.springbootfeignclient.client.ExampleClient;
import org.example.tobi.springbootfeignclient.dto.DataRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleClient exampleClient;

    // GET 요청 호출
    public String getDataById(Long id) {
        return exampleClient.getData(id);
    }

    public String createData(String name, int value) {
        return exampleClient.createData(
                DataRequest.builder()
                        .name(name)
                        .value(value)
                        .build()
        );
    }

    public String updateData(Long id, String name, int value) {
        return exampleClient.updateData(
                id,
                DataRequest.builder()
                        .name(name)
                        .value(value)
                        .build()
        );
    }

    public String deleteData(Long id) {
        return exampleClient.deleteData(id);
    }

}
