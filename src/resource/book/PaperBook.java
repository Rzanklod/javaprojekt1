package resource.book;

import interfaces.Rentable;
import resource.NoAvailableResourceException;
import resource.ResourceStatus;
import user.Student;
import user.User;

import java.time.LocalDate;

public class PaperBook extends Book implements Rentable {
    private int pages;
    public LocalDate rentDate;
    public LocalDate dueDate;
    private User user;

    public PaperBook(String title, String publisher, int resourceId,
                     String author, int pages) {
        super(title, publisher, resourceId, author);
        this.pages = pages;
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("Author: " + getAuthor());
        System.out.println("Pages: " + pages);
    }

    @Override
    public void rent(User user) throws NoAvailableResourceException {
        if(user == null) return;
        if(this.user != null || getStatus() == ResourceStatus.UNAVAILABLE) {
            throw new NoAvailableResourceException();
        }
        this.user = user;
        rentDate = LocalDate.now();
        // zakladajac ze w systemie beda tylko 2typy uzytkownikow
        if(user instanceof Student){
            dueDate = rentDate.plusMonths(1);
        } else {
            dueDate = rentDate.plusMonths(3);
        }
        setStatus(ResourceStatus.UNAVAILABLE);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
