package employeePerformance.abstractFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import employeePerformance.EmployeeEfficiencyCalculator;
import employeePerformance.EmployeePerformanceDB;
import employeePerformance.EmployeeProductivityCalculator;
import employeePerformance.ExportEmployeePerformanceReport;
import employeePerformance.GenerateEmployeePerformanceReport;
import employeePerformance.InputEmployeeDetails;
import employeePerformance.UserInputEmployeePerformance;
import employeePerformance.Interfaces.IBarChartGeneration;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IExportEmployeePerformanceReport;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.Interfaces.ITableGenerator;
import employeePerformance.Interfaces.IUserInputEmployeePerformance;
import userinterface.IInputOutputHandler;

public class EmployeePerformanceFactory implements IEmployeePerformanceFactory
{ 
	private static IEmployeePerformanceFactory uniqueInstance = null;

    private EmployeePerformanceFactory()
    {
    	
    }

    public static IEmployeePerformanceFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new EmployeePerformanceFactory();
        }
        return uniqueInstance;
    }
    
	public IInputEmployeeDetails userInput(String date, String employeeId) 
	{
		return new InputEmployeeDetails(date, employeeId);
	}
	
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails) 
	{	
		return new EmployeePerformanceDB(inputEmployeeDetails);
	}

	public IGenerateEmployeePerformanceReport getPerformanceReport () 
	{	
		return new GenerateEmployeePerformanceReport();
	}
	
	public IEmployeeEfficiencyCalculator getEmployeeEfficiencyCalculator(ResultSet resultset) 
	{
		return new EmployeeEfficiencyCalculator(resultset);
	}
	
	public IEmployeeProductivityCalculator getEmployeeProductivityCalculator(ResultSet resultset)
	{
		return new EmployeeProductivityCalculator(resultset);
	}
	
	public IUserInputEmployeePerformance userinputemployee()
	{
		return new UserInputEmployeePerformance();
	}
	
	public IExportEmployeePerformanceReport getExportEmployeePerformanceReport(IInputOutputHandler inputOutputHandler, ArrayList<String> employeeEfficiency) 
	{
		return new ExportEmployeePerformanceReport(inputOutputHandler, employeeEfficiency);
	}
}