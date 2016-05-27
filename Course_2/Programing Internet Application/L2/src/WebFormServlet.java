import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sitora on 30.03.16.
 */
public class WebFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "\t\n" +
                "<head>\n" +
                "<script>" +
                "function checkYValue() {\n" +
                "\t debugger;\n" +
                "\tif((isInt(document.getElementById(\"rValue\").value))&&(isInt(document.getElementById(\"xValue\").value)))\n" +
                "\t\t  {\n" +
                "\t\t\t  if(document.getElementById(\"rValue\").value>2&&document.getElementById(\"rValue\").value<5&&\n" +
                "\t\t\t\tdocument.getElementById(\"xValue\").value>-5&&document.getElementById(\"xValue\").value<3)\n" +
                "\t\t\t  {\n" +
                "\t\t\t  document.getElementById(\"btn\").disabled = false;\n" +
                "\t\t\t  }\n" +
                "\t\t\t  else {\n" +
                "\t\tdocument.getElementById(\"rValue\").style.borderColor = \"red\";\n" +
                "\t\tdocument.getElementById(\"rValue\").style.backgroundColor = \"#F5A9A9\";\n" +
                "\t\tdocument.getElementById(\"xValue\").style.borderColor = \"red\";\n" +
                "\t\tdocument.getElementById(\"xValue\").style.backgroundColor = \"#F5A9A9\";\n" +
                "\t\tdocument.getElementById(\"btn\").disabled = true;}\n" +
                "\t}\n" +
                "\telse {\n" +
                "\t\tdocument.getElementById(\"rValue\").style.borderColor = \"red\";\n" +
                "\t\tdocument.getElementById(\"rValue\").style.backgroundColor = \"#F5A9A9\";\n" +
                "\t\tdocument.getElementById(\"xValue\").style.borderColor = \"red\";\n" +
                "\t\tdocument.getElementById(\"xValue\").style.backgroundColor = \"#F5A9A9\";\n" +
                "\t\tdocument.getElementById(\"btn\").disabled = true;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function isInt(value) {\n" +
                "  return !isNaN(value) && \n" +
                "         parseFloat(Number(value)) == value && \n" +
                "         !isNaN(parseFloat(value, 10));\n" +
                "}\n" +
                "\n" +
                "function submit() {\n" +
                "\tif(!checkYValue)\n" +
                "\t{\n" +
                "\t\talert(\"Mistake in Y value!\");\n" +
                "\t\treturn false;\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "function XValue(x) {\n" +
                "\talert(\"a\");\n" +
                "document.getElementById(\"x\").value = x.value;\n" +
                "}\n" +
                "\n" +
                "function RValue(r) {\n" +
                "\talert(\"b\");\n" +
                "document.getElementById(\"r\").value = r.value;\n" +
                "}" +
                "</script" +
                "\t<title> Lab 1 </title>\n" +
                "\t<script type=\"text/javascript\" src=\"script.js\"></script>\n" +
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
                "\t\t<br>\n" +
                "\t\tP3217\n" +
                "\t</header>\n" +
                "\t\n" +
                "\t<form method=\"get\" accept-charset=\"utf-8\">\n" +
                "\t\t\n" +
                "\t<div class=\"graphDiv\"> \n" +
                "\t\t<img src=\"http://i11.pixs.ru/storage/9/2/9/Kopiyaarea_6266523_21732929.png\"/>\n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div class=\"changeRDiv\"> \n" +
                "\t\t<p> Change   your R:  </p>\n" +
                "\t\t<input onblur=\"checkYValue()\" type=\"text\" id=\"rValue\" name=\"rValue\" value=\"4\"> \n" +
                "\t</div>\n" +

                "\t\n" +
                "\t<div class=\"changeXDiv\"> \n" +
                "\t\t<p> Change   your X:  </p>\n" +
                "\t\t<input type=\"text\" onblur=\"checkYValue()\" id=\"xValue\" name=\"xValue\" value=\"0\"> \n" +
                "\t</div>\n" +
                "\t\n" +
                "\t<div class=\"changeYDiv\"> \n" +
                "\t\t<p> Change   your Y:  </p>\n" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"-4\"> -4" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"-3\"> -3" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"-2\"> -2" +
                "\t\t<input type=\"radio\" name=\"yValue\" checked=\"checked\" value=\"-1\"> -1 " +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"0\"> 0" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"1\"> 1" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"2\"> 2" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"3\"> 3" +
                "\t\t<input type=\"radio\" name=\"yValue\" value=\"4\"> 4" +
                "\t</div>\n" +
                "\t\n" +
                "\t<input onclick=\"return submit()\" id=\"btn\" type=\"submit\" style=\"width:200px; margin-left: 75px; margin-top: 20px;\">\n" +
                "\t\n" +
                "\t</form>\n" +
                "\t\n" +
                "</body>\n" +
                "\n" +
                "\n" +
                "</html>");
    }
}
