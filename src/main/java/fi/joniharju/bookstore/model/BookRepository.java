package fi.joniharju.bookstore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    // @Query annotaatiolla voi halutessaan kova koodata SQL:n

    // https://github.com/Haaga-Helia-SOF003AS3A/documentation/blob/main/materials/TheoryAndExercisesMd/3jpa/SP3-JPA.md
    // Some Useful Methods of CrudRepository
    // long count() Returns the number of entities available.
    // void deleteById(ID id) Deletes the entity with the given id
    // void delete(T Entity) Deletes given entity
    // deleteAll() Deletes all entities managed by the repository
    // Iterable<T> findAll() Returns all entities
    // Optional<T> findById(ID id) Retrieves an entity by its id
    // <S extends T> S save(S entity) Saves a given entity

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);
}
