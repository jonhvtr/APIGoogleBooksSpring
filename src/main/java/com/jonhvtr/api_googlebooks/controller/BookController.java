package com.jonhvtr.api_googlebooks.controller;

import com.jonhvtr.api_googlebooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public String searchBooks(@RequestParam String title) throws IOException, InterruptedException {
        return bookService.searchBooks(title);
    }
}
