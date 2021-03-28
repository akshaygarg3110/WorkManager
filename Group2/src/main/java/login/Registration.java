package login;
import userinterface.IInputOutputHandler;
import login.Interfaces.*;
public class Registration implements IRegister
{
    private final IPersistenceUserRegistrationOperations userRegistrationOperations;
    private final IInputOutputHandler inputOutputHandler;
    private final IEncryption encryption;
    private boolean result = false;
    private IPasswordValidations passwordValidations = new PasswordValidations();

    public Registration(IPersistenceUserRegistrationOperations userRegistrationOperations, IInputOutputHandler inputOutputHandler, IEncryption encryption)
    {
        this.userRegistrationOperations = userRegistrationOperations;
        this.inputOutputHandler = inputOutputHandler;
        this.encryption = encryption;
    }

    public boolean registerUser(IParameterizedUser user, String user_password)
    {
        if(userRegistrationOperations.checkDuplicateEmployeeID(user.getEmployeeID()))
        {
            inputOutputHandler.displayMethod("Error: Duplicate employee ID found. Please use a different employee ID and try again.");
            result = false;
            return result;
        }
        else
        {
            if(passwordValidations.checkUpperCaseRule(user_password) &&
			   passwordValidations.checkLowerCaseRule(user_password) &&
			   passwordValidations.checkNumberRule(user_password) &&
			   passwordValidations.checkSpecialCharacterRule(user_password) &&
			   passwordValidations.checkLengthRule(user_password))
            {

                String encrypted_password = encryption.encryptPassword(user_password);
                result = userRegistrationOperations.registerUserDatabase(user, encrypted_password);
                return result;
            }
            else
            {
            	inputOutputHandler.displayMethod("Error: Password does not match the requirements. \nA password must be at least 8 characters, must contain a special character (@,!,#,$,%,&,*), must be 8 to 100 characters in length, must contain at least one lower case and one upper case letter");
                return result = false;
            }
        }
    }
}