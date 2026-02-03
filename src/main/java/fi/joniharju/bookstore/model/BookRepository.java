package fi.joniharju.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    // @Query annotaatiolla voi halutessaan kova koodata SQL:n
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
}
