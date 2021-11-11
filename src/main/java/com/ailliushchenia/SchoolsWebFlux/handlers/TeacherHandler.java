package com.ailliushchenia.SchoolsWebFlux.handlers;

import com.ailliushchenia.SchoolsWebFlux.dao.TeacherDAO;
import com.ailliushchenia.SchoolsWebFlux.domain.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class TeacherHandler {
    private TeacherDAO teacherDAO;

    public TeacherHandler(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public Mono<ServerResponse> teachersPage(ServerRequest request){

        int schoolId = request.queryParam("schoolId")
                .map(Integer::valueOf)
                .get();

        int schoolNumber = request.queryParam("schoolNumber")
                .map(Integer::valueOf)
                .get();

        List<Teacher> teachers = teacherDAO.getBySchoolId(schoolId);

        return ServerResponse
                .ok()
                .render(
                        "teachers",
                        Map.of(
                                "teachers", teachers,
                                "schoolNumber", schoolNumber
                        )
                );
    }
}
