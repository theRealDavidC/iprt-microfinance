package com.iprt.microfinance;

import com.iprt.microfinance.model.Loan;
import com.iprt.microfinance.model.LoanOfficer;
import com.iprt.microfinance.model.Member;
import com.iprt.microfinance.model.Payment;
import com.iprt.microfinance.repository.LoanRepository;
import com.iprt.microfinance.repository.MemberRepository;
import com.iprt.microfinance.repository.PaymentRepository;
import com.iprt.microfinance.service.LoanService;
import com.iprt.microfinance.service.MemberService;
import com.iprt.microfinance.service.PaymentService;
import com.iprt.orm.core.ORM;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));

        String host     = props.getProperty("db.host");
        String port     = props.getProperty("db.port");
        String database = props.getProperty("db.database");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");

        ORM orm = new ORM.Builder()
            .host(host)
            .port(port)
            .database(database)
            .username(username)
            .password(password)
            .build();

        orm.register(Member.class);
        orm.register(Loan.class);
        orm.register(Payment.class);
        orm.register(LoanOfficer.class);
        orm.migrate();

        MemberRepository  memberRepository  = new MemberRepository(orm);
        LoanRepository    loanRepository    = new LoanRepository(orm);
        PaymentRepository paymentRepository = new PaymentRepository(orm);

        MemberService  memberService  = new MemberService(memberRepository);
        LoanService    loanService    = new LoanService(loanRepository);
        PaymentService paymentService = new PaymentService(paymentRepository, loanService);

        Member joy  = memberService.register("Joy Mwase",    "0711000001");
        Member john = memberService.register("John Kimani",  "0711000002");
        System.out.println("Registered: " + joy);
        System.out.println("Registered: " + john);

        Loan joyLoan  = loanService.createLoan(joy.getId(),  500000.0);
        Loan johnLoan = loanService.createLoan(john.getId(), 750000.0);
        System.out.println("Created: " + joyLoan);
        System.out.println("Created: " + johnLoan);

        loanService.activate(joyLoan.getId());
        loanService.activate(johnLoan.getId());
        System.out.println("Both loans activated.");

        Payment p1 = paymentService.recordPayment(joyLoan.getId(),  100000.0, "2026-08-30");
        Payment p2 = paymentService.recordPayment(johnLoan.getId(), 150000.0, "2026-08-30");
        System.out.println("Payment recorded: " + p1);
        System.out.println("Payment recorded: " + p2);

        System.out.println("\n--- Active Loans ---");
        loanService.findActive().forEach(System.out::println);

        System.out.println("\n--- All Members ---");
        memberService.findAll().forEach(System.out::println);

        loanService.markAsPaid(joyLoan.getId());
        System.out.println("Joy's loan marked as PAID.");

        System.out.println("\n--- Active Loans after marking Joy's paid ---");
        loanService.findActive().forEach(System.out::println);

        orm.close();
        System.out.println("\nDone.");
    }
}
