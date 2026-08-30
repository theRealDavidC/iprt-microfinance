package com.iprt.microfinance.repository;

import com.iprt.microfinance.model.Member;
import com.iprt.orm.core.ORM;
import java.util.List;
import java.util.Optional;

public class MemberRepository {
    private ORM orm;

    public MemberRepository(ORM orm) {
        this.orm = orm;
    }

    public void save(Member member) {
        orm.save(member);
    }

    public Optional<Member> findById(Long id) {
        return orm.findById(Member.class, id);
    }

    public List<Member> findAll() {
        return orm.findAll(Member.class);
    }
}
