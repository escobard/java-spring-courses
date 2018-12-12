package escobard.springframework.spring5webapp.bootstrap;

import escobard.springframework.spring5webapp.model.Author;
import escobard.springframework.spring5webapp.model.Book;
import escobard.springframework.spring5webapp.repositories.AuthorRepository;
import escobard.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


// this wires up the class as a a SPRING BEAN which initializes the class with Spring
@Component
// this creates an application listener class type
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // creates a placeholder variable to hold the repository of books / authors
    // initialized with the class, stores book data to .this
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    // binds the repository instances to this class, for later use
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // calls initData on application start
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    };

    // populates the repository interface with the data established below
    private void initData(){

        // this creates an author / book class instance (which creates a JPA SQL object / table as well for the inmemory data)
        Author wellington = new Author("Wellington", "Wellington");
        Book ddd = new Book("Domain Driven Design", "1234");

        //creates a an author set, with the book created above
        wellington
                // this gets all instances of the book_id / author_id entities
                .getBooks()
                    // this creates the new relationship between the book_id / author_id
                    .add(ddd);
        ddd.getAuthors().add(wellington);

        // saves the newly created author / book in the corresponding repository
        authorRepository.save(wellington);
        bookRepository.save(ddd);

        Author thanos = new Author("Thanos", "The Undying");
        Book bod = new Book("The book of death", "4321");
        thanos.getBooks().add(bod);
        bod.getAuthors().add(thanos);

        authorRepository.save(thanos);
        bookRepository.save(bod);
    };
};
