package com.example.db;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Supplier {

    public static void main(String[] args) {
        System.out.println((new BCryptPasswordEncoder(12).encode("observer")));

    }
}
