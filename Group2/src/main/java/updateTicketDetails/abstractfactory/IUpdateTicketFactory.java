package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.interfaces.IUpdateTicket;

public interface IUpdateTicketFactory 
{

	IUpdateTicket UpdateTicket(IConnectionManager connectionMng);
}
