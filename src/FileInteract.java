import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "fileinteract")
public class FileInteract extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File downloadFile = new FileHandler().getFile("abuses.txt");
        FileInputStream inStream = new FileInputStream(downloadFile);
        // if you want to use a relative path to context root:
        // obtains ServletContext
        ServletContext context = getServletContext();
        // gets MIME type of the file
        String mimeType = context.getMimeType(downloadFile.getAbsolutePath());
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inStream.close();
        outStream.close();
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
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/animation.css' />");
            writer.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +  "/styles/default.css' />");
            writer.println("</head>");
            writer.println("<body class='body'>");
            writer.println("<div class='noContainer'>");
            writer.println("<h1>"+new FileHandler().readFromFile("abuses.txt")+"</h1>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
