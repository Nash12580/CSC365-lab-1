import java.util.ArrayList;
import java.util.List;
public class searchQueries {
    // assuming we have a list of Student objects from reading the file called students
    private List<Student> students = new ArrayList<>();

    public void stLastNameSearch(String lastName) {
        for (Student student : students) {
            if (student.getStLastName().equals(lastName)) {
                System.out.println(student.getGrade() + student.getClassroom() + student.getTeacherFirstName() + student.getTeacherLastName());
            }
        }
    }

    public List<Student> stBusSearch(String lastName) {
        List<Student> busList = new ArrayList<>();
        for (Student student : students) {
            if (student.getStLastName().equals(lastName)) {
                System.out.println(student.getStLastName() + student.getStFirstName() + student.getBus());
                busList.add(student);
            }
        }

        for (Student studentBus : busList) {
            System.out.println(studentBus.getBus());
        }

        return busList;
    }

    public List<Student> SearchByTeacher( String tLName) {
        List<Student> TeacherStList = new ArrayList<>();

        for (Student student : students) {
            if (student.getTeacherLastName().equals(tLName)) {
                TeacherStList.add(student);
                System.out.println(student.getStLastName() + student.getStFirstName());
            }
        }

        return TeacherStList;
     }
    public List <Student> busSearch (int bus){
        List<Student> busRouteList = new ArrayList<>();

        for (Student student : students) {
            if (student.getBus() == bus ){
                busRouteList.add(student);
                System.out.println(student.getStLastName() + student.getStFirstName() + student.getGrade() + student.getClassroom());
            }
        }

        return busRouteList;
    }

    public List <Student> gradeSearch (int grade){
        List<Student> gradeList = new ArrayList<>();

        for (Student student : students) {
            if (student.getGrade() == grade){
                gradeList.add(student);
                System.out.println(student);
            }
        }

        return gradeList;

    }

    public int gradeAverage (int grade){
        List<Student> gradeList = new ArrayList<>();
        int avgGPA = 0;
        int count = 0;
        for (Student student : students) {
            if (student.getGrade() == grade){
                avgGPA += student.getGpa();
                count ++;
            }
        }
        System.out.println(avgGPA);
        return avgGPA;
    }

    public int highestGPA (int grade) {
        //List<Student> GPAList = new ArrayList<>();
        int highestGPA = 0;
        for (Student student : students) {
            if (student.getGrade() == grade) {
                if (student.getGpa() >= highestGPA) {
                    highestGPA = student.getGpa();
                }
            }
        }
                System.out.println(highestGPA);
                return highestGPA;
    }

    public int lowestGPA (int grade) {
        //List<Student> GPAList = new ArrayList<>();
        int lowestGPA = 100;
        for (Student student : students) {
            if (student.getGrade() == grade) {
                if (student.getGpa() <= lowestGPA) {
                    lowestGPA = student.getGpa();
                }
            }
        }
        System.out.println(lowestGPA);
        return lowestGPA;
    }






}
