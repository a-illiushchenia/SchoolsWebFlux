package com.ailliushchenia.SchoolsWebFlux.handlers;

import com.ailliushchenia.SchoolsWebFlux.dao.SchoolDAO;
import com.ailliushchenia.SchoolsWebFlux.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SchoolHandler {
    private final SchoolDAO schoolDAO;

    public SchoolHandler(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    public Mono<ServerResponse> indexPage(ServerRequest request){
        List<School> schools = schoolDAO.list();

        return ServerResponse
                .ok()
                .render("index",
                        Map.of(
                                "schools", schools,
                                "school", new School()
                        )
                );
    }

    public Mono<ServerResponse> schoolPage(ServerRequest request){
        int schoolId = request.queryParam("schoolId")
                .map(Integer::valueOf)
                .get();
        School school = schoolDAO.getById(schoolId);

        return ServerResponse
                .ok()
                .render("school",
                        Map.of(
                                "school", school
                        )
                );
    }
}
