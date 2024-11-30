package user;

import interfaces.Rentable;
import resource.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {
    public String name;
    public String surname;
    private String department;
    private int idUser;

    public User(String name, String surname, int idUser, String department) {
        this.name = name;
        this.surname = surname;
        this.idUser = idUser;
        this.department = department;
    }

    public int numberOfResources(Resource[] resources){
        if(resources == null) return 0;

        int count = 0;
        for(Resource r : resources){
            if(r instanceof Rentable rt && rt.getUser() != null && rt.getUser().equals(this)){
                count++;
            }
        }
        return count;
    }

    public int getFee(Resource[] resources){
        if(resources == null) return 0;

        int fee = 0;
        LocalDate today = LocalDate.now();

        for(Resource r : resources){
            if(!(r instanceof Rentable rt)) continue;
            if(rt.getUser() == null || !this.equals(rt.getUser())) continue;

            LocalDate dueDate = rt.getDueDate();
            if(dueDate == null) continue;

            int daysBetween = (int) ChronoUnit.DAYS.between(today, dueDate);

            fee += daysBetween < 0 ? Math.abs(daysBetween) : 0;
        }

        return fee;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
