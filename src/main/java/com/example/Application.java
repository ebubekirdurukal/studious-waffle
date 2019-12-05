package com.example;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static List<Film> filmList=new ArrayList();

    @Autowired
    FilmRepository filmRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {


    	Film film1=new Film("Pulp Fiction",0);
    	filmList.add(film1);
    	filmRepository.save(film1);

	}

}
