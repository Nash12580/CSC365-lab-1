import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        searchQueries search = new searchQueries();

        loadData("students.txt", search);

        Scanner scanner = new Scanner(System.in);
        String input;

        //Printing avaiable commands
        System.out.println("Select from the following commands followed by a colon ':', a space, and lastname/number");
        System.out.println("S[tudent]: <lastname> [B[us]]");
        System.out.println("T[eacher]: <lastname>");
        System.out.println("B[us]: <number>");
        System.out.println("G[rade]: <number> [H[igh]|L[ow]]");
        System.out.println("A[verage]: <number>");
        System.out.println("I[nfo]");
        System.out.println("Q[uit]");

        //Continue asking for command inputs until user quits the program
        while(true){
            System.out.print("\nEnter command: ");
            input = scanner.nextLine().trim();

            if(input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("Quit")){
                System.out.println("Exiting the program");
                break;
            }

            processInput(input, search);
        }

        scanner.close();
    }

    private static void loadData(String fileName, searchQueries search){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                String stLastName = data[0];
                String stFirstName = data[1];
                int grade = Integer.parseInt(data[2]);
                int classroom = Integer.parseInt(data[3]);
                int bus = Integer.parseInt(data[4]);
                double gpa = Double.parseDouble(data[5]);
                String tLastName = data[6];
                String tFirstName = data[7];

                Student student = new Student(stLastName, stFirstName, grade, classroom, bus, gpa, tLastName, tFirstName);
                search.addStudent(student);
            }
            System.out.println("Data loaded.");
        } catch(IOException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }


    //Method processes users' input and invokes the appropriate search querie(s)
    private static void processInput(String input, searchQueries search){
        String[] parts = input.split(":", 2);
        if(parts.length < 2 && !input.equalsIgnoreCase("i")){
            System.out.println("Invalid input format. Use the appropriate format");
            return;
        }

        String command = parts[0].trim().toLowerCase();
        String argument = parts.length > 1? parts[1].trim() : "";

        try{
            switch(command){
                case "s":
                    if (argument.toLowerCase().endsWith("b")){
                        String lastName = argument.substring(0, argument.length() - 1).trim();
                        search.stBusSearch(lastName);
                    }else{
                        search.stLastNameSearch(argument);
                    }
                    break;
                case "t":
                    search.SearchByTeacher(argument);
                    break;
                case "b":
                    int busNumber = Integer.parseInt(argument);
                    search.busSearch(busNumber);
                    break;
                case "g":
                    String[] gradeParts = argument.split(" ");
                    int grade = Integer.parseInt(gradeParts[0].trim());

                    if(gradeParts.length > 1){
                        String highOrlow = gradeParts[1].trim().toLowerCase();
                        if(highOrlow.equals("h")){
                            search.highestGPA(grade);
                        }else if(highOrlow.equals("l")){
                            search.lowestGPA(grade);
                        }
                    }else{
                        search.gradeSearch(grade);
                    }
                    break;

                case "a":
                    int avgGrade = Integer.parseInt(argument);
                    search.gradeAverage(avgGrade);
                    break;
                case "i":
                    search.info();
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        } catch(NumberFormatException e){
            System.out.println("Error: Invalid number format");
        } catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}