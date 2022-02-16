package com.example.finaltestmodule4.controller;

import com.example.finaltestmodule4.model.City;
import com.example.finaltestmodule4.model.National;
import com.example.finaltestmodule4.service.ICityService;
import com.example.finaltestmodule4.service.INationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/city")
public class MainController {
    @Autowired
    ICityService cityService;

    @Autowired
    INationalService nationalService;


    @GetMapping("")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("views/index");
        List<City> list = cityService.findAll();
        modelAndView.addObject("listAllCity", list);
        return modelAndView;
    }

    @GetMapping("/add")
    public String showAddingForm(Model model) {
        model.addAttribute("city", new City());
        List<National> nationals = nationalService.findAll();
        model.addAttribute("nationals", nationals);
        model.addAttribute("pageTitle", "Add New City");
        return "views/add";
    }

    @GetMapping("/show/{id}")
    public String showCity(@PathVariable("id") Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        model.addAttribute("cityName", "City: " + city.getName());
        return "views/show";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        List<National> nationals = nationalService.findAll();
        model.addAttribute("nationals", nationals);
        model.addAttribute("pageTitle", "Edit City (Id : " + id + " )");
        return "views/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") Long id, RedirectAttributes ra) {
        cityService.delete(id);
        ra.addFlashAttribute("mess", "Deleted Success");
        return "redirect:/city";
    }

    @PostMapping("/save")
    public String saveCity(@Valid @ModelAttribute(name = "city") City city,
                              BindingResult result,
                              Model model,
                              RedirectAttributes ra
    ) throws IOException {
        if (result.hasErrors()){
            List<National> nationals = nationalService.findAll();
            model.addAttribute("nationals", nationals);
            model.addAttribute("pageTitle", "Add New City");
            return "views/add";
        }
        cityService.save(city);
        ra.addFlashAttribute("mess", "Success");
        return "redirect:/city";
    }
}
