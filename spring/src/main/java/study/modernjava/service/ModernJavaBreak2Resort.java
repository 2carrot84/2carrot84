package study.modernjava.service;

import study.modernjava.Guest;
import study.modernjava.repository.GuestRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eguns on 2017. 4. 26..
 */
public class ModernJavaBreak2Resort implements ResortService {
    private GuestRepository repository;

    public ModernJavaBreak2Resort(GuestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> findGuestNamesByCompany(String company) {
        List<Guest> all = repository.findAllGuest();

        Stream<Guest> stream = all.stream();

        Predicate<Guest> filterFunc = g -> company.equals(g.getCompany());
        Stream<Guest> filtered = stream.filter(filterFunc);

        Comparator<Guest> sortFunc = Comparator.comparing(Guest::getGrade);
        Stream<Guest> sorted = filtered.sorted(sortFunc);

        Function<Guest, String> mapFunc = Guest::getName;
        Stream<String> mapped = sorted.map(mapFunc);
        Collector<String, ?, List<String>> collector = Collectors.toList();

        return mapped.collect(collector);
    }
}
