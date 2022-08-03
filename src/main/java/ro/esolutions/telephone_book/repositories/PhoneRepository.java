package ro.esolutions.telephone_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.esolutions.telephone_book.entities.PhoneNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneNumber, Long> {
    List<PhoneNumber> findByPersonId(Long id);
}
