package study.modernjava.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import study.modernjava.Guest;
import study.modernjava.repository.GuestRepository;

public class ModernJavaResort implements ResortService {
	private GuestRepository repository;
	
	public ModernJavaResort(GuestRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<String> findGuestNamesByCompany(String company) {
		// TODO Auto-generated method stub
		List<Guest> guests = repository.findAllGuest();
		
		return guests.stream()
				.filter(g -> company.equals(g.getCompany()))
				.sorted(Comparator.comparing(Guest::getGrade))
				.map(Guest::getName)
				.collect(Collectors.toList());
		/*return guests.stream()
				.filter(g -> company.equals(g.getCompany()))
				.sorted(Comparator.comparing(g -> g.getGrade()))
				.map(g -> g.getName())
				.collect(Collectors.toList());*/
	}
}
