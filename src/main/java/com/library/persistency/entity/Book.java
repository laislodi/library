package com.library.persistency.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @SequenceGenerator(name="seq_book", sequenceName="seq_id_book", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_book")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "GENDER", nullable = false)
    private String gender;
    @Column(name = "RESUME", nullable = false)
    private String resume;
    @Column(name = "PUBLISHED_DATE", nullable = false)
    private LocalDate publishedDate;
    @OneToOne(mappedBy = "book", fetch = FetchType.EAGER)
    private Loan loan;

    public Book() {
    }

    public Book(String title, String gender, String resume, LocalDate publishedDate, Loan loan) {
        this.title = title;
        this.gender = gender;
        this.resume = resume;
        this.publishedDate = publishedDate;
        this.loan = loan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", resume='" + resume + '\'' +
                ", publishedDate=" + publishedDate +
                ", loan=" + loan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(gender, book.gender) &&
                Objects.equals(resume, book.resume) &&
                Objects.equals(publishedDate, book.publishedDate) &&
                Objects.equals(loan, book.loan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, gender, resume, publishedDate, loan);
    }
}

