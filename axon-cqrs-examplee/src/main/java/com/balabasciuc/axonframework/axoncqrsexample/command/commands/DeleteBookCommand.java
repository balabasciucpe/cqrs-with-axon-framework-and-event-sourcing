package com.balabasciuc.axonframework.axoncqrsexample.command.commands;

//putem sa o facem si fara sa extindem o clasa anume, fiind limitati doar la o singura clasa mostnita in java
//dar aici fac asa, pt. a fi less verbose
public class DeleteBookCommand extends BaseCommand<String> {


    public DeleteBookCommand(String id) {
        super(id);

    }


}
