package com.chrisgruber.nanourl.services;

import org.springframework.stereotype.Service;

@Service
public class UrlInversionService {
    private String alphabet;
    private int base;

    public UrlInversionService() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        this.base = this.alphabet.length();
    }

    public UrlInversionService(String alphabet) {
        this.alphabet = alphabet;
        this.base = this.alphabet.length();
    }

    public String Encode(int i) {
        if (i == 0) {
            return Character.toString(this.alphabet.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (i > 0) {
            sb.append(this.alphabet.charAt(i % this.base));
            i = i / this.base;
        }

        return String.join("", sb.reverse());
    }

    public int Decode(String s) {
        int i = 0;

        for (char c : s.toCharArray()) {
            i = (i * this.base) + this.alphabet.indexOf(c);
        }

        return i;
    }
}
