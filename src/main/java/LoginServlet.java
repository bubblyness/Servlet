package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        if ("on".equals(rememberMe)) {
            String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
            Cookie cookie = new Cookie("username", encodedUsername);
            cookie.setMaxAge(60 * 60 * 24); // 1 day
            response.addCookie(cookie);
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome, " + username + "</h1>");
        out.println("<a href='profile'>Go to Profile</a>");
        out.println("</body></html>");
    }
}

