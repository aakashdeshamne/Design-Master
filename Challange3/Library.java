package Challange3;
import Challange3.Entity.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Challange3.Entity.Book;
import Challange3.Entity.Loan;

public class Library {
    private Map<Integer,Book> books;
    private Map<Integer,Member> members;
    private Map<Integer,Loan> loans;
    private static final int max_borrow_limit=5;
    public Library() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
        this.loans = new HashMap<>();
    }

    public void addBook(Book book){
        books.put(book.getId(), book);
    }

    public void removeBook(int id){
        books.remove(id);
    }

    public void registerMember(Member member){
        members.put(member.getMemberId(), member);
    }
    public void unregisterMember(int id){
        members.remove(id);
    }

    public List<Book> getAvilableBooksByTitle(String title){
         return books.values().stream()
                .filter(book->book.getTitle().toLowerCase().equals(title.toLowerCase()) && book.isAvailable()).collect(Collectors.toList());
    }

    public List<Book> getAvilableBooksByAuthor(String author){
        return books.values().stream()
                .filter(books->books.getAuthor().toLowerCase().equals(author.toLowerCase()) && books.isAvailable()).collect(Collectors.toList());
    }

    public List<Book> getAvilableBooksBySubject(String subject){
        return books.values().stream()
                .filter(books->books.getSubject().toLowerCase().equals(subject.toLowerCase()) && books.isAvailable()).collect(Collectors.toList());
    }

    public void borrowBook(int memberId,int bookId) throws Exception{
        Member member=members.get(memberId);
        Book book=books.get(bookId);
        if(member==null) throw new Exception("Member not found");
        if(book==null) throw new Exception("Book not found");
        if(!book.isAvailable()) throw new Exception("Book is not available");
        if(member.getBorrowLimit()>=max_borrow_limit) throw new Exception("Borrow limit exceeded");
        Loan loan=new Loan(memberId,bookId);
        loans.put(loan.getLoanId(), loan);
        book.setAvailable(false);
        member.increaseBorrowedBookCount();
        System.out.println("Book borrowed successfully");
    }

    public void returnBook(int bookId) throws Exception{
        Book book=books.get(bookId);
        if(book==null) throw new Exception("Book not found");
        Loan loan=loans.values().stream()
                .filter(l->l.getBookId()==bookId).findFirst().orElse(null);
        if(loan==null) throw new Exception("Loan record not found");
        Member member=members.get(loan.getMemberId());
        if(member==null) throw new Exception("Member not found");
        book.setAvailable(true);
        member.decreaseBorrowedBookCount();
        loans.remove(loan.getLoanId());
        System.out.println("Book returned successfully");
    }

    public List<Loan> getOverdueLoans(){
        return loans.values().stream()
                .filter(Loan::isOverdue).collect(Collectors.toList());
    }

}
