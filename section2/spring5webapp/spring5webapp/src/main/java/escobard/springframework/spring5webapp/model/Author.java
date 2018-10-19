package escobard.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// assigns the JPA api for data persistence
@Entity

public class Author {

    // another JPA function
    @Id

    // sets a strategy for persistance? not quite clear
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    // not too sure on what this is, should review later and ask the team
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
