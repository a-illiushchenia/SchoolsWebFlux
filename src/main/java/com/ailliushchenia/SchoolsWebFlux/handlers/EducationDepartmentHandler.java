package com.ailliushchenia.SchoolsWebFlux.handlers;

import com.ailliushchenia.SchoolsWebFlux.dao.EducationDepartmentDao;
import com.ailliushchenia.SchoolsWebFlux.domain.News;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class EducationDepartmentHandler {
    EducationDepartmentDao educationDepartmentDao;

    public EducationDepartmentHandler(EducationDepartmentDao educationDepartmentDao) {
        this.educationDepartmentDao = educationDepartmentDao;
    }

    public Mono<ServerResponse> eduDepNewsPage(ServerRequest request){
        List<News> news = educationDepartmentDao.getNews();

        return ServerResponse
                .ok()
                .render(
                        "educationdepartmentnews",
                        Map.of(
                                "news",
                                news
                        )
                );
    }
}
