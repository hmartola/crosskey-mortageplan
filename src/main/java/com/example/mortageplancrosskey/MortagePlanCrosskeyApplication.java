package com.example.mortageplancrosskey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class MortagePlanCrosskeyApplication {

    public static void main(String[] args) {
        FileOperator fileOperator = new FileOperator();
        SpringApplication.run(MortagePlanCrosskeyApplication.class, args);
        fileOperator.readFile();

    }

}
