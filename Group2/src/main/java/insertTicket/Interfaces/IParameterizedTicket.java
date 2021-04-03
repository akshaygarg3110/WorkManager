package insertTicket.Interfaces;

import java.text.ParseException;
import java.util.Date;

public interface IParameterizedTicket {
    
	public String getTicketID(); 
    public String getDescription();    
    public Date getExpectedEndDate() throws ParseException;
    public String getReporterID();
    public String getEmployeeID();
    public String getAssigneeName();
    public String getTicketType();
    public String getTicketStatus();
    public int getPriority();
    public int getUrgency();
    public int getImpact();
    public String getTicketLevel();
    public String getCustomerID();
    public String getCustomerName();
    public String getCreatorID();
    public String getCreatorName();   
}