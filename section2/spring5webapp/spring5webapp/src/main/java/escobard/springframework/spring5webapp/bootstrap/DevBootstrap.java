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

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // calls initData on application start
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    };

    // populates the inmemory DB with 2 books and 2 authors
    private void initData(){

        // this creates an author / book class instance (which creates a JPA SQL object / table as well for the inmemory data)
        Author wellington = new Author("Wellington", "Wellington");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");

        //creates a book set, with the book created above
        wellington.getBooks().add(ddd);
        ddd.getAuthors().add(wellington);

        Author thanos = new Author("Thanos", "The Undying");
        Book bod = new Book("The book of death", "4321", "Death");
        thanos.getBooks().add(bod);
        bod.getAuthors().add(thanos);

    };
};
