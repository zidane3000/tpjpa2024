package com.kahoot;

import com.kahoot.service.KahootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KahootAopApplication implements CommandLineRunner {

    @Autowired
    private KahootService kahootService;
    public static void main(String[] args) {
        System.out.println(SpringApplication.run(KahootAopApplication.class, args));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.kahootService.getKahootMessage());
    }
}
