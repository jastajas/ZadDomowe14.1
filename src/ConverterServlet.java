import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Double> values = Converters.weightConverter(req);
        String units = "weight";
        resopnsSend(resp, values, units);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Double> values = Converters.metricConverter(request);
        String units = "metric";
        resopnsSend(response, values, units);
    }

    private void resopnsSend(HttpServletResponse response, ArrayList<Double> values, String units) throws IOException {

        String a = "";
        String b = "";
        String c = "";

        if(units.equals("metric")){
            a = "metry";
            b = "centymetry";
            c = "milimetry";
        } else {
            a = "kilogramy";
            b = "gramy";
            c = "miligramy";
        }


        if (values.get(3) == 0) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.print("<h2>Podana wartość w przeliczeniu na:</h2>");
            writer.print("<div>");
            writer.printf("%s: %.4f <br/>", a, values.get(0));
            writer.printf("%s: %.4f <br/>", b , values.get(1));
            writer.printf("%s: %.4f <br/>", c, values.get(2));
            writer.print("</div>");
            writer.print("<form method=" + '"' + "get" + '"' + " action=" + '"' + "http://localhost:8080/" + '"' +">");
            writer.print ("<input type=" + '"' + "submit" + '"' + "value=" + '"' + "Powrót" + '"' + ">");
            writer.print("</form>");
            writer.println("</body>");
            writer.println("</html>");
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.print("<h2>Podana wartość to niewłaściwy typ danych.</h2>");
            writer.print("<form method=" + '"' + "get" + '"' + " action=" + '"' + "http://localhost:8080/" + '"' +">");
            writer.print ("<input type=" + '"' + "submit" + '"' + "value=" + '"' + "Powrót" + '"' + ">");
            writer.print("</form>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
