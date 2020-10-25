package com.ashburnere.jakarta_ee_demo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashburnere.jakarta_ee_demo.entity.RequestMonitorTransient;

/**
 * Example for a simple Servlet which processes an input parameter.
 * 
 * @author Erik
 *
 */
@WebServlet(urlPatterns="/servlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	@Inject
	RequestMonitorTransient requestMonitorTransient;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	final String name = request.getParameter("name");
        response.getWriter().append(LocalDateTime.now() + "\nHello ").append(name).append("! How are you today?\n" + 
        		requestMonitorTransient.getRequestCount());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}