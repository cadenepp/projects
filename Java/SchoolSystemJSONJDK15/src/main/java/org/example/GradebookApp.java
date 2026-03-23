package org.example;

//import com.google.gson.Gson;
import java.util.*;

// Data Library
import org.example.classes.JSONCrudMultiTool;
import org.example.classes.JSONReader;

// TODO: add comments
public class GradebookApp {

    public static JSONReader jsonReader = new JSONReader("src/main/java/org/example/data/students.json");
    public static Scanner scanner = new Scanner(System.in);
    public static JSONCrudMultiTool multiTool = new JSONCrudMultiTool("src/main/java/org/example/data/students.json");


    public static void main(String[] args) {
        menu();
    }


    public static void menu() {
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                System.out.println("\n1: Add student " +
                        "\n2: Remove student " +
                        "\n3: Update student " +
                        "\n4: Calculate (ISAG)" +
                        "\n5: View all students " +
                        "\n6: Calculate grade average " +
                        "\n7: Export Students (TXT) " +
                        "\n8: View Student " +
                        "\n9: Exit " );
                int choice = Integer.parseInt(scanner.nextLine());

                // TODO: fix single name entry to double name entry

                switch (choice) {
                    case 1:
                        System.out.println("Enter Students Name (First Last)");
                        String name = scanner.nextLine();
                        ArrayList<Double> grades = new ArrayList<>();
                        for (int i = 0; i < 5; i++) {
                            System.out.println("Enter Student Grade " + (i + 1));
                            grades.add(Double.parseDouble(scanner.nextLine()));
                        }
                        multiTool.addStudent(name, grades);
                        break;
                    case 2:
                        System.out.println("Which Student do you want to remove? (First Last)");
                        String userRemoveName = scanner.nextLine();
                        jsonReader.readJson();
                        ArrayList<ArrayList<String>> studentForRemove = jsonReader.getStudentNames();
                        multiTool.removeStudent(userRemoveName, studentForRemove);
                        break;
                    case 3:
                        System.out.println("Which Student do you want to update? (First Last)");
                        String userUpdateName = scanner.nextLine();
                        jsonReader.readJson();
                        ArrayList<ArrayList<String>> studentsForUpdate = jsonReader.getStudentNames();
                        ArrayList<ArrayList<Double>> gradesForUpdate = jsonReader.getStudentGrades();
                        multiTool.updateStudent(userUpdateName, studentsForUpdate, gradesForUpdate);
                        break;
                    case 4:
                        System.out.println("Which Student ISAG do you want to see? (First Last)");
                        break;
                    case 5:
                        // TODO: fix view all students
                        jsonReader.readJson();
                        ArrayList<ArrayList<String>> studentsForViewAll = jsonReader.getStudentNames();
                        ArrayList<ArrayList<Double>> gradesForViewAll = jsonReader.getStudentGrades();
                        System.out.println("--- FIRST ------ LAST ------ AVG ---");
                        multiTool.printAll(studentsForViewAll, gradesForViewAll);
                        System.out.println("------------------------------------");
                        break;
                    case 6:

                        // TODO: Calculate Grade Average
                        break;
                    case 7:

                        // TODO: Export Students to TXT File
                        break;
                    case 8:
                        System.out.println("Which Student do you want to view? (First Last)");
                        String userViewName = scanner.nextLine();
                        jsonReader.readJson();
                        ArrayList<ArrayList<String>> studentsForView = jsonReader.getStudentNames();
                        ArrayList<ArrayList<Double>> gradesForView = jsonReader.getStudentGrades();
                        multiTool.findStudentByName(userViewName, studentsForView, gradesForView);
                        break;
                    case 9:
                        System.out.println("Have a nice day!");
                        keepGoing = false;
                        break;
                    default:
                        System.out.println("Invalid choice, choose from 1 to 8");

                }
            } catch (Exception e) {
                System.out.println("Invalid choice, choice must be a number");
            }
        }
    }







}