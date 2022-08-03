package ro.esolutions.telephone_book.mapper;

import ro.esolutions.telephone_book.entities.Person;
import ro.esolutions.telephone_book.entities.PhoneNumber;
import ro.esolutions.telephone_book.models.PhoneBookEntryModel;

import java.util.List;

public final class PhoneBookEntryMapper {
    private PhoneBookEntryMapper() {}

    public static PhoneBookEntryModel toModel(Person person, List<String> phoneNumbers) {
        return PhoneBookEntryModel.builder()
                .name(person.getName())
                .email(person.getEmail())
                .id(person.getId())
                .phoneNumbers(phoneNumbers)
                .build();
    }
}
