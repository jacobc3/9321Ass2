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

import model.bean.*;
import model.handler.*;

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//TODO modify between doGet & doPost
		System.out.println("Hello! HERE IS GET");
		String url = request.getRequestURL().toString();
		PrintWriter out = response.getWriter();
		System.out.println("url is\t" + url);
		
		
		if (url.matches("(.*)/index")) {
			this.index(request, response);
			
			
		} else if (url.matches("(.*)/movie_detail(.*)")) {
			this.movieDetail(request, response);
		} else if (url.matches("(.*)/new_user(.*)")) {
			this.newUser(request, response);
		} else if (url.matches("(.*)/edit_user(.*)")) {
			this.editUser(request, response);
		}  else if (url.matches("(.*)/user_detail(.*)")) {
			this.userDetail(request, response);
		} else if (url.matches("(.*)/owner_detail(.*)")) {
			this.ownerDetail(request, response);
		}  else if (url.matches("(.*)/login(.*)")) {
			this.login(request, response);
		} else if (url.matches("(.*)/confirm_registration(.*)")) {
			this.confirmRegistration(request, response);
		} 
			
		 else if (url.matches("(.*)/new_movie(.*)")) {
			this.newMovie(request, response);
		} else if (url.matches("(.*)/edit_movie(.*)")) {
			this.editMovie(request, response);
		}else if (url.matches("(.*)/movie_detail(.*)")) {
			this.movieDetail(request, response);
				
				
			
			
		} else if (url.matches("(.*)/new_booking(.*)")) {
			this.newBooking(request, response);
		} else if (url.matches("(.*)/approve_booking(.*)")) {
			this.approveBooking(request, response);
		} else if (url.matches("(.*)/decline_booking(.*)")) {
			this.declineBooking(request, response);
			
		} else if (url.matches("(.*)/new_cinema(.*)")) {
			this.newCinema(request, response);
		} else if (url.matches("(.*)/edit_cinema(.*)")) {
			this.editCinema(request, response);
			
			
		} else if (url.matches("(.*)/search(.*)")) {
			this.search(request, response);
			
			
		} else if (url.matches("(.*)/new_review(.*)")) {
			this.newReview(request, response);
		} else if (url.matches("(.*)/edit_review(.*)")) {
			this.editReview(request, response);
		} 
		 else if (url.matches("(.*)/new_session(.*)")) {
			this.newSession(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//TODO modify between doGet & doPost
		System.out.println("Hello! HERE IS POST");
		String url = request.getRequestURL().toString();
		PrintWriter out = response.getWriter();
		System.out.println("url is\t" + url);
		
		
		if (url.matches("(.*)/index")) {
			this.index(request, response);
			
			
		} else if (url.matches("(.*)/movie_detail(.*)")) {
			this.movieDetail(request, response);
		}
	}
	
	
	private void newSession(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void editReview(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void newReview(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void editCinema(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void newCinema(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void newBooking(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void newMovie(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void confirmRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void ownerDetail(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void declineBooking(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void approveBooking(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void editMovie(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void editUser(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}



	private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in index");
		List<Cinema> cinemas = DataHandler.getCinemas();
		request.setAttribute("cinemas", cinemas);
		List<Movie> movies = DataHandler.getMovies();
		request.setAttribute("movies", movies);
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}

	private void newUser(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO
	}

	private void movieDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in movie detail");
		int movie_id = Integer.parseInt(request.getParameter("id"));
		System.out.println("movie_id is " + movie_id);

		RequestDispatcher view = request
				.getRequestDispatcher("movie_detail.jsp");
		view.forward(request, response);
	}
}
