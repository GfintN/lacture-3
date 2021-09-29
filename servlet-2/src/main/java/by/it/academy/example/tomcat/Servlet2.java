package by.it.academy.example.tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Count countGet = new Count();
        countGet.AddGetCount();
        PrintWriter writer = resp.getWriter();
        writer.println("Page was get " + countGet.ReadGetCountServlet2() + " times." + "\n"
                + "Name of current Thread: " + Thread.currentThread().getName());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Count countGet = new Count();
        countGet.AddPostCount();
        PrintWriter writer = resp.getWriter();
        writer.println("Page was post"+ countGet.ReadPostCountServlet2() +" times." + "\n"
                + "Name of current Thread: " + Thread.currentThread().getName());
    }
}





