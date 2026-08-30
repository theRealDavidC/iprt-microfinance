package com.iprt.microfinance.repository;

import com.iprt.microfinance.model.Payment;
import com.iprt.orm.core.ORM;
import java.util.List;

public class PaymentRepository {

    private final ORM orm;

    public PaymentRepository(ORM orm) {
        this.orm = orm;
    }

    public void save(Payment payment) {
        orm.save(payment);
    }

    public List<Payment> findAll() {
        return orm.findAll(Payment.class);
    }

    public List<Payment> findByLoanId(Long loanId) {
        return orm.find(Payment.class)
                  .where("loan_id", "=", loanId)
                  .execute();
    }
}
