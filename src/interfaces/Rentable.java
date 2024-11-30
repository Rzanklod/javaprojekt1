package interfaces;

import resource.NoAvailableResourceException;
import user.User;

import java.time.LocalDate;

public interface Rentable {
    void rent(User user) throws NoAvailableResourceException;
    User getUser();
    LocalDate getDueDate();
}
