package one.digitalinnovation.personapi.service;

import java.util.List;
import java.util.Optional;

public class PersonRepository {
    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }

    public void deleteById(Long id) {
    }

    public Person save(Person updatedPerson) {
        return updatedPerson;
    }

    public List<Person> findAll() {
        return null;
    }
}
