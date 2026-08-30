package com.iprt.microfinance.model;

import com.iprt.orm.annotation.*;

@Table(name = "loan_officers")
public class LoanOfficer {

    @Id
    @AutoIncrement
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String phone;

    public LoanOfficer() {}

    public LoanOfficer(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "LoanOfficer{id=" + id + ", fullName=" + fullName + ", phone=" + phone + "}";
    }
}
