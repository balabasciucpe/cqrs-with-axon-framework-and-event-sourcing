# cqrs-with-axon-framework-and-event-sourcing
An example of how to use CQRS and Event Sourcing with the help of Axon Framework and Spring Boot

Axon Example with CQRS and EDA
Event Sourcing spune ca fiecare schimbare asupra Entitatii, sa genereze un event, sa-l publice si eventual sa fie procesat, care sa fie salvat intr-o baza de date - Event Store, iar mai apoi, putem genera acea instanta a entitatii dintr-un anumit timp - o anumita serie de eventuri

-deci putem returna o instanta a Entitatii careia nu s-au aplicat anumite comenzi

Event Storming - ce eventuri ar trebui sa emita entitatea noastra? si in ce context? - eventuri care schimba starea agregatului nostru

In Saga Pattern, putem realiza tranzactia + publicarea unui Event -> totul in aceeasi tranzactie, care sa declanseze urmatorul pas din Saga transaction

Pentru a implementa Event Sourcing vom folosi Axon Framework, excludem din dependenta adaugata connectorul catre Serverul Axon, ci ne vom folosi ca Embedded  Persistent Store - in acest caz H2 DB

Am impartit aplicatia in 2 packege-uri principale: Command si Query
Command raspunde la Comenzille venite in Controller si schimba state-ul modelului nostru (Write Model) - CreateEntity(Entity obj) - ex
Write Model: 
- @Aggregate - Axon specific Annotation, aceasta Entitate va fi administrata de Axon
- @AggregateIdentifier - id-ul Aggregatului pe care il administram
Comenzi:
- @TargetAggregateIdentifier - id-ul Aggregatului caruia ii aplicam aceasta comanda (care sa-i schimba starea)
Evente:
 - Reprezinta notificari ale schimbarilor suferite de state-ul agregatului
Query raspunde la interogari privind modelul nostru Read - GetEntityById(Long id) - ex
axon specific prin queryGateway trimitem query catre EntityService

handlers are methods on the Aggregate that should be invoked for a particular command or an event.
- @CommandHandler
 axon specific, prin commandGateway trimitem comenzi in CommandBus si mai departe catre CommandHandlers
 private final CommandGateway commandGateway;
iar in Aggregatele, metodele adnotate cu @CommandHandler vor raspunde la comenzile trimise de CommandGateway.
- @EventSourcingHandler

ne trebuie un Constructor fara parametri - Axon construieste o instanta a agregatului folosindu-se de acest constructor, apoi aplica evenimentele\

practic Write Modelul - Agregatul - aici salvam eventele, comenzile si state-ul care se schimba de-a lungul timpului - Event Store
iar Read Modelul e Entitatea noastra propriu zisa care urmeaza a-i fi schimbata state-ul cu @EventHandler - raspunde la eventuri si actualizazea entitatea

Reference Guide: https://www.youtube.com/watch?v=SL2VSYecDvQ

Book: Practical Microservice Architectural Patterns

