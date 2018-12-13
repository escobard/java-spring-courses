package escobard.springframework.spring5webapp.controllers;

import escobard.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// registers this class as a CONTROLLER, in other words a route handler
// in java we follow an MVC structure, where the controller both fetches data from the model (entitys / model classes), and sends it to the view
// Same principle used in node.js API's with the one big difference being here that each model has its own controller, and each model is defined as a SINGLE SQL TABLE
// where in node.js, the model may be the ENTIRE db, not a single table
@Controller
public class BookController {

    // grabs the book interface object
    private BookRepository bookRepository;

    // constructor function, adds the bookRepository to this
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // this determines the ROUTE PATH that will trigger the logic for the API
    @RequestMapping("/books")

    // this is used to pass the MODEL into the controller
    // since the MODEL gets extended by an INTERFACE by the repository logic
    // the controller then takes that interface object to display the data in the view
    public String getBooks(Model model){

        // creates an inmemory Model
        model.addAttribute(
                // first argument is the NAME of the model instance
                "books",

                // second arg is the repository we want to use to populate the model
                bookRepository.findAll());

        // this returns the model defined above, in other words the list of book(s) data
        // doesn't make complete sense yet, but apparently this is picked up by the thymeleaf library, rendering a view
        return "books";

    }
}
