package model.handlerinterface;

import java.util.List;

import model.bean.Cinema;

public interface CinemaHandlerInterface {
	public int newCinema(Cinema cinema);
	public Cinema getCinema(int id);
	public void removeCinema(Cinema cinema);
	public Cinema removeCinema(int id);
	public boolean isExist(int id);
	public void updateCinema(Cinema cinema);
	public List<Cinema> getAllCinemas();
}
