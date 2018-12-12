package escobard.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    // this sets the fact that many each book may have multiple relationships to an author
    @ManyToMany

    // this joins another table to this table, by using the target table's name
    // the table name referenced here is the AUTHOR_BOOKS table created by the author class
    // the joinColumns declaration utilizes the "book_id" to establish a match between the
    // author_id vs the book_id
    // the inverse join column property sets the REFERENCE column that contains the ID which matches
    // the expected relationship
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    // this creates the table for the publisher_id / book_id relationship
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    // uses the book table as the parent's relationship
    @JoinColumn(name="book")

    // creates a new hashset (this is what may be creating the tables? need to explore) for
    // the publisher_id / book_id table
    private Set<Publisher> publishers = new HashSet<>();

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
        this.publishers = publishers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle(){return  title;}

    public void setTitle(String title){ this.title = title;}

    public String getIsbn(){ return isbn;}

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
