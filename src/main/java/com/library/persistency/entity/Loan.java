package com.library.persistency.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "LOAN")
public class Loan {

    @Id
    @SequenceGenerator(name="seq_loan", sequenceName="seq_id_loan", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_loan")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "BOOK_ID", nullable = false)
    private Integer bookId;
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;
    @Column(name = "LOAN_DATE", nullable = false)
    private LocalDate loanDate;
    @OneToOne
    @JoinColumn(name = "BOOK_ID", updatable = false, insertable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", updatable = false, insertable = false)
    private Client client;

    public Loan() {
    }

    public Loan(Integer bookId, Integer clientId, LocalDate loanDate, Book book, Client client) {
        this.bookId = bookId;
        this.clientId = clientId;
        this.loanDate = loanDate;
        this.book = book;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", clientId=" + clientId +
                ", loanDate=" + loanDate +
                ", book=" + book +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id) &&
                Objects.equals(bookId, loan.bookId) &&
                Objects.equals(clientId, loan.clientId) &&
                Objects.equals(loanDate, loan.loanDate) &&
                Objects.equals(book, loan.book) &&
                Objects.equals(client, loan.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, clientId, loanDate, book, client);
    }
}
