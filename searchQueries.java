import java.util.ArrayList;
import java.util.List;

public class searchQueries {
    // assuming we have a list of Student objects from reading the file called students
    private List<Student> students;

    public searchQueries(){
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void stLastNameSearch(String lastName) {
        for (Student student : students) {
            if (student.getStLastName().equals(lastName)) {
                System.out.println("Student: " + student.getStLastName() + ", " + student.getStFirstName() + ", " + 
                                    student.getGrade() + ", " + student.getClassroom() + ", " + student.getTeacherLastName() + ", "
                                    + student.getTeacherFirstName());
            }
        }
    }

    public List<Student> stBusSearch(String lastName) {
        List<Student> busList = new ArrayList<>();
        for (Student student : students) {
            if (student.getStLastName().equals(lastName)) {
                System.out.println(student.getStLastName() + ", " + student.getStFirstName() + ", " + student.getBus());
                busList.add(student);
            }
        }

        // for (Student studentBus : busList) {
        //     System.out.println(studentBus.getBus());
        // }

        return busList;
    }

    public List<Student> SearchByTeacher( String tLName) {
        List<Student> TeacherStList = new ArrayList<>();

        for (Student student : students) {
            if (student.getTeacherLastName().equals(tLName)) {
                TeacherStList.add(student);
                System.out.println(student.getStLastName() + ", " + student.getStFirstName());
            }
        }

        return TeacherStList;
    }

    public List <Student> busSearch (int bus){
        List<Student> busRouteList = new ArrayList<>();

        for (Student student : students) {
            if (student.getBus() == bus ){
                busRouteList.add(student);
                System.out.println(student.getStLastName() + ", "+ student.getStFirstName() + ", " + student.getGrade() + ", " + student.getClassroom());
            }
        }

        return busRouteList;
    }

    public List <Student> gradeSearch (int grade){
        List<Student> gradeList = new ArrayList<>();

        for (Student student : students) {
            if (student.getGrade() == grade){
                gradeList.add(student);
                System.out.println("Student: " + student.getStLastName() + ", " + student.getStFirstName());
            }
        }

        if(gradeList.isEmpty()){
            System.out.println("No students found in grade " + grade);
        }
        return gradeList;
    }

    public double gradeAverage (int grade){
        double totalGPA = 0;
        int count = 0;
        for (Student student : students) {
            if (student.getGrade() == grade){
                totalGPA += student.getGpa();
                count ++;
            }
        }
        
        if(count > 0){
            double avgGPA = totalGPA/count;
            System.out.println("Average GPA for grade " + grade + ": " + avgGPA);
            return avgGPA;
        }else{
            System.out.println("No students found for grade " + grade);
            return 0;
        }
    }

    public void highestGPA (int grade) {
        double highestGPA = 0;
        Student topStudent = null;

        for (Student student : students) {
            if (student.getGrade() == grade && student.getGpa() > highestGPA) {
                highestGPA = student.getGpa();
                topStudent = student;
            }
        }
        
        if(topStudent != null){
            System.out.println("Student with highest GPA: " + topStudent + "(GPA: " + highestGPA + ")");
        }else{
            System.out.println("No students found for grade " + grade);
        }
    }

    public void lowestGPA (int grade) {
        double lowestGPA = 100;
        Student lowStudent = null;

        for (Student student : students) {
            if (student.getGrade() == grade && student.getGpa() < lowestGPA) {
                lowestGPA = student.getGpa();
                lowStudent = student;
            }
        }
        
        if(lowStudent != null){
            System.out.println("Student with lowest GPA: " + lowStudent + "(GPA: " + lowestGPA + ")");
        }else{
            System.out.println("No students found for grade " + grade);
        }
    }

    public void info(){
        int[] gradeCounts = new int[7];

        for(Student student: students){
            int grade = student.getGrade();
            if(grade >= 0 && grade <= 6){
                gradeCounts[grade]++;                 
            }
        }

        for(int i = 0; i < gradeCounts.length; i++){
            System.out.println("Grade " + i + ": " + gradeCounts[i] + " students");
        }
    }

}
