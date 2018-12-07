package escobard.springframework.spring5webapp.model;

// this is automatically set after we use most persistance objects
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// assigns the JPA api for data persistence
// this link explains all in detail https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
// are using the hibernate JPA ORM, which creates an INMEMORY db
@Entity
public class Author {

    // these both generate a random ID for this class's row
    // https://www.objectdb.com/java/jpa/entity/id
    // this id is first set as NULL - this may cause problems in a set
    @Id
    // https://www.thoughts-on-java.org/jpa-generate-primary-keys/
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    // creates a sql relationship between books / author
    // creating another table specifically for this relationship, which isn't the behavior we want
    //@ManyToMany(mappedBy = 'authors')

    // we want to establish a single table for this relationship, not 1 for books vs authors and
    // 1 for authors vs books, this is accomplished by the mappedBy parameter
    // and the JoinTable property, within the books class
    @ManyToMany(mappedBy = "authors")
    // this imports the BOOK class into this class
    private Set<Book> books = new HashSet<>();

    public String test = "test";

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

    // sets a more reliable ID hash for the class (sql table)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // returns relevant class values in a pretty string format
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                ", test='" + test + '\'' +
                '}';
    }
}
