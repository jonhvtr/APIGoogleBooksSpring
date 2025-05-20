package com.jonhvtr.api_googlebooks.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
public class BookService {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public String searchBooks(@RequestParam String title) throws IOException, InterruptedException {
        String query = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String uri = "https://www.googleapis.com/books/v1/volumes?q=" + query;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            JsonObject error = new JsonObject();
            error.addProperty("error", "Erro ao buscar livros: " + response.statusCode());
            return error.toString();
        }
    }
}
