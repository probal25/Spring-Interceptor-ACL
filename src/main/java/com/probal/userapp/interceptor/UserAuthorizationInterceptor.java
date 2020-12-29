package com.probal.userapp.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class UserAuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        String requestedUrl = request.getRequestURI();


        if (requestedUrl.equals("/login") || requestedUrl.equals("/register")) {
            return true;
        }
        else if(requestedUrl.equals("/admin")) {
            if(session.getAttribute("user_role") != null) {
                List<String> role = (List<String>) session.getAttribute("user_role");
                if (role.contains("ADMIN")){
                    System.out.println("From preHandle() : accessed" +"\n"
                            + "From preHandle --> " + session.getId() + "\n"
                            + "From preHandle --> " + session.getAttribute("user_role"));
                    return true;
                }
                else {
                    System.out.println("Access denied" + "\n" + "From preHandle --> "
                            + session.getId() + "\n" + "From preHandle --> "
                            + session.getAttribute("user_role"));
                    response.getWriter().write("This Page can only be accessed by ADMIN only");
                    return false;
                }
            }
            else {
                System.out.println("User not logged in");
                response.sendRedirect("login");
            }
        }
        else if(requestedUrl.equals("/user")) {
            if(session.getAttribute("user_role") != null) {
                List<String> role = (List<String>) session.getAttribute("user_role");
                if (role.contains("ADMIN") || role.contains("USER")){
                    System.out.println("From preHandle() : accessed" +"\n"
                            + "From preHandle --> " + session.getId() + "\n"
                            + "From preHandle --> " + session.getAttribute("user_role"));
                    return true;
                }
                else {
                    System.out.println("Access denied" + "\n" + "From preHandle --> "
                            + session.getId() + "\n" + "From preHandle --> "
                            + session.getAttribute("user_role"));
                    return false;
                }
            }
            else {
                System.out.println("User logged out");
                response.sendRedirect("login");
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
