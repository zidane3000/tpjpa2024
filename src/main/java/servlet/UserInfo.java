package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import bdd.ConnexionBDD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",
        urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {

    // Récupération des données et affichage de la page HTML
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Connexion à la base de données
        try (Connection conn = ConnexionBDD.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT name, firstname, age FROM user_info";
            ResultSet rs = stmt.executeQuery(sql);

            out.println("<HTML>\n<BODY>\n" +
                    "<H1>Recapitulatif des informations</H1>\n" +
                    "<UL>\n");

            while (rs.next()) {
                String name = rs.getString("name");
                String firstname = rs.getString("firstname");
                int age = rs.getInt("age");

                out.println(" <LI>Nom: " + name + "\n" +
                        " <LI>Prenom: " + firstname + "\n" +
                        " <LI>Age: " + age + "\n");
            }

            out.println("</UL>\n" +
                    "<H2>Ajouter un nouvel utilisateur</H2>\n" +
                    "<FORM METHOD='POST' ACTION='/UserInfo'>\n" +
                    "Nom: <input type='text' name='name'><br>\n" +
                    "Prénom: <input type='text' name='firstname'><br>\n" +
                    "Âge: <input type='text' name='age'><br>\n" +
                    "<input type='submit' value='Ajouter'>\n" +
                    "</FORM>\n" +
                    "</BODY></HTML>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");
        String age = request.getParameter("age");

        try (Connection conn = ConnexionBDD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO user_info (name, firstname, age) VALUES (?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setString(2, firstname);
            pstmt.setInt(3, Integer.parseInt(age));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Redirection vers la page d'affichage après insertion
        response.sendRedirect("/UserInfo");
        /*
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("name") + "\n" +
                " <LI>Prenom: "
                + request.getParameter("firstname") + "\n" +
                " <LI>Age: "
                + request.getParameter("age") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");

         */
    }
}
