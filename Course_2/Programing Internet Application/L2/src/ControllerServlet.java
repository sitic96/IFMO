import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RequestDispatcher rd;
        if (req.getParameter("xValue") != null && req.getParameter("yValue") != null && req.getParameter("rValue") != null) {
            req.getRequestDispatcher("/area").forward(req, resp);
            //rd.forward(req, resp);
        } else if (req.getParameter("xValue") != null || req.getParameter("yValue") != null || req.getParameter("rValue") != null) {
            //Возвращаем сообщение об ошибке
        } else {
            req.getRequestDispatcher("/web").forward(req, resp);
        }
        resp.setContentType("text/html;charset=utf-8");


        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Ты сделал что то не так!</H1>");

    }
}
