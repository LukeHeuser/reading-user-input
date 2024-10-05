import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int currentYear = 2024;

        try { // Try statement before the method call that throws a NullPointerException
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) { // This expects a declaration of the exception type
            System.out.println(getInputFromScanner(currentYear));
        }

    }

    public static String getInputFromConsole(int currentYear) {

        String usersName = System.console().readLine("Hi, what's your name? ");
        System.out.println("Hi " + usersName + " , it's nice to meet you!");

        String dateOfBirth = System.console().readLine("What year were you born?");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old!";
    }

    public static String getInputFromScanner(int currentYear) {

        Scanner scanner = new Scanner(System.in); // created a new object of type Scanner
        // the local variable named scanner can be used

        System.out.println("Hi, what's your name? ");
        String name = scanner.nextLine(); // uses the nextLine method on the object scanner.
        System.out.println("Hi " + name + " , it's nice to meet you!");
        System.out.println("What year were you born?");

        boolean validDOB = false;
        int age = 0;
        do {
            System.out.println("Enter a year of birth >= " + (currentYear - 125) +
                    " and <= " + (currentYear));

            try { // Try Catch statement to test if the user enters numbers when an integer is required
                age = checkData(currentYear, scanner.nextLine()); // calling nextLine method on our object scanner
                validDOB = age < 0 ? false : true;                // as an expression
            } catch (NumberFormatException badUserData){
                System.out.println("Characters are not allowed! Try again :)");
            }

        } while(!validDOB);

        return "You are " + age + " years old!";
    }

    public static int checkData(int currentYear, String dateOfBirth) {

        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob <= minimumYear) || (dob > currentYear)) { // if the user enters a year before the oldest
            return -1;                                    //   person alive or a future year
        }

        return (currentYear - dob);

    }
}
