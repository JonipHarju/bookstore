package fi.joniharju.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.joniharju.bookstore.model.Book;
import fi.joniharju.bookstore.model.BookRepository;
import fi.joniharju.bookstore.model.Category;
import fi.joniharju.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			Category category1 = new Category("Romaani");
			Category category2 = new Category("Filosofia");
			Category category3 = new Category("Lastenkirja");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			log.info("Saving few books for placeholder");
			bookRepository
					.save(new Book("Sinuhe Egyptiläinen", "Mika Valtari", "1349-343-1331-334", 1950, 10.30, category1));
			bookRepository
					.save(new Book("Meditations", "Marcus Aurelius", "1349-134-1331-334", 175, 130.30, category2));
			bookRepository.save(new Book("Filosofian lohtu", "Boethius", "978-951-1-12345-6", 524, 25.00, category2));
			bookRepository.save(
					new Book("Nalle Puh ja jotain", "Suvi Oksanen", "1349-3434-1331-334", 2010, 15.30, category3));

			log.info("Get all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("get mika");
			for (Book book : bookRepository.findByAuthor("Mika Valtari")) {
				log.info(book.toString());
			}

		};
	}

}
