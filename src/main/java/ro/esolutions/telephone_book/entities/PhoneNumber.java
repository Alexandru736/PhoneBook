package ro.esolutions.telephone_book.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "phone_number")
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    @Id
    @Column(name = "id", nullable = false)
    Long id;

    String phoneNumber;
    Long personId;
}
