package study.modernjava.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import study.modernjava.Guest;
import study.modernjava.repository.GuestRepository;

public class ClassicJavaResort implements ResortService {
	private GuestRepository repository;
	
	public ClassicJavaResort(GuestRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<String> findGuestNamesByCompany(String company) {
		// TODO Auto-generated method stub
		List<Guest> all = repository.findAllGuest();
		List<Guest> filtered = this.filter(all, company);
		this.sort(filtered);
		return this.mapNames(filtered);
	}

	private List<Guest> filter(List<Guest> guests, String company) {
		List<Guest> filtered = new ArrayList<>();
		
		for (Guest guest : guests) {
			if(company.equals(guest.getCompany())) {
				filtered.add(guest);
			}
		}
		
		return filtered;
	}
	
	private void sort(List<Guest> guests) {
		Collections.sort(guests, new Comparator<Guest>() {
			@Override
			public int compare(Guest o1, Guest o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getGrade(), o2.getGrade());
			}
		});
	}
	
	private List<String> mapNames(List<Guest> guests) {
		List<String> names = new ArrayList<>();
		
		for (Guest guest : guests) {
			names.add(guest.getName());
		}
		
		return names;
	}
}
