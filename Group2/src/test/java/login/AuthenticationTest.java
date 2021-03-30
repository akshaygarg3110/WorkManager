package login;
import login.abstractFactory.LoginFactoryTest;
import login.abstractFactory.LoginFactoryTestImplementation;
import org.junit.Before;
import org.junit.Test;
import userinterface.*;
import static org.junit.Assert.*;
import login.Interfaces.*;
public class AuthenticationTest
{
    LoginFactoryTest loginFactoryTest = new LoginFactoryTestImplementation();
    IAuthenticationOperations authenticationOperations;

    @Before
    public void initialize()
    {
        authenticationOperations = loginFactoryTest.getAuthenticationOperationsMock();
    }



    @Test
    public void authenticateUserTestSuccessfull()
    {
        Authentication authentication = new Authentication(authenticationOperations);
        assertTrue("Test failed", authentication.authenticateUser("111", "Abcd@123"));
    }
    
    @Test
    public void authenticateUserTestUnsuccessfull()
    {
        Authentication authentication = new Authentication(authenticationOperations);
        assertFalse("Test failed", authentication.authenticateUser("112", "Abcd@12345"));
    }
}