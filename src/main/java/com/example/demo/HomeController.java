package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/")
    public String listFlights(Model model){
        model.addAttribute("flights", flightRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String flightForm(Model model){
        model.addAttribute("flight", new Flight());
        return "flightform";
    }

    // process Search Bar form
    @PostMapping("/processsearch")
    public String searchResult(Model model, @RequestParam(name="search") String search){
        model.addAttribute("flights", flightRepository.findByAirlineContainingIgnoreCase(search));
        return "searchlist";
    }

    @PostMapping("/process")
    public String processForm(@Valid Flight flight, BindingResult result){
        if(result.hasErrors()){
            return "flightform";
        }
        flightRepository.save(flight);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showFlight(@PathVariable("id") long id, Model model){
        model.addAttribute("flight", flightRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateFlight(@PathVariable("id") long id, Model model){
        model.addAttribute("flight", flightRepository.findById(id).get());
        return "flightform";
    }

    @RequestMapping("delete/{id}")
    public String delFlight(@PathVariable("id") long id){
        flightRepository.deleteById(id);
        return "redirect:/";
    }
}

