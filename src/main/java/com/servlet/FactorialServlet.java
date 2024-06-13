package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//this
@WebServlet("/factorailCalculation")
public class FactorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String num1=request.getParameter("num"); //"6"
		
		int num=Integer.parseInt(num1);   //"6"  ---->6
		
		int fact=1;
		
		for(int x=1;x<=num;x++) {
			
			fact=fact*x;  //fact=1*1=1      fact=1*2=2    fact=2*3=6     fact=6*4=24      fact=24*5=120     fact=120*6=720   
			
		}
		System.out.println("factorail of"+num+"="+fact);  //factorial of 6 = 720
		//request scope
		//request.setAttribute("value", fact);  //here we have keep our data in request scope
		//request.getRequestDispatcher("fact.jsp").forward(request, response);
		
		
		//session scope
		HttpSession session=request.getSession(); //30 minutes
		//getSession(); //hey, give me the existing session. If not exist, then create fresh session and give it to me.                      
		//getSession(false); //hey, give me the existing session. If not exist, then don't create fresh session for me..    
		
		
		session.setAttribute("value", fact); //here we have keep our data in session scope
		//request.getRequestDispatcher("fact.jsp").forward(request, response);
		
		
		//application scope 
		ServletContext applicationScope=request.getServletContext();
		applicationScope.setAttribute("value", fact);
		request.getRequestDispatcher("fact.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
