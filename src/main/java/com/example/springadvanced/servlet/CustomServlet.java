package com.example.springadvanced.servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/custom-servlet")
public class CustomServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req,
                         final HttpServletResponse resp) throws ServletException, IOException {
        String[] namesLoc = req.getParameterValues("name");
        resp.addHeader("Content-Type", "text/plain;charset=UTF-8");
        resp.getWriter().println("Cevap verildi : " + Arrays.toString(namesLoc));

    }
}
