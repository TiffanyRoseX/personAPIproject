package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService<PersonMapper, PersonDTO> {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public <gi> MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = (MessageResponseDTO) createMessageResponse("Person successfully created with ID ", savedPerson.getId());

        return messageResponse;
    }

    public <PersonDTO> PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = (Person) personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public <MessageResponseDTO> MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        PersonDTO <personDTO1> = personDTO;
        Person updatedPerson = (personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        return (MessageResponseDTO) createMessageResponse("Person successfully updated with ID ", savedPerson.getId());
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        assert MessageResponseDTO.builder() != null;
        return MessageResponseDTO.builder()
                .message(Locale.forLanguageTag(s + id2))
                .build();
    }
}