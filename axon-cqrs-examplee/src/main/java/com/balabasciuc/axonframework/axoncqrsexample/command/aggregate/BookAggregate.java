package com.balabasciuc.axonframework.axoncqrsexample.command.aggregate;

import com.balabasciuc.axonframework.axoncqrsexample.command.commands.CreateBookCommand;
import com.balabasciuc.axonframework.axoncqrsexample.command.commands.DeleteBookCommand;
import com.balabasciuc.axonframework.axoncqrsexample.command.commands.RevisionBookCommand;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookActivedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookCreatedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookDeletedEvent;
import com.balabasciuc.axonframework.axoncqrsexample.common_to_both.BookRevisedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

//aggregate is our CommandModel
@Aggregate //axonSpecific
@Slf4j
public class BookAggregate {


    @AggregateIdentifier //id-ul agregatului - axon specific
    private String bookId;

    @Embedded //value Obj class = DDD
    private BookDetails bookDetails;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    // Required by Axon to build a default Aggregate prior to Event Sourcing
    protected BookAggregate() {
    }

    //primul commandHandler trebe sa fie un constructor, sa construiasca o instanta a clasei
    @CommandHandler //handlerCommand for our commands received from the Controller - axon Specific
    public BookAggregate(CreateBookCommand createBookCommand) {
        log.info("Handling CreateBookCommand... Starting.");

        //apply means we publish this event - EDA, to EventHandler
        AggregateLifecycle.apply(new BookCreatedEvent(createBookCommand.getId(), createBookCommand.getBookDetails()));
    }

    @EventSourcingHandler
    public void on(BookCreatedEvent bookCreatedEvent) {
        log.info("Received BookCreatedEvent... Starting.");

        //din event luam datele necesare pt. a seta datele aggregatului nostru
        this.bookId = bookCreatedEvent.getId();
        this.bookDetails = bookCreatedEvent.getBookDetails();
        this.bookStatus = BookStatus.CREATED;

        AggregateLifecycle.apply(new BookActivedEvent(bookCreatedEvent.getId(), BookStatus.ACTIVED.toString()));
    }

    //putem avea evente inlantuite
    @EventSourcingHandler
    public void on(BookActivedEvent bookActivedEvent) {
        log.info("Received BookActivedEvent... Starting.");
        this.bookStatus = BookStatus.ACTIVED;
    }

/*    @CommandHandler
    public void handle(RevisionBookCommand revisionBookCommand)
    {
        log.info("Handling RevisionBookCommand... Starting.");

        AggregateLifecycle.apply(new BookRevisedEvent(revisionBookCommand.getId(), revisionBookCommand.getNewBookDetails()));

        aici e o eroare, pt. ca nu gaseste agregatul in event store, fiindca ii da un nou id cand il modific
        de asta e cel de mai jos, construind o noua instanta a Agregatului prin constructor
        altfel, ar fi void handle(Comanda)
    }*/

    @CommandHandler
    public BookAggregate(RevisionBookCommand revisionBookCommand) {
        log.info("Handling RevisionBookCommand... Starting.");

        AggregateLifecycle.apply(new BookRevisedEvent(revisionBookCommand.getId(), revisionBookCommand.getNewBookDetails()));
    }

    @EventSourcingHandler
    public void on(BookRevisedEvent bookRevisedEvent) {
        log.info("Received BookRevisedEvent... Starting.");
        this.bookId = bookRevisedEvent.getId();
        this.bookDetails = bookRevisedEvent.getNewBookDetails();
        this.bookStatus = BookStatus.REVISED;
    }

    @CommandHandler
    public void handle(DeleteBookCommand deleteBookCommand) {
        log.info("Handling DeleteBookCommand... Starting.");

        AggregateLifecycle.apply(new BookDeletedEvent(deleteBookCommand.getId()));
    }

    @EventSourcingHandler
    public void on(BookDeletedEvent bookDeletedEvent) {
        log.info("Received BookDeletedEvent... Starting.");
        this.bookId = bookDeletedEvent.getId();
        this.bookStatus = BookStatus.DELETED;
    }

}
