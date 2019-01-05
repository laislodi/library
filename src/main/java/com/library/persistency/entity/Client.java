package com.library.persistency.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @SequenceGenerator(name="seq_client", sequenceName="seq_id_client", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_client")
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CPF", nullable = false)
    private String cpf;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE", nullable = false)
    private String telephone;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Loan> loanList;

    public Client() {
    }

    public Client(String name, String cpf, String email, String telephone, List<Loan> loanList) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
        this.loanList = loanList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", loanList=" + loanList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(cpf, client.cpf) &&
                Objects.equals(email, client.email) &&
                Objects.equals(telephone, client.telephone) &&
                Objects.equals(loanList, client.loanList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, email, telephone, loanList);
    }
}
