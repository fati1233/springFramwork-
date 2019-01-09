package bgn.springframwork.spring5webapp.bootstrap;

import bgn.springframwork.spring5webapp.model.Author;
import bgn.springframwork.spring5webapp.model.Book;
import bgn.springframwork.spring5webapp.model.Publisher;
import bgn.springframwork.spring5webapp.repositories.AuthorRepository;
import bgn.springframwork.spring5webapp.repositories.BookRepository;
import bgn.springframwork.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("Collins");
        publisherRepository.save(publisher1);
        //first
        Author john = new Author("John", "Doe");

        Book book = new Book("Domain Driven Design", "1234", publisher1);
        john.getBooks().add(book);
        book.getAuthors().add(john);

        authorRepository.save(john);
        bookRepository.save(book);
        publisherRepository.save(publisher1);

        //second
        Author jane =  new Author("Jane", "Doae");
        Book book1 = new Book("JEE Developpement without EJB", "23444", publisher1);
        jane.getBooks().add(book1);
        book1.getAuthors().add(jane);

        authorRepository.save(jane);
        bookRepository.save(book1);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
