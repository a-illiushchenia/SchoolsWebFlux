package com.ailliushchenia.SchoolsWebFlux.domain;

import java.util.Objects;

public class News {

    private int newsId;
    private String title;
    private String body;

    public News() {}

    public News(int newsId, String title, String body) {
        this.newsId = newsId;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return newsId == news.newsId && Objects.equals(title, news.title) && Objects.equals(body, news.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, title, body);
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
