package employeePerformance.abstractfactory;

import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import userinterface.IInputOutputHandler;

public interface IEmployeePerformanceFactoryTest 
{
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails, IFetchedPerformanceDetails fetchedPerformanceDetails, IInputOutputHandler inputOutputHandler);

	public IGenerateEmployeePerformanceReport getPerformanceReport (IInputOutputHandler inputOutputHandler);
	
	public IEmployeeEfficiencyCalculator getEmployeeEfficiencyCalculator(IInputOutputHandler inputOutputHandler);
	
	public IEmployeeProductivityCalculator getEmployeeProductivityCalculator(IInputOutputHandler inputOutputHandler);
	
	public IInputEmployeeDetails userInput(String date, String employeeId);

	public IFetchedPerformanceDetails fetchedPerformanceDetails(String ticketLevel, String count, String startDate, String expectedEndDate, String endDate, double workingHours);

}
