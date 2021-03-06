package escobard.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// can se the name by adding a @Entity(name="name") postfix
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // without this definition, the ID / Generated Value imports do not work, expects id to be declared
    private Long id;

    // could manipulate the column name by using the following syntax:
    //@Column(name="column_name")
    // if column is not explicitly named, will use variable name instead
    private String name;
    private String address;

    // this determines that a single publisher, may have many books
    // but a book will not have many publishers
    @OneToMany

    private Set<Book> books = new HashSet<>();

    // created using the generate feature for constructors
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = getBooks();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
