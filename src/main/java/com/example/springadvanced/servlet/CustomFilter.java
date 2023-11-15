package com.example.springadvanced.servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/custom-servlet")
public class CustomFilter implements Filter{
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {

        String nameLoc = (String) request.getParameter("name");
        System.out.println("Filtering : " + nameLoc);
        if (nameLoc == null || nameLoc.contains("ali")) {
            HttpServletResponse responseLoc = (HttpServletResponse) response;
            responseLoc.addHeader("Content-Type",
                    "text/plain;charset=UTF-8");
            responseLoc.getWriter()
                    .println("Name boş veya ali olamaz! ");
            return;
        }
        chain.doFilter(request,
                response);
    }

    @Override
    public void destroy() {
    }
}
