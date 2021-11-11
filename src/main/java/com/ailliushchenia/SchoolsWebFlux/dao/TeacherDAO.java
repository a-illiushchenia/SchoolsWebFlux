package com.ailliushchenia.SchoolsWebFlux.dao;

import com.ailliushchenia.SchoolsWebFlux.domain.School;
import com.ailliushchenia.SchoolsWebFlux.domain.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeacherDAO {
    List<Teacher> teachers = new ArrayList();

    {
        teachers.add(new Teacher(1, "Bob", "", "Smitt", new ArrayList<>(Arrays.asList(new School(1), new School(3)))));
        teachers.add(new Teacher(2, "Megan", "", "Kardash", new ArrayList<>(Arrays.asList(new School(2), new School(3)))));
        teachers.add(new Teacher(2, "Tom", "", "Perov", new ArrayList<>(Arrays.asList(new School(3)))));
    }

    public List<Teacher> getBySchoolId(int schoolId) {
        return teachers
                .stream()
                .filter(teacher ->
                    teacher.getSchools().stream().anyMatch(school -> school.getId() == schoolId)
                )
                .collect(Collectors.toList());
    }
}
