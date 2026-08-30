package com.iprt.microfinance.service;

import com.iprt.microfinance.model.Loan;
import com.iprt.microfinance.repository.LoanRepository;
import java.util.List;
import java.util.Optional;

public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan createLoan(Long memberId, Double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Loan amount must be greater than zero");
        }
        Loan loan = new Loan(memberId, amount, "PENDING");
        loanRepository.save(loan);
        return loan;
    }

    public void activate(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setStatus("ACTIVE");
        loanRepository.update(loan);
    }

    public void markAsPaid(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        loan.setStatus("PAID");
        loanRepository.update(loan);
    }

    public List<Loan> findActive() {
        return loanRepository.findActive();
    }

    public Optional<Loan> findById(Long loanId) {
        return loanRepository.findById(loanId);
    }

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }
}
