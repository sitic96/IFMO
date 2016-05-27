import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sitora on 27.03.16.
 */

public class AreaCheckServlet extends HttpServlet {
    private double x, y, r;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            x = Double.parseDouble(req.getParameter("xValue"));
            y = Double.parseDouble(req.getParameter("yValue"));
            r = Double.parseDouble(req.getParameter("rValue"));
            if (x < -5 || x > 3 || r < 2 || r > 5) {
                throw new Exception();
            }

            boolean result = this.isInArea(x, y, r);
            PrintWriter pw = resp.getWriter();
            pw.print("<!DOCTYPE HTML>\n" +
                    "<html>\n" +
                    "\t\n" +
                    "<head>\n" +
                    "\t<title> Lab 7 </title>\n" +
                    "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" >\n" +
                    "\t<meta name=\"keywords\" content=\"lab6\"> \n" +
                    "\t<meta name=\"description\" content=\"Программная инженерия, Гулямова Ситора\"> \n" +
                    "\t<link type=\"text/css\" rel=\"stylesheet\" href=\"main.css\" />\n" +
                    "</head>\n" +
                    "\n" +
                    "\n" +
                    "<body>\n" +
                    "\t\n" +
                    "\t<header>\n" +
                    "\t\tGulyamova\n" +
                    "\t\tP3217\n" +
                    "\t</header>\n" +
                    "\t\n" +
                    "\t<div class=\"graphDiv\"> \n" +
                    "\t\t<img src=\"img/area.png\"/>\n" +
                    "\t</div>\n" +
                    "\t\n" +
                    "\t<div class=\"resultDiv\"> \n" +
                    "\t\t<p> Result:   </p> \n" +
                    "\t\t\n" +
                    "\t\t<div class=\"answerResult\">\n" +
                    "\t\t\tanswer: \n" +
                    result +
                    "\t\t</div>\n" +
                    "\t\t\n" +

                    "\t</div>\n" +
                    "\t\n" +
                    "\t<div style=\"clear: both\"> </div>\n" +
                    "\t\n" +
                    "\t<a href=\"main\" style=\"\">\n" +
                    "\t\t<div id=\"onceMore\">\n" +
                    "\t\t\tTry again\n" +
                    "\t\t</div>\n" +
                    "\t</a>\n" +
                    "\t\n" +
                    "</body>\n" +
                    "\n" +
                    "\n" +
                    "</html>");
        } catch (Exception e) {
            PrintWriter pw = resp.getWriter();
            pw.print("<!DOCTYPE HTML>\n" +
                    "<html>\n" +
                    "\t\n" +
                    "<head>\n" +
                    "\t<title> Lab 7 </title>\n" +
                    "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" >\n" +
                    "\t<meta name=\"keywords\" content=\"lab6\"> \n" +
                    "\t<meta name=\"description\" content=\"Программная инженерия, Гулямова Ситора\"> \n" +
                    "\t<link type=\"text/css\" rel=\"stylesheet\" href=\"main.css\" />\n" +
                    "</head>\n" +
                    "\n" +
                    "\n" +
                    "<body>\n" +
                    "\t\n" +
                    "\t<header>\n" +
                    "\t\tGulyamova\n" +
                    "\t\tP3217\n" +
                    "\t</header>\n" +
                    "\t\n" +
                    "\t<div class=\"graphDiv\"> \n" +
                    "\t\t<img src=\"img/area.png\"/>\n" +
                    "\t</div>\n" +
                    "\t\n" +
                    "\t<div class=\"resultDiv\"> \n" +
                    "\t\t<p> Result:   </p> \n" +
                    "\t\t\n" +
                    "\t\t<div class=\"answerResult\">\n" +
                    "\t\t\tanswer: \n" + "Error"+e.toString()+
                    "\t\t</div>\n" +
                    "\t\t\n" +

                    "\t</div>\n" +
                    "\t\n" +
                    "\t<div style=\"clear: both\"> </div>\n" +
                    "\t\n" +
                    "\t<a href=\"main\" style=\"\">\n" +
                    "\t\t<div id=\"onceMore\">\n" +
                    "\t\t\tTry again\n" +
                    "\t\t</div>\n" +
                    "\t</a>\n" +
                    "\t\n" +
                    "</body>\n" +
                    "\n" +
                    "\n" +
                    "</html>");

        }
    }

    private boolean isInArea(double x, double y, double r) {
        if (x >= 0 && y >= 0 && y <= -x + r / 2) {
            return true;
        } else if (x <= r && y >= -r && y <= 0 && x >= 0) return true;
        else if ((x * x + y * y) <= r * r / 4 && x <= 0 && y <= 0) return true;
        else return false;
    }
}