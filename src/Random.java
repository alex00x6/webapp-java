import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(name = "Random")
public class Random extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
            writer.println("</head>");
            writer.println("<body class='body'>");
            writer.println("<div class='noContainer'>");
            writer.println("<h1 class='verticalShit'>"+generateRandomFuck()+"</h1>");
            writer.println("</div>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    private String generateRandomFuck(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Обратите внимание - плинтус. И запомните,это именно ваш уровень.");
        list.add("Бьюсь об заклад, что вас зачали на спор!");
        list.add("Да, красотою мир вы не спасёте.");
        list.add("Если бы у тупости были крылья, вы бы порхали как мотылек.");
        list.add("Я б вас послал, да вижу - вы оттуда.");
        list.add("Из положительных качеств у тебя только 'резус-фактор'...");
        list.add("Хочешь быть полезным? Запросто! Возьми веревку и повесся в углу!");
        list.add("Когда аист принёс тебя твоим родителям - они долго смеялись и хотели сначала взять аиста.");

        return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
    }
}
