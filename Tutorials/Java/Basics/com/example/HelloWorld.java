package com.example;

import java.lang.String;
import java.lang.System;
import java.util.Date;

public class HelloWorld {
    private static void log(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        log("Helo World");
    }
}

// filewatcher com/example/HelloWorld.java  "javac com/example/HelloWorld.java && java com.example.HelloWorld"
