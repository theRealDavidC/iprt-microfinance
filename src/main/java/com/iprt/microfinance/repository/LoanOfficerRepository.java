package com.iprt.microfinance.repository;

import com.iprt.microfinance.model.LoanOfficer;
import com.iprt.orm.core.ORM;
import java.util.List;
import java.util.Optional;

public class LoanOfficerRepository {

    private ORM orm;

    public LoanOfficerRepository(ORM orm) {
        this.orm = orm;
    }

    public void save(LoanOfficer officer) {
        orm.save(officer);
    }

    public Optional<LoanOfficer> findById(Long id) {
        return orm.findById(LoanOfficer.class, id);
    }

    public List<LoanOfficer> findAll() {
        return orm.findAll(LoanOfficer.class);
    }
}
