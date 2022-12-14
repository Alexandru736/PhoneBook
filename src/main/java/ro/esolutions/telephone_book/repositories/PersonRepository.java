package ro.esolutions.telephone_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.esolutions.telephone_book.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
