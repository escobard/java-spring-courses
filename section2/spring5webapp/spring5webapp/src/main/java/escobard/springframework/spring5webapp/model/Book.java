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

    // this creates the relationship between the Publisher table and the Book table
    @OneToOne
    private Publisher publisher;

    // this creates adds the Author's ID for the book, to the books column.
    @OneToOne
    private Author author;

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

    // this is a necessary DEFAULT CONSTRUCTOR, for instances where no book data is added to the BOOK constructor
    public Book(){}

    // creates a new hashset (this is what may be creating the tables? need to explore) for
    // the publisher_id / book_id table

    public Book(String title, String isbn, Publisher publisher, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = author;
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

    // if we dont set the getters and setters for the instances of related DBs, we cannot call them using the
    // book.publisher syntax in the thymeleaf template
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
