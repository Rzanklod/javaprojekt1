package user;

public class Student extends User {
    private String course;

    public Student(String name, String lastName, int idUser,
                   String department, String course) {
        super(name, lastName, idUser, department);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
