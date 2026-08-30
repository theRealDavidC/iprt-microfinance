package com.iprt.microfinance.model;

import com.iprt.orm.annotation.*;

@Table(name = "loans")
public class Loan {

    @Id
    @AutoIncrement
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String status;

    public Loan() {}

    public Loan(Long memberId, Double amount, String status) {
        this.memberId = memberId;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getMemberId() { return memberId; }
    public Double getAmount() { return amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Loan{id=" + id + ", memberId=" + memberId + ", amount=" + amount + ", status=" + status + "}";
    }
}
