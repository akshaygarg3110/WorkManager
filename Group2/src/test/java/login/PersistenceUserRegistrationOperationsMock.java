package login;
import login.Interfaces.*;
public class PersistenceUserRegistrationOperationsMock implements IPersistenceUserRegistrationOperations
{
    public boolean registerUserDatabase(IParameterizedUser user, String user_password)
    {
        return user.getEmployeeID().equals("111");
    }

    public boolean checkDuplicateEmployeeID(String employeeID)
    {
        return !employeeID.equals("111");
    }
}
