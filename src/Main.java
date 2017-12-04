import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8'/>");
            writer.println("<title>Java demo app</title>");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/animation.css' />");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/default.css' />");
            writer.println("</head>");
            writer.println("<body class='body'>");
            writer.println("<div class='noContainer'>");
            writer.println("<h1 class='verticalShit'>" + request.getParameter("submit")+", stop fiddling around and do your job!</h1>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8' />");
            writer.println("<title>Java demo app</title>");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/animation.css' />");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/default.css' />");
            writer.println("</head>");
            writer.println("<body class='body'>");
            writer.println("<div class='noContainer'>");
            writer.println("<h1 class='verticalShit'>Now You Can Go And Fuck Yourself</h1>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
