package escobard.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// assigns the JPA api for data persistence
// this link explains all in detail https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
@Entity

public class Author {

    // https://www.objectdb.com/java/jpa/entity/id
    @Id
    // https://www.thoughts-on-java.org/jpa-generate-primary-keys/
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany
    private Set<Book> books = new HashSet<>();

    public Author(){

    }

    public String test = "test";

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName, Set<Book> books){
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName(){ return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public String getLastName(){ return lastName;}
    public void setLastName(String lastName){ this.lastName = lastName;}

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
