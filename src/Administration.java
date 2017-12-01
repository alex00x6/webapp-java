import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Administration")
public class Administration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String form = request.getParameter("submit");
        new FileHandler().addToFile("abuses.txt", form);
        response.sendRedirect(request.getContextPath() +"/administration");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset='UTF-8' />");
            writer.println("<title>MyServlet.java:doGet(): Servlet code!</title>");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles/animation.css' />");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/styles/default.css' />");
            writer.println("<script src='"+ request.getContextPath() + "/resources/onclick.js'></script>");
            writer.println("</head>");
            writer.println("<body class='body'>");
            writer.println("<div class='container'>");
            writer.println("<form action=\"" + request.getContextPath() +"/FileInteract\" method=\"get\" style=\"display: flex; justify-content: center; margin: 10px;\">");
            writer.println("<button type=\"submit\">Click here to view abuses</button>");
            writer.println("</form>");
            writer.println("<form action=\"" + request.getContextPath() +"/FileInteract\" method=\"post\" style=\"display: flex; justify-content: center; margin: 10px;\">");
            writer.println("<button type=\"submit\">Click here to receive file with abuses</button>");
            writer.println(" </form>");
            writer.println("<form action=\"" + request.getContextPath() +"/administration\" method=\"post\" style=\"display: flex; justify-content: center; margin: 10px;\">");
            writer.println("<input type=\"text\" name=\"submit\" placeholder=\"Type your abuse here\" style=\"width: 300px;\">");
            writer.println("<button type=\"submit\">Submit abuse to list</button>");
            writer.println("</form>");
            writer.println("<form style=\"display: flex; justify-content: center; margin: 10px;\">");
            writer.println("<button onclick=\"put()\">Reset abuses to defaults</button>");
            writer.println("</form>");
            writer.println("<form onclick=\"location.href='/'\" style=\"display: flex; justify-content: center; margin: 10px;\">");
            writer.println("<input type='button' value='Go to main page'>");
            writer.println("</form>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new FileHandler().makeFile("abuses.txt", new Random().russianAbuses());

    }
}
