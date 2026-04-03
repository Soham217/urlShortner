package com.urlShortener.urlShortSpring;

//import java.beans.JavaBean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UrlRequest {
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }
}
