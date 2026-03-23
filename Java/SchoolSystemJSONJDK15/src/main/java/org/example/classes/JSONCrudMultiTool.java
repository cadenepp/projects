package org.example.classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

// TODO: add comments
public class JSONCrudMultiTool {


    // TODO: separate this into best possible thought out methods and or classes in data library


    private final Scanner scanner = new Scanner(System.in);


    private String filePath;


    public JSONCrudMultiTool(String filePath) {
        this.filePath = filePath;
    }


    private JSONArray getCurrentStudents() {

        // parse JSON
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader(filePath));
        } catch (IOException | ParseException e) {
            System.out.println("Error with MultiTool :/");
        }

        // JSON file has multiple student objects; parse into jsonArray for all JSON objects
        JSONArray current = (JSONArray) obj;

        return current;
    }


    public void addStudent(String name, ArrayList<Double> grades) {
        String newStudentFName = addStudentLogic(name, grades);
        System.out.println("Student " +  newStudentFName + " Successfully Added :)");
    }


    private String addStudentLogic(String name, ArrayList<Double> grades) {

        JSONArray current = getCurrentStudents();

        // new student JSON Object
        JSONObject newStudObj = new JSONObject();

        // parse full name
        String[] parts = name.split(" ");
        String fName = parts[0];
        String lName = parts[1];

        // add f and l name to JSON Object
        newStudObj.put("firstName", fName);
        newStudObj.put("lastName", lName);

        // add grades to JSON Array
        JSONArray ja = new JSONArray();
        JSONObject go;
        for (double grade : grades) {
            go = new JSONObject();
            go.put("grade", grade);
            ja.add(go);
        }

        // add grades to JSON Object
        newStudObj.put("grades", ja);

        // add new student JSON Object to current JSON Array of students
        current.add(newStudObj);

        writeToStudentJSONFile(current);

        return fName;
    }


    public void removeStudent(String name, ArrayList<ArrayList<String>> students) {

        JSONArray current = getCurrentStudents();

        ArrayList<String> nameAndIndexAndFoundStatus = findStudentByNameLogic(name, students);

        current.remove(Integer.parseInt(nameAndIndexAndFoundStatus.get(2)));

        writeToStudentJSONFile(current);

        if (nameAndIndexAndFoundStatus.get(3).equals("1"))
            System.out.println("Student " + nameAndIndexAndFoundStatus.get(0) + " " + nameAndIndexAndFoundStatus.get(1) + " was successfully removed :)");
    }


    public void updateStudent(String name, ArrayList<ArrayList<String>> students, ArrayList<ArrayList<Double>> grades) {

        JSONArray current = getCurrentStudents();

        ArrayList<String> nameAndIndexAndFoundStatus = findStudentByNameLogic(name, students);

        int currentStudentIndex = Integer.parseInt(nameAndIndexAndFoundStatus.get(2));

        String updatedStudentFName = "";
        if (nameAndIndexAndFoundStatus.get(3).equals("1")) {
            // TODO: Add loop and validation

            // save both grades and name
            ArrayList<String> studentName = students.get(currentStudentIndex);
            ArrayList<Double> studentGrades = grades.get(currentStudentIndex);

            System.out.println("What do you want to update about the Student?" +
                               "\n1 - Name" +
                               "\n2 - Grades");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                studentName = updateName();
            } else if (option.equals("2")) {
                studentGrades = updateGrades();
            }

            // remove student
            current.remove(currentStudentIndex);
            writeToStudentJSONFile(current);
            // add student new information to JSON Object
            String fullUpdatedName = studentName.get(0) + " " + studentName.get(1);
            updatedStudentFName = addStudentLogic(fullUpdatedName, studentGrades);
        }

        System.out.println("Student " + updatedStudentFName + " was successfully updated :)");
    }


    private ArrayList<String> updateName() {
        System.out.println("What is the students new name? (First Last)");
        String newName = scanner.nextLine();
        String[] parts = newName.split(" ");
        ArrayList<String> updatedName = new ArrayList<>();
        updatedName.add(parts[0]);
        updatedName.add(parts[1]);
        return updatedName;
    }


    private ArrayList<Double> updateGrades() {
        ArrayList<Double> newGrades = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Student Grade " + (i + 1));
            newGrades.add(Double.parseDouble(scanner.nextLine()));
        }
        return newGrades;
    }

    public void findStudentByName(String name, ArrayList<ArrayList<String>> students, ArrayList<ArrayList<Double>> grades) {

        ArrayList<String> nameAndIndexAndFoundStatus = findStudentByNameLogic(name, students);

        if (nameAndIndexAndFoundStatus.get(3).equals("1")) {
            ArrayList<Double> studentGrades = grades.get(Integer.parseInt(nameAndIndexAndFoundStatus.get(2)));
            System.out.println(
                    "\nFirst Name: " + nameAndIndexAndFoundStatus.get(0) +
                    "\nLast Name: " + nameAndIndexAndFoundStatus.get(1) +
                    "\nGrades: " +
                    "\n1: " + studentGrades.get(0) +
                    "\n2: " + studentGrades.get(1) +
                    "\n3: " + studentGrades.get(2) +
                    "\n4: " + studentGrades.get(3) +
                    "\n5: " + studentGrades.get(4)
            );
        }
    }


    private ArrayList<String> findStudentByNameLogic(String name, ArrayList<ArrayList<String>> students) {

        String indexOfStudent = "0";
        String found = "0";

        String[] parts = name.split(" ");
        String fName = parts[0];
        String lName = parts[1];

        for (int i = 0; i < students.size(); i++) {
            ArrayList<String> currentStudent = students.get(i);
            if (currentStudent.get(0).equals(fName) && currentStudent.get(1).equals(lName)) {
                indexOfStudent = String.valueOf(i);
                found = "1";
                break;
            } else if (i + 1 == students.size()) {
                System.out.println("No Student Found by " + fName + " " + lName);
            }
        }

        ArrayList<String> nameAndIndexAndFoundStatus = new ArrayList<>();
        nameAndIndexAndFoundStatus.add(fName);
        nameAndIndexAndFoundStatus.add(lName);
        nameAndIndexAndFoundStatus.add(indexOfStudent);
        nameAndIndexAndFoundStatus.add(found);
        return nameAndIndexAndFoundStatus;
    }


    private void writeToStudentJSONFile(JSONArray current) {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(current.toJSONString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("File Not Found :(");
        }
    }

    public void printAll(ArrayList<ArrayList<String>> students, ArrayList<ArrayList<Double>> grades) {
        for (ArrayList<String> name : students) {
            System.out.println(name.get(0) + " " + "\t\t\t" + name.get(1));
        }

    }


}
