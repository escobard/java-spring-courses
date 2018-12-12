package escobard.springframework.spring5webapp.repositories;

import escobard.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

// extends a class to use the spring data repository class, necessary to create a repository
// for in-memory sql tables

// selects the author class as the main argument, and the long data type for the ID (set within the Author class)
// extends our author class with an interface, which gives us basic SQL children functions
// to utilize

// http://tutorials.jenkov.com/java/interfaces.html
// explanation on how to use interfaces in java, basically creates a class with empty
// values which can later be altered and used to display data
// in this case, used to manipulate SQL data
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
