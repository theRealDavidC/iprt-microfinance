package com.iprt.microfinance.model;

import com.iprt.orm.annotation.*;

@Table(name = "members")
public class Member {

    @Id
    @AutoIncrement
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String phone;

    public Member() {}

    public Member(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Member{id=" + id + ", fullName=" + fullName + ", phone=" + phone + "}";
    }
}
