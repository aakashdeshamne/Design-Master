package Challange3.Entity;

import java.time.LocalDate;

public class Loan {
    private int loanId;
    private int bookId;
    private int memberId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private final int loan_duretion_days=11;
    public Loan(int loanId, int bookId, int memberId) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(loan_duretion_days);
    }
    public int getLoanId() {
        return loanId;
    }
    public int getBookId() {
        return bookId;
    }
    public int getMemberId() {
        return memberId;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }
}
