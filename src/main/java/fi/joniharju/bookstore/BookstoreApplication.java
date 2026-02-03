package fi.joniharju.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.joniharju.bookstore.model.Book;
import fi.joniharju.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Saving few books for placeholder");
			repository.save(new Book("Sinuhe Egyptiläinen", "Mika Valtari", "1349-343-1331-334", 1950, 10.30));
			repository.save(new Book("Meditations", "Marcus Aurelius", "1349-134-1331-334", 175, 130.30));
			repository.save(new Book("Nalle Puh ja jotain", "Suvi Oksanen", "1349-3434-1331-334", 2010, 15.30));

			// log.info("Get all books");
			// for (Book book : repository.findAll()) {
			// log.info(book.toString());
			// }

			// log.info("get mika");
			// for (Book book : repository.findByAuthor("Mika Valtari")) {
			// log.info(book.toString());
			// }

		};
	}

}
