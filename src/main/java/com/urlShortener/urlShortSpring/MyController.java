package com.urlShortener.urlShortSpring;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
public class MyController {

    @Autowired
    MyService service;

    @PostMapping("/shorten")
    public String shortenURL(@RequestBody UrlRequest request) {
        return service.shortenURL(request.getOriginalUrl());
    }

    @GetMapping("/{code:[a-zA-Z0-9]+}")
    public void redirect(@PathVariable String code, HttpServletResponse response) throws IOException {
        String originalUrl = service.getOriginalUrl(code);

        if (originalUrl != null) {
            response.sendRedirect(originalUrl);
        } else {
            response.sendError(404, "URL not found");
        }
    }

    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }
}
