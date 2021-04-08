package userinterface;

import java.util.Scanner;

import commentOnTicket.abstractfactory.ICommentOnTicketFactory;
import commentOnTicket.abstractfactory.CommentOnTicketFactory;
import commentOnTicket.interfaces.ICommentOnTicket;
import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClassFactory;
import reuseablePackage.abstractFactory.ReuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class CommentOnTicketScreen implements ICommentOnTicketScreen
{
	Scanner sc = new Scanner(System.in);
	
	private String ticketId = null;
	private String commentString = null;
	private boolean result = false;
	private boolean commentPostResult=false;
	private String employeeID = "emp123";
	private final String ConfigurationFile = "ConfigurationFile";

	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);
	IInputOutputHandler inputoutputhandler;
	
	ICommentOnTicketFactory commentonticketfactory = CommentOnTicketFactory.instance();
	ICommentOnTicket postcomment = commentonticketfactory.postComment(ConnectionMng);
	
	IReuseableClassFactory reuseableclassfactory = ReuseableClassFactory.instance();
	ICheckTicketExists checkticketexists= reuseableclassfactory.checkticketexists();
	IStoreTicketData storeTicketData =reuseableclassfactory.storeTicketData();
	ITableGenerator tableformate = reuseableclassfactory.tableFormate();
	IDisplayTicket displaytickets = reuseableclassfactory.displayUser(tableformate);
	IGetListOfTickets getalltickets = reuseableclassfactory.getalltickets(storeTicketData,displaytickets,ConnectionMng);
	
	public CommentOnTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	
	}
	
	public  void commentonticketscreen(IParameterizedUser user)
	{
		
		String output="";
		output=getalltickets.listOfTickets();
		do {
			inputoutputhandler.displayMethod(output);
			inputoutputhandler.displayMethod("Enter Ticket Id you want to post comment on.:");
			inputoutputhandler.displayMethod("Enter exit to go to main page");
			ticketId = inputoutputhandler.input();
			if(ticketId.toLowerCase().equals("exit"))
			{
				break;
			}
			result=checkticketexists.ticketExists(ticketId);
			
			if(result == true)
			{
				inputoutputhandler.displayMethod("Write comment you want to post");
				commentString = inputoutputhandler.input();
				commentPostResult=postcomment.postCommentOnticket(ticketId,employeeID, commentString);
				if(commentPostResult==true)
				{
					inputoutputhandler.displayMethod("true");
				}
				else
				{
					inputoutputhandler.displayMethod("false");
				}
			}
			else
			{
				inputoutputhandler.displayMethod("Ticket with " + ticketId + "does not exists. Please provide valid ticketId.");
			}
		}while(true);
	
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
 
	}
}