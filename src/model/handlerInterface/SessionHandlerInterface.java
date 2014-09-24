package model.handlerInterface;

import model.bean.Session;

public interface SessionHandlerInterface {
	public Session getSessionByMovieId(int movie_id);
	public Session getSession(int session_id);
	public Session updateSession(Session session);
	public int addSession(Session session);
}
