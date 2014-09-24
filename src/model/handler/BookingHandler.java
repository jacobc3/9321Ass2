package model.handler;

import java.util.List;

import model.bean.Booking;
import model.handlerInterface.BookingHandlerInterface;

public class BookingHandler implements BookingHandlerInterface {

	public BookingHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Booking> getBookingByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void approveBooking(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void declineBooking(int id) {
		// TODO Auto-generated method stub

	}

}
