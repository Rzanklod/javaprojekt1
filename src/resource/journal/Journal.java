package resource.journal;

import interfaces.Rentable;
import resource.NoAvailableResourceException;
import resource.Resource;
import resource.ResourceStatus;
import user.Student;
import user.User;

import java.time.LocalDate;

public class Journal extends Resource implements Rentable {
    private LocalDate publishDate;
    private LocalDate rentDate;
    private LocalDate dueDate;
    private User user;

    public Journal(String title, String publisher, int resourceId,
                   LocalDate publishDate){
        super(title, publisher, resourceId);
        this.publishDate = publishDate;
    }

    @Override
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ResourceId: " + getResourceId());
        System.out.println("PublishDate: " + publishDate);
    }

    @Override
    public void rent(User user) throws NoAvailableResourceException {
        if(user == null) return;
        if(this.user != null || getStatus() == ResourceStatus.UNAVAILABLE) {
            throw new NoAvailableResourceException();
        }
        this.user = user;
        rentDate = LocalDate.now();
        if(user instanceof Student){
            dueDate = rentDate.plusMonths(1);
        } else {
            dueDate = rentDate.plusDays(10);
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

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
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
