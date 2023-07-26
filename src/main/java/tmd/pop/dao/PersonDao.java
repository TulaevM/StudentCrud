package tmd.pop.dao;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDao {
    private String name;
    private String surname;
    private LocalDate birthYear;
}
