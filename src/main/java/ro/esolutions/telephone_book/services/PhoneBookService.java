package ro.esolutions.telephone_book.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.telephone_book.entities.Person;
import ro.esolutions.telephone_book.entities.PhoneNumber;
import ro.esolutions.telephone_book.mapper.PhoneBookEntryMapper;
import ro.esolutions.telephone_book.models.PhoneBookEntryModel;
import ro.esolutions.telephone_book.repositories.PersonRepository;
import ro.esolutions.telephone_book.repositories.PhoneRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhoneBookService {

    @NonNull
    final PersonRepository personRepository;

    @NonNull
    final PhoneRepository phoneRepository;

    public List<PhoneBookEntryModel> getAllPhoneBookEntries() {
        return personRepository.findAll().stream().map(
                person -> {
                    List<String> phoneNumbers = phoneRepository.findByPersonId(person.getId())
                            .stream()
                            .map(phoneNumber -> phoneNumber.getPhoneNumber())
                            .collect(Collectors.toList());
                    return PhoneBookEntryMapper.toModel(person, phoneNumbers);
                }
        ).collect(Collectors.toList());
    }

    public List<String> getPhoneNumbers(Long id) {
        return phoneRepository.findByPersonId(id).stream()
                .map(phoneNumber1 -> phoneNumber1.getPhoneNumber())
                .collect(Collectors.toList());
    }
    public PhoneBookEntryModel getPhoneBookEntry(Long id) {
        Optional<Person> person = personRepository.findById(id);
        List<String> phoneNumber = getPhoneNumbers(id);

        return PhoneBookEntryMapper.toModel(person.get(), phoneNumber);
    }
}
