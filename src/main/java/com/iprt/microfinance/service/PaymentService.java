package com.iprt.microfinance.service;

import com.iprt.microfinance.model.Payment;
import com.iprt.microfinance.repository.PaymentRepository;
import java.util.List;

public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final LoanService loanService;

    public PaymentService(PaymentRepository paymentRepository, LoanService loanService) {
        this.paymentRepository = paymentRepository;
        this.loanService = loanService;
    }

    public Payment recordPayment(Long loanId, Double amount, String date) {
        if (amount <= 0) {
            throw new RuntimeException("Payment amount must be greater than zero");
        }
        Payment payment = new Payment(loanId, amount, date);
        paymentRepository.save(payment);
        return payment;
    }

    public List<Payment> findByLoanId(Long loanId) {
        return paymentRepository.findByLoanId(loanId);
    }
}
