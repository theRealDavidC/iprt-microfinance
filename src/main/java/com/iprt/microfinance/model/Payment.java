package com.iprt.microfinance.model;

import com.iprt.orm.annotation.*;

@Table(name = "payments")
public class Payment {

    @Id
    @AutoIncrement
    private Long id;

    @Column(name = "loan_id", nullable = false)
    private Long loanId;

    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @Column(name = "payment_date", nullable = false)
    private String paymentDate;

    public Payment() {}

    public Payment(Long loanId, Double amountPaid, String paymentDate) {
        this.loanId = loanId;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
    }

    public Long getId() { return id; }
    public Long getLoanId() { return loanId; }
    public Double getAmountPaid() { return amountPaid; }
    public String getPaymentDate() { return paymentDate; }

    @Override
    public String toString() {
        return "Payment{id=" + id + ", loanId=" + loanId + ", amountPaid=" + amountPaid + ", paymentDate=" + paymentDate + "}";
    }
}
