package model.handlerInterface;

import java.util.List;

import model.bean.Booking;

public interface BookingHandlerInterface {
	public List<Booking> getBookingByUserId(int user_id);
	public int addBooking(Booking booking);
	public void approveBooking(int id);
	public void declineBooking(int id);
}
