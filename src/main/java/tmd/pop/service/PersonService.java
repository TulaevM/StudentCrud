package tmd.pop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tmd.pop.dao.PersonDao;
import tmd.pop.entity.Person;
import tmd.pop.repository.PersonRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;


    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).get();
    }

    public void createPerson(PersonDao personDao) {
        Person person = Person.builder()
                .name(personDao.getName())
                .surname(personDao.getSurname())
                .birthYear(personDao.getBirthYear())
                .build();
        personRepository.save(person);
    }


    public void update(Long id, PersonDao personDao) {
        Person person = personRepository.findById(id).get();
        person.setBirthYear(personDao.getBirthYear());
        person.setName(personDao.getName());
        person.setSurname(personDao.getSurname());

        personRepository.save(person);

    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    private List<Map<String, Object>> getAllNamesAndBirthYears() {
        return personRepository.getAllNamesAndBirthYears();
    }
    public HashMap<Integer, Integer> getAllYears() {
        ArrayList<Object> arrayList=new ArrayList<>();
        ArrayList<Object> list=new ArrayList<>();
        ArrayList<String> lastList=new ArrayList<>();
        ArrayList<Integer> lastList2=new ArrayList<>();

        List<Map<String, Object>> namesAndBirthYears = getAllNamesAndBirthYears();
        for (Map<String, Object> map : namesAndBirthYears) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                arrayList.add(value);

            }
        }
        for (int i = 0; i < arrayList.size(); i=i+2) {
            list.add(arrayList.get(i).toString().substring(0,4));
        }
        for (Object o : list) {
            lastList.add(o.toString());
        }
        for (String s : lastList) {
            lastList2.add(Integer.parseInt(s));
        }

        HashMap<Integer, Integer> elementCountMap = new HashMap<>();


        for (Integer element : lastList2) {
            // If the element already exists in the map, increment its count
            if (elementCountMap.containsKey(element)) {
                int count = elementCountMap.get(element);
                elementCountMap.put(element, count + 1);
            } else {
                // If the element is encountered for the first time, add it to the map with count 1
                elementCountMap.put(element, 1);
            }
        }

        return elementCountMap;

    }

    public LinkedHashMap<Integer, Integer> sortHashMapByKeys(HashMap<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }










}
