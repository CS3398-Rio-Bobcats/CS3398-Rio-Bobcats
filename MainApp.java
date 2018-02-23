package guiattempt;
import java.util.*;

/**
 * Main access point
 * @author Zach Sotak (zs1046)
 * @Version 1.0
 */
public class MainApp {

    private final Scanner sc; // Used to read from System's standard input

    /**
     * Constructor
     */
    
    public MainApp() {
        this.sc = new Scanner(System.in);
    }

    /**
     * This method serves as the main interface between the program and the user.
     * The method interacts with the user by printing out a set of options, and
     * asking the user to select one.
     */
    
    public void runSoftware() {
        int choice = 0;
        boolean exitProgram = false;
        do {
            printMenu();
            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1: hideText(); break;
                    case 2: System.err.println("case2()"); break;
                    case 3: System.err.println("case3()"); break;
                    case 4: System.err.println("case4()"); break;
                    case 5: System.err.println("case5()"); break;
                    case 6: exitProgram = true; break;
                    default: System.err.println("Please select a number between 1 and 6");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Input missmatch. Please Try again.");
             
            }
        } while (!exitProgram);
    }

    /**
     * Auxiliary method that prints out the operations menu.
     */
    private static void printMenu() {
        System.out.println(
                "\n 1. 1. Hide text\n" +
                        " 2. 2. Hide an image \n" +
                        " 3. Reveal text from stego image\n" +
                        " 4. Reveal an image from a stego image\n" +
                        " 5. Convert image to (ppm, jpg, jpeg, png, gif)\n" +
                        " 6. Exit\n" );
    }

    /**
     * This method allows the user to hide text within an image
     * 
     */
    
    public void hideText(){
        
        
    }



    /**
     * The main method of the program.
     *
     * @param args the command line arguments
     */
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.runSoftware();
    }
}