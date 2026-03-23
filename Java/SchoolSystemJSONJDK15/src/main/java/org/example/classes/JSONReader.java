package org.example.classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

// TODO: add comments
public class JSONReader {

    // parallel arrays instead of object storing, reinforcing datastructures with Lists
    private static final ArrayList<ArrayList<Double>> studentGrades = new ArrayList<>();
    private static final ArrayList<ArrayList<String>>  studentNames = new ArrayList<>();

    String filePath;

    public JSONReader(String filePath) {
        this.filePath = filePath;
    }

    public void readJson() throws Exception {

        studentNames.clear();
        studentGrades.clear();

        // parse JSON
        Object obj = new JSONParser().parse(new FileReader(filePath));

        // JSON file has multiple student objects; parse into jsonArray for all JSON objects
        JSONArray jsonArray = (JSONArray) obj;
        for (int i = 0; i < jsonArray.size(); i++) {

            // Students Names
            ArrayList<String> studentFandLName = new ArrayList<>();

            // turn each object into a JSONObject
            JSONObject object = (JSONObject) jsonArray.get(i);

            // get first and last name from current object
            String firstName = (String) object.get("firstName");
            String lastName = (String) object.get("lastName");

            // add first and last name into 2d studentNames array
            studentFandLName.add(firstName);
            studentFandLName.add(lastName);
            studentNames.add(studentFandLName);

            // Student Grades
            ArrayList<Double> studentGrade = new ArrayList<>();

            JSONArray studentGradesArray = (JSONArray) object.get("grades");
            for (int j = 0; j < studentGradesArray.size(); j++) {
                JSONObject studentGradesObject = (JSONObject) studentGradesArray.get(j);
                double grade = (double) studentGradesObject.get("grade");
                studentGrade.add(grade);
            }
            studentGrades.add(studentGrade);

        }
    }

    public ArrayList<ArrayList<String>> getStudentNames() {
        return studentNames;
    }

    public ArrayList<ArrayList<Double>> getStudentGrades() {
        return studentGrades;
    }



}
