package com.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import static com.example.Application.filmList;

@Controller
public class FilmsController {

    @Autowired
    FilmRepository filmRepository;

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public String filmList(Model model) {
        model.addAttribute("films", filmRepository.findAll());
        return "films";
    }

    @RequestMapping(value = "/films", method = RequestMethod.POST)
    public String filmsAdd(@RequestParam String isim, Model model) {
        Film film = new Film();
        film.setIsim(isim);
        filmList.add(film);
        filmRepository.save(film);
        model.addAttribute("film", film);
        System.out.println(film.getIsim() + " is added");
        return "redirect:/films/";

    }


}
