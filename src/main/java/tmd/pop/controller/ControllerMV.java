package tmd.pop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tmd.pop.dao.PersonDao;
import tmd.pop.entity.Person;
import tmd.pop.service.PersonService;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/population")
public class ControllerMV {
    private final PersonService personService;

    @GetMapping("/people")
    public String getAll(Model model) {
        List<Person> people = personService.getAll();
        model.addAttribute("people", people);
        return "people"; // Return the name of the Thymeleaf template (without the ".html" extension)
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("personDao", new PersonDao());
        return "add_person";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("personDao") PersonDao personDao) {
        personService.createPerson(personDao);
        return "redirect:/population/people"; // Use the correct URL for redirecting after adding a person
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("personDao", person); // Correct the attribute name to "personDao"
        return "update_person";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("personDao") PersonDao personDao) {
        personService.update(id, personDao);
        return "redirect:/population/people"; // Redirect to the list of people after updating the person
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "delete_person";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/population/people"; // Redirect to the list of people after deleting a person
    }

    @GetMapping("/showYears")
    public String showYears(Model model) {
        HashMap<Integer, Integer> elementCountMap = personService.getAllYears();
        model.addAttribute("yearMap", elementCountMap);
        return "yearTable";
    }
}
