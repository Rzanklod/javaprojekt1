package user;

public class Teacher extends User {
    private String position;

    public Teacher(String firstName, String lastName, int idUser,
                   String department, String position) {
        super(firstName, lastName, idUser, department);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
