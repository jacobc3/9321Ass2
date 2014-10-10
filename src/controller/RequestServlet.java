package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.*;
import model.handler.*;
import model.handlerInterface.*;

import java.util.HashSet;
import java.util.Set;

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
		
		
		if (url.matches("(.*)/index(.*)")) {
			this.index(request, response);

		} else if (url.matches("(.*)/movie_detail(.*)")) {
			this.movieDetail(request, response);
		} else if (url.matches("(.*)/new_user(.*)")) {
			this.newUser(request, response);
		} else if (url.matches("(.*)/edit_user(.*)")) {
			this.editUser(request, response);
		}  else if (url.matches("(.*)/display_user(.*)")) {
			this.userDetail(request, response);
		} else if (url.matches("(.*)/display_owner(.*)")) {
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
		} else if (url.matches("(.*)/new_movie")) {
			this.newMovie(request, response);			 
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
		}else if (url.matches("(.*)/new_user(.*)")) {
			this.newUser(request, response);
		}else if (url.matches("(.*)/login(.*)")) {
			this.login(request, response);
		} else if (url.matches("(.*)/save_movie(.*)")) {
			this.saveMovie(request, response);
		} else if (url.matches("(.*)/save_review(.*)")) {
			this.saveReview(request, response);
		} 
	}
	
	
	private void saveReview(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ReviewHandlerInterface rh = new ReviewHandler();
		
		Review r= new Review();
		r.setTitle(request.getParameter("title"));
		r.setContent(request.getParameter("content"));
		
		String q2 = request.getParameter("rating");
		if(q2!=null && q2!=""){
			r.setRating(Integer.parseInt(q2));
		} else {
			r.setRating(0);
		}
		
		r.setMovie(new MovieHandler().getMovie(Integer.parseInt(request.getParameter("movie_id"))));
		r.setPostDate(new Date());
		r.setUser(new UserHandler().getUserById(Integer.parseInt(request.getParameter("user_id"))));
		rh.addReview(r);
		PrintWriter out = response.getWriter();
		out.println("save Review successful. return to <a href=\"index\">Index</a>");
		
	}

	private void saveMovie(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		MovieHandlerInterface mh = new MovieHandler();
		String title = request.getParameter("title");
		String posterURL = request.getParameter("posterURL");
		String actors = request.getParameter("actors");
		String synopsis = request.getParameter("synopsis");
		String[] checkedIds = request.getParameterValues("genre");
		Movie m = new Movie();
		System.out.println("title\t"+title);
		System.out.println("posterURL"+posterURL);
		System.out.println("actors\t"+actors);
		System.out.println("synopsis\t"+synopsis);
		System.out.println("checkedIds\t"+checkedIds);
		m.setTitle(title);
		m.setActors(actors);
		m.setPosterURL(posterURL);
		m.setSynopsis(synopsis);
		Set<Genre> genres = new HashSet<Genre>();
		for(String id: checkedIds){
			Genre g = mh.getGenreById(Integer.parseInt(id));
			genres.add(g);
			System.out.println("id\t"+id+"\tname"+g.getName());
		}
		m.setGenres(genres);
		mh.addMovie(m);
		PrintWriter out = response.getWriter();
		out.println("save Movie successful. return to <a href=\"index\">Index</a>");
	}

	private void newMovie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("new_movie.jsp");
		view.forward(request, response);
		
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
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("new_review.jsp");
		view.forward(request, response);
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		String type=request.getParameter("search_by");
		MovieHandlerInterface mi=new MovieHandler();
		if(type.equals("radio1")){
			List<Movie> movies=mi.searchByTitle(search);
			System.out.println("number is: "+movies.size());
			request.setAttribute("movies", movies);
		}else if(type.equals("radio2")){
			List<Movie> movies=mi.searchByGenre(Integer.parseInt(search));
			request.setAttribute("movies", movies);
			System.out.println("number is: "+movies.size());
		}
		RequestDispatcher view=request.getRequestDispatcher("search_result.jsp");
		view.forward(request, response);
		
	}

	private void editCinema(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void newCinema(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("textfield2");
		String location=request.getParameter("textfield");
		int capacity=Integer.parseInt(request.getParameter("textfield3"));
		String[] amenities=request.getParameterValues("checkbox");
		Set<Amenity> am=new HashSet<Amenity>();
		for(String s:amenities){
			am.add(new Amenity(s));
		}
		Cinema c=new Cinema(name,location,capacity);
		c.setAmenities(am);
		CinemaHandlerInterface ci=new CinemaHandler();
		ci.addCinema(c);
		
		RequestDispatcher view = request
				.getRequestDispatcher("new_booking.jsp");
		view.forward(request, response);
		
	}

	private void newBooking(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int session_id = Integer.parseInt(request.getParameter("id"));
		SessionHandlerInterface si=new SessionHandler();
		Session s=si.getSession(session_id);
		request.setAttribute("session", s);
		
		RequestDispatcher view = request
				.getRequestDispatcher("new_booking.jsp");
		view.forward(request, response);
	}


	private void confirmRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in login");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String type=request.getParameter("RadioGroup1");
		if(username!=null && password!=null && type!=null){
			System.out.println(username+" "+password+" "+type);
			if(type.equals("radio1")){
				UserHandlerInterface ui=new UserHandler();
				if(ui.isExist(username)){
					if(ui.isMatch(username, password)){
						request.getSession().setAttribute("user", username);
//						RequestDispatcher view=request.getRequestDispatcher("index.jsp");
//						view.forward(request, response);
						response.setContentType("text/html; charset=gb2312");
						response.sendRedirect("index");
					}else{
						//error msg
						System.out.println("here1");
					}
				}else{
					//error msg
					System.out.println("here2");
				}
			}else if(type.equals("radio2")){
				OwnerHandlerInterface oi=new OwnerHandler();
				if(oi.isExist(username)){
					if(oi.isMatch(username, password)){
						request.getSession().setAttribute("owner",username);
//						RequestDispatcher view=request.getRequestDispatcher("index.jsp");
//						view.forward(request, response);
						response.setContentType("text/html; charset=gb2312");
						response.sendRedirect("index");
					}else{
						//error msg
						System.out.println("here3");
					}
				}else{
					//error msg
					System.out.println("here4");
				}
			}else{
				RequestDispatcher view=request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}
		}
		
		
		
		
		
		
//		UserHandlerInterface ui=new UserHandler();
//		if(ui.isExist(username)){
//			if(ui.isMatch(username, password)){
//				RequestDispatcher view = request
//						.getRequestDispatcher("index.jsp");
//				view.forward(request, response);
//			}else{
//				request.setAttribute("msg", "1");
//				RequestDispatcher view = request
//						.getRequestDispatcher("login.jsp");
//				view.forward(request, response);
//			}
//			
//		}else{
//			request.setAttribute("msg", "1");
//			RequestDispatcher view = request
//					.getRequestDispatcher("login.jsp");
//			view.forward(request, response);
//		}
		
	}

	private void ownerDetail(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("in display_owner");
		String username=request.getParameter("id");
		OwnerHandlerInterface oi=new OwnerHandler();
		Owner owner=oi.getOwnerByUsername(username);
		
		
	}

	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in display_user");
		String username=request.getParameter("id");
		UserHandlerInterface ui=new UserHandler();
		User user=ui.getUserByUsername(username);
		ReviewHandlerInterface ri=new ReviewHandler();
		List<Review> reviews=ri.getReviewsByUser(user);
		BookingHandlerInterface bi=new BookingHandler();
		List<Booking> bookings=bi.getBookingsByUser(user);
		request.setAttribute("user", user);
		request.setAttribute("reviews", reviews);
		request.setAttribute("bookings", bookings);
		RequestDispatcher view = request
				.getRequestDispatcher("display_user.jsp");
		view.forward(request, response);
		
		
		
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
			HttpServletResponse response) throws ServletException, IOException{
		String username=request.getParameter("id");
		String email=request.getParameter("textfield2");
		String password=request.getParameter("textfield3");
		String fname=request.getParameter("textfield4");
		String lname=request.getParameter("textfield5");
		User u=new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setPassword(password);
		u.setFirstname(fname);
		u.setLastname(lname);
		UserHandlerInterface ui=new UserHandler();
		if(ui.isExist(u.getUsername())){
			ui.updateUser(u);
			RequestDispatcher view = request
					.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}else{
			request.setAttribute("msg", "1");
			RequestDispatcher view = request
					.getRequestDispatcher("new_user.jsp");
			view.forward(request, response);
		}
		

	}



	private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in index");
