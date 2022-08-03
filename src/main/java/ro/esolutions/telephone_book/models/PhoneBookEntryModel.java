package ro.esolutions.telephone_book.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBookEntryModel {
    Long id;
    String name;
    String email;
    List<String> phoneNumbers;
}
