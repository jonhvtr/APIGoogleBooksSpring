package com.jonhvtr.api_googlebooks.controller;

import com.jonhvtr.api_googlebooks.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/books")
public class BookController extends BookService {

    @GetMapping("/search")
    @Override
    public String searchBooks(@RequestParam String title) throws IOException, InterruptedException {
        return super.searchBooks(title);
    }
}