//		List<Cinema> cinemas = DataHandler.getCinemas();
//		request.setAttribute("cinemas", cinemas);
//		List<Movie> movies = DataHandler.getMovies();
//		request.setAttribute("movies", movies);
//		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//		view.forward(request, response);
		MovieHandlerInterface mi=new MovieHandler();
		
		List<Movie> movies=mi.getShowingMovies();	
		request.setAttribute("showingmovies", movies);
		List<Movie> cmovies=mi.getComingMovies();
		request.setAttribute("commingmovies", cmovies);
		System.out.println(cmovies.size());
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
		
	}

	private void newUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in new_user");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(username!=null && email!=null && password!=null){
			System.out.println(username+ " "+email+" "+password);
			UserHandlerInterface ui=new UserHandler();
			RequestDispatcher view = request
					.getRequestDispatcher("fail.jsp");
			if(!ui.isExist(username)){
				User u=new User(username,email);
				u.setPassword(password);
				ui.addUser(u);
				request.setAttribute("msg", "1");
				 view = request
							.getRequestDispatcher("success.jsp");
			}else{
				request.setAttribute("msg", "2");
				view = request
						.getRequestDispatcher("fail.jsp");
			}
			view.forward(request, response);
		}else{
			RequestDispatcher view = request
					.getRequestDispatcher("new_user.jsp");
			view.forward(request, response);
		}
		
	}

	private void movieDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in movie detail");
		int movie_id = Integer.parseInt(request.getParameter("id"));
		MovieHandlerInterface mi=new MovieHandler();
		Movie m=mi.getMovie(movie_id);
		System.out.println(m.getTitle()+" "+m.getId()+" "+movie_id);
		request.setAttribute("mdetail", m);
		SessionHandlerInterface si=new SessionHandler();
		List<Session> ses=si.getSessionsByMovie(m);
		request.setAttribute("session", ses);
//		ReviewHandlerInterface ri=new ReviewHandler();
//		List<Review> revs=ri.getReviewsByMovie(m);
//		if(revs!=null)
//		request.setAttribute("reviews", revs);
		System.out.println("movie_id is " + movie_id);

		RequestDispatcher view = request
				.getRequestDispatcher("movie_detail.jsp");
		view.forward(request, response);
	}
}
