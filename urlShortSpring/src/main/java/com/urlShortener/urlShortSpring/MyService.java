package com.urlShortener.urlShortSpring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    Map<String,String> map = new HashMap<>();

    public String shortenURL(String url) {
        String shortCode = generateCode();
        map.put(shortCode, url);
        return shortCode;
    }

    private String generateCode(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5;i++){
            char ch = (char)(Math.random()*26 + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }

    public String getOriginalUrl(String code) {
        return map.get(code);
    }
}
