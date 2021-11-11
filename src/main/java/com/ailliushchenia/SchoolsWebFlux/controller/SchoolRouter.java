package com.ailliushchenia.SchoolsWebFlux.controller;

import com.ailliushchenia.SchoolsWebFlux.handlers.EducationDepartmentHandler;
import com.ailliushchenia.SchoolsWebFlux.handlers.SchoolHandler;
import com.ailliushchenia.SchoolsWebFlux.handlers.TeacherHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class SchoolRouter {

    @Bean
    public RouterFunction<ServerResponse> route(SchoolHandler schoolHandler,
                                                TeacherHandler teacherHandler,
                                                EducationDepartmentHandler educationDepartmentHandler) {

        RequestPredicate roteIndex =
                GET("/")
                        .and(accept(MediaType.TEXT_PLAIN));

        RequestPredicate roteEduDepNews =
                GET("/edudepnews")
                        .and(accept(MediaType.TEXT_PLAIN));

        RequestPredicate roteSchool =
                GET("/school")
                        .and(accept(MediaType.TEXT_PLAIN));

        RequestPredicate roteTeachers =
                GET("/teachers")
                        .and(accept(MediaType.TEXT_PLAIN));

        RequestPredicate roteTimetable =
                GET("/timetable")
                        .and(accept(MediaType.TEXT_PLAIN));

        return RouterFunctions
                .route(roteIndex, schoolHandler :: indexPage)
                .andRoute(roteEduDepNews, educationDepartmentHandler :: eduDepNewsPage)
                .andRoute(roteSchool, schoolHandler :: schoolPage)
                .andRoute(roteTeachers, teacherHandler ::teachersPage);
    }
}
