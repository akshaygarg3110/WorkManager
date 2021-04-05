package sortTicketTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IdisplayTicket;
import sortTickets.interfaces.IsortTicket;

public class sortTicketMock implements IsortTicket
{
	Map<String, ArrayList<String>> ticketsData ;
	List<String> columnOfTable;
	
	IreuseableClassFactory reuseableclassfactory = reuseableClassFactory.instance();
	ITableGenerator tableformate = reuseableclassfactory.tableFormate();
	IdisplayTicket displayuser=reuseableclassfactory.displayUser(tableformate);
	
	
	public sortTicketMock()
	{
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
		columnOfTable = new ArrayList<String>();
	}
	
	public String sortTickets(int choice)
	{
		String output="";
		addColumnsOfTable();
		if(choice ==1)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("develope bugd free login functionality");
			ticketsData.get("111").add("2021-03-15");
			ticketsData.get("111").add("2021-03-30");
			ticketsData.get("111").add("EMP12");
			ticketsData.get("111").add("EMP123");
			ticketsData.get("111").add("Tejasw");
			ticketsData.get("111").add("bug");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("3");
			
			
			ticketsData.put("123", new ArrayList<String>());
			ticketsData.get("123").add("develope bugd free login functionality");
			ticketsData.get("123").add("2021-03-15");
			ticketsData.get("123").add("2021-03-30");
			ticketsData.get("123").add("EMP12");
			ticketsData.get("123").add("EMP123");
			ticketsData.get("123").add("Tejasw");
			ticketsData.get("123").add("bug");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("3");
			

		}
		else if (choice ==2)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("develope bugd free login functionality");
			ticketsData.get("111").add("2021-03-15");
			ticketsData.get("111").add("2021-03-30");
			ticketsData.get("111").add("EMP12");
			ticketsData.get("111").add("EMP123");
			ticketsData.get("111").add("Tejasw");
			ticketsData.get("111").add("bug");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("1");
			
			
			ticketsData.put("123", new ArrayList<String>());
			ticketsData.get("123").add("develope bugd free login functionality");
			ticketsData.get("123").add("2021-03-15");
			ticketsData.get("123").add("2021-03-30");
			ticketsData.get("123").add("EMP12");
			ticketsData.get("123").add("EMP123");
			ticketsData.get("123").add("Tejasw");
			ticketsData.get("123").add("bug");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("2");
			

		}
		else if (choice ==3)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("develope bugd free login functionality");
			ticketsData.get("111").add("2021-03-15");
			ticketsData.get("111").add("2021-03-30");
			ticketsData.get("111").add("EMP12");
			ticketsData.get("111").add("EMP123");
			ticketsData.get("111").add("Tejasw");
			ticketsData.get("111").add("bug");
			ticketsData.get("111").add("1");
			ticketsData.get("111").add("3");
			
			
			ticketsData.put("123", new ArrayList<String>());
			ticketsData.get("123").add("develope bugd free login functionality");
			ticketsData.get("123").add("2021-03-15");
			ticketsData.get("123").add("2021-03-30");
			ticketsData.get("123").add("EMP12");
			ticketsData.get("123").add("EMP123");
			ticketsData.get("123").add("Tejasw");
			ticketsData.get("123").add("bug");
			ticketsData.get("123").add("2");
			ticketsData.get("123").add("3");
		

		}
		output = displayuser.printTicketsDetails(ticketsData,columnOfTable);
		return output;
	}
	
	private void addColumnsOfTable() {
		columnOfTable.add("ticketId");
		columnOfTable.add("description");
		columnOfTable.add("startDate");
		columnOfTable.add("endDate");
		columnOfTable.add("reporterId");
		columnOfTable.add("employeeId");
		columnOfTable.add("assigneeName");
		columnOfTable.add("ticketType");
		columnOfTable.add("priority");
		columnOfTable.add("urgency");
		
	}	

}
