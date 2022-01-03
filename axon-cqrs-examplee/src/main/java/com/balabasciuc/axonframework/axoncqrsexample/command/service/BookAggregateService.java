package com.balabasciuc.axonframework.axoncqrsexample.command.service;

import com.balabasciuc.axonframework.axoncqrsexample.command.aggregate.BookDetails;
import com.balabasciuc.axonframework.axoncqrsexample.command.commands.CreateBookCommand;
import com.balabasciuc.axonframework.axoncqrsexample.command.commands.DeleteBookCommand;
import com.balabasciuc.axonframework.axoncqrsexample.command.commands.RevisionBookCommand;
import com.balabasciuc.axonframework.axoncqrsexample.command.dto.CreateBookRequest;
import com.balabasciuc.axonframework.axoncqrsexample.command.dto.DeleteBookRequest;
import com.balabasciuc.axonframework.axoncqrsexample.command.dto.RevisionBookRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class BookAggregateService {

    //axon specific, prin commandGateway trimitem comenzi in CommandBus si mai departe catre CommandHandlers
    //final pt. ca nu vrem ca mai incolo sa fie schimbat acest commandGateway
    private final CommandGateway commandGateway;

    //autowired prin constructor, ms spring
    public BookAggregateService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    //completableFuture deoarece asteptam un raspuns, dar sa fie non blocking pt threaduri
    public CompletableFuture<String> createBook(CreateBookRequest createBookRequest) {
        return commandGateway.send(new CreateBookCommand(UUID.randomUUID().toString(), new BookDetails(
                createBookRequest.getBookTitle(), createBookRequest.getBookAuthor(), createBookRequest.getBookDescription(), createBookRequest.getPrice())));
    }

    public CompletableFuture<String> revisionBook(RevisionBookRequest revisionBookRequest) {
        return commandGateway.send(new RevisionBookCommand(UUID.randomUUID().toString(), new BookDetails(
                revisionBookRequest.getNewBookTitle(), revisionBookRequest.getNewBookAuthor(), revisionBookRequest.getNewBookDescription(), revisionBookRequest.getNewPrice())));
    }

    public CompletableFuture<String> deleteBook(DeleteBookRequest deleteBookRequest) {
        return commandGateway.send(new DeleteBookCommand(deleteBookRequest.getBookId()));
    }
}
