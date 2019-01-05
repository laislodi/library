package com.library.view.bean;

import java.time.LocalDate;
import java.util.Objects;

public class BookBean {

    private Long id;
    private String title;
    private String gender;
    private String resume;
    private LocalDate publishedDate;

    public BookBean() {
    }

    public BookBean(Long id, String title, String gender, String resume, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.resume = resume;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", resume='" + resume + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookBean bookBean = (BookBean) o;
        return Objects.equals(id, bookBean.id) &&
                Objects.equals(title, bookBean.title) &&
                Objects.equals(gender, bookBean.gender) &&
                Objects.equals(resume, bookBean.resume) &&
                Objects.equals(publishedDate, bookBean.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, gender, resume, publishedDate);
    }
}
