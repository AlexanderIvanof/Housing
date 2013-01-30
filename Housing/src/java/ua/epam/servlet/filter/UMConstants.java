package ua.epam.servlet.filter;

/**
 * Constants to get type user and home page
 * 
 * @author Alexandr Ivanov
 */
public interface UMConstants {

    String REDIRECT_URL = "RedirectURL";
    String LOGIN_PAGE = "LoginURL";
    String HOME_URL = "HomeURL";
    // this session  attribute will indicate that user authorized and hold the name of user
    String USER_TYPE = "UserType";
    String PRINCIPAL = "Principal";
    String ERRORMESSAGE = "ErrorMessage";
}
