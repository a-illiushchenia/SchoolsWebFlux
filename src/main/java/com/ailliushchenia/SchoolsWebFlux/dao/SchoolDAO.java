package com.ailliushchenia.SchoolsWebFlux.dao;

import com.ailliushchenia.SchoolsWebFlux.domain.School;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchoolDAO {
    private List<School> schools;

    {
        schools = new ArrayList<>();
        schools.add(new School(1, 4, "School 1", "Minsk, Denisovskaya 3"));
        schools.add(new School(2, 5, "School 2", "Minsk, Voronianskogo 10"));
        schools.add(new School(3, 6, "School 3", "Minsk, Bogdanovicha 98"));
    }

    public List<School> list() {
        return schools;
    }

    public School getById(int schoolId) {
        return schools
                .stream()
                .filter(school -> school.getId() == schoolId)
                .findFirst()
                .get();
    }
}
