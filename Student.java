public class Student {
    private String stLastName;
    private String stFirstName;
    private int grade;
    private int classroom;
    private int bus;
    private double GPA;
    private String tLastName;
    private String tFirstName;

    public Student(String stLastName, String stFirstName, int grade, int classroom, int bus, double GPA, String tLastName, String tFirstName) {
        this.stLastName = stLastName;
        this.stFirstName = stFirstName;
        this.grade = grade;
        this.classroom = classroom;
        this.bus = bus;
        this.GPA = GPA;
        this.tLastName = tLastName;
        this.tFirstName = tFirstName;
    }

    public String getStLastName() {
        return stLastName;
    }
    public String getStFirstName() {
        return stFirstName;
    }
    public int getGrade() {
        return grade;
    }
    public int getClassroom() {
        return classroom;
    }
    public int getBus() {
        return bus;
    }
    public double getGpa() {
        return GPA;
    }
    public String getTeacherLastName() {
        return tLastName;
    }
    public String getTeacherFirstName() {
        return tFirstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stLastName='" + stLastName + '\'' +
                ", stFirstName='" + stFirstName + '\'' +
                ", grade=" + grade +
                ", classroom=" + classroom +
                ", bus=" + bus +
                ", GPA='" + GPA + '\'' +
                ", tLastName='" + tLastName + '\'' +
                ", tFirstName='" + tFirstName + '\'' +
                '}';
    }

}

