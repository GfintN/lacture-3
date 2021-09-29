package by.it.academy.example.tomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet1", urlPatterns = "/servletAnnotation")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Count counter = new Count();
        counter.AddCount();
        PrintWriter writer = resp.getWriter();
        writer.println("All pages was visited " + counter.SumCountServlet1AndServlet2() + " times." + "\n" +
                "Name of current Thread :" + Thread.currentThread().getName());

    }
}
