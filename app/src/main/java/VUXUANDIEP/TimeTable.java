package VUXUANDIEP;

public class TimeTable {
    private String day;
    private String date;
    private  String subject;
    private String teacher;
    private  String room;
    private String time;
    private String location;

    public TimeTable(String day, String date, String subject, String teacher, String room, String time, String location) {
        this.day = day;
        this.date = date;
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.time = time;
        this.location = location;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
