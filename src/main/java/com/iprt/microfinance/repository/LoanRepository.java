package com.iprt.microfinance.repository;

import com.iprt.microfinance.model.Loan;
import com.iprt.orm.core.ORM;
import java.util.List;
import java.util.Optional;

public class LoanRepository {
    private ORM orm;

    public LoanRepository(ORM orm) {
        this.orm = orm;
    }

    public void save(Loan loan) {
        orm.save(loan);
    }

    public Optional<Loan> findById(Long id) {
        return orm.findById(Loan.class, id);
    }

    public List<Loan> findAll() {
        return orm.findAll(Loan.class);
    }
    
   public void update(Loan loan) {
    orm.update(loan);
    } 

    public List<Loan> findActive() {
        return orm.find(Loan.class).where("status", "=", "ACTIVE").execute();
    }
}
