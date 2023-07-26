package tmd.pop.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tmd.pop.entity.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT new map(p.name as name, p.birthYear as birthYear) FROM Person p")
    List<Map<String, Object>> getAllNamesAndBirthYears();

}
