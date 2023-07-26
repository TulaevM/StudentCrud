//package tmd.pop.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import tmd.pop.dao.PersonDao;
//import tmd.pop.entity.Person;
//import tmd.pop.service.PersonService;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/per")
//public class Controller {
//    private final PersonService personService;
//
//    @GetMapping("/people")
//    public List<Person> getAll() {
//        return personService.getAll();
//    }
//
//    @GetMapping("/person/{id}")
//    public Person getById(@PathVariable Long id) {
//        return personService.getPersonById(id);
//    }
//
//    @PostMapping("/add")
//    public Person add(@RequestBody PersonDao personDao) {
//        return personService.createPerson(personDao);
//    }
//
//    @PutMapping("/update/{id}")
//    public Person update(@PathVariable Long id, @RequestBody PersonDao personDao) {
//        return personService.update(id, personDao);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Long id) {
//        personService.deleteById(id);
//    }
//}
