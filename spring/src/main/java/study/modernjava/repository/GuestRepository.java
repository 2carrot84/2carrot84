package study.modernjava.repository;

import java.util.List;

import study.modernjava.Guest;

public interface GuestRepository {
	public List<Guest> findAllGuest();
}
