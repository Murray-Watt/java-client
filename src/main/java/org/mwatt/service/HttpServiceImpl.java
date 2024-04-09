package org.mwatt.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class HttpServiceImpl implements HttpService {
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public HttpServiceImpl() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T> T get(URI uri, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        HttpResponse<String> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8)).join();
        return objectMapper.readValue(response.body(), responseType);
    }
}

