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

}
