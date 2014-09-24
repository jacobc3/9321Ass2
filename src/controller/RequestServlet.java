package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import model.bean.*;

/**
 * Servlet implementation class RequestServlet
 */

public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello!");
		String url = request.getRequestURL().toString();
		PrintWriter out = response.getWriter();
		System.out.println("url is\t" + url );
		if (url.matches("(.*)/index")) {
			System.out.println("in index");
			List<Cinema> cinemas = DataHandler.getCinemas();
			request.setAttribute("cinemas", cinemas);
			List<Movie> movies = DataHandler.getMovies();
			request.setAttribute("movies", movies);
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		} else if (url.matches("(.*)/movie_detail(.*)")) {
			System.out.println("in movie detail");
			int movie_id = Integer.parseInt(request.getParameter("id"));
			System.out.println("movie_id is "+ movie_id);
			
			RequestDispatcher view = request.getRequestDispatcher("movie_detail.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
