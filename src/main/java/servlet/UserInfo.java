package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo", urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Recapitulatif des informations</h1>");
        out.println("<ul>");
        out.println("<li>Nom: " + request.getParameter("name") + "</li>");
        out.println("<li>Prenom: " + request.getParameter("firstname") + "</li>");
        out.println("<li>Age: " + request.getParameter("age") + "</li>");
        out.println("</ul>");
        out.println("</body></html>");
    }
}

