package Filter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserRoleRequest implements HttpServletRequest {
    public UserRoleRequest(String name, List<String> roles, HttpServletRequest request) {
    }
}
