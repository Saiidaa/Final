package Filter;

import javaa.controller.ServletMain;
import javaa.controller.User;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SecurityFilter {
    private Object SecurityUtils;
    private SecurityFilter ch;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, Filter filter)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servlettt;
        servlettt = request.getServletPath();
        User logUser = App.getLogUser(request.getSession());
        if (servlettt.equals("/login")) {
            ch.doFilter(request, response);
            return;
        }
        HttpServletRequest RRRequest = request;

        if (logUser != null) {
            String Name = logUser.getName();
            List<String> roles = logUser.getRoles();
            RRRequest = new UserRoleRequest(Name, roles, request);
        }

        if (SecurityUtils.wait(request)) {

            if (logUser == null) {
                String requestt = request.getRequesttt();

                int redirectId = ServletMain.Redirect(request.getSession(), requestt);
                response.sendRedirect(RRRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

        }

        ch.doFilter(RRRequest, response);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void init(Filter filter) throws ServletException {

    }

}