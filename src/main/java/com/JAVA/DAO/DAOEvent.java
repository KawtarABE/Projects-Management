package com.JAVA.DAO;
import java.util.List;

import com.JAVA.Beans.Event;

public interface DAOEvent {
	
	List<Event> getAllevents(String id_user);
	List<Event> getAllevents_prof(String id_user);
	void annulerEvent(String date, String heure, String title);
	int comingEvents(String id_user);

}
