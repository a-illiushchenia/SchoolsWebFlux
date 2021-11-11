package com.ailliushchenia.SchoolsWebFlux.dao;

import com.ailliushchenia.SchoolsWebFlux.domain.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EducationDepartmentDao {

    private List<News> news = new ArrayList<>();

    {
        news.add(new News(1, "Первая новость", "Текст первой новости"));
        news.add(new News(2, "Вторая новость", "Текст второй новости"));
        news.add(new News(3, "Третья новость", "Текст третьей новости"));
    }

    public List<News> getNews(){
        return news;
    }


}
