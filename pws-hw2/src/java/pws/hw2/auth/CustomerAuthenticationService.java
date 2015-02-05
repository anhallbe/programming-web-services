package pws.hw2.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "CustomerAuthenticationService",
        portName = "CustomerAuthenticationPort",
        targetNamespace = "pws.hw2/auth")
public class CustomerAuthenticationService {
    
    private Map<String, String> registeredUsers;
    
    public CustomerAuthenticationService() {
        super();
        registeredUsers = new HashMap<>();
        registeredUsers.put("user1", "password1");
    }
    
    /**
     * Asks the service to authenticate by checking the provided user/password combination.
     * @param userID
     * @param password
     */
    @WebMethod(operationName = "authenticate")
    public boolean authenticate(@WebParam(name = "userID") String userID, @WebParam(name = "password") String password) {
        return registeredUsers.getOrDefault(userID, "").equals(password);
    }
}
