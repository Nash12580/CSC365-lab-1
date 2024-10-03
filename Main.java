import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        searchQueries search = new searchQueries();
        dataProcessing dataProcess = new dataProcessing();

        dataProcess.loadData("students.txt", "teachers.txt", search);

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

            dataProcess.processInput(input, search);
        }

        scanner.close();
    }
}
   