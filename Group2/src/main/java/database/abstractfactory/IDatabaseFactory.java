package database.abstractfactory;

import Tickets.ICreateTicket;
import database.IConnectionManager;
import database.IDatabaseOperations;
import database.ITicketOperationsDB;

public interface IDatabaseFactory {
    IConnectionManager getConnectionManager(String configurationFile);

    IDatabaseOperations getDatabaseOperations();

    ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket);
}