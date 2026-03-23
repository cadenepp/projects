# 🧠 Java Console Project — Student Gradebook Manager (JDK 15)

## 🎯 Goal

Strengthen your Java fundamentals by building a **console-based Gradebook application** that uses dynamic 2D data structures and JSON integration.  
You will practice working with `ArrayList`, `java.util` utilities, sorting, filtering, and data parsing — while handling input and output safely in a real-world scenario.

---

## 🧩 Learning Objectives

By completing this project, you will:

- Build and manipulate **2D `ArrayList` structures** (lists of lists).
- Practice **adding**, **inserting**, **removing**, and **modifying** elements dynamically.
- Learn to use key collection methods: `.set()`, `.get()`, `.add()`, `.remove()`, `.size()`.
- Parse **string inputs** into numeric types (integers, doubles, etc.).
- Sort and filter using `Collections.sort()`, `Comparator`, and streams.
- Apply **exception handling** for invalid input or index access.
- Use utilities from `java.util` (`Arrays`, `Collections`, `Comparator`, `Scanner`, `Optional`).
- Parse and manipulate **JSON data** using a library like `Gson` or `org.json`.
- Convert JSON data into **2D `ArrayList`** form and export back to JSON.

---

## 🗂️ Step 1: Project Setup

1. Create a new Java project using **JDK 15**.
2. Name the main class file `GradebookApp.java`.
3. Add a JSON parsing library dependency (recommended: **Gson**).
4. Create a `data` folder for your JSON files or test data.
5. Confirm your environment supports console input/output.

---

## 🧱 Step 2: Define the Project Theme

You will build a **Student Gradebook Manager** that:

- Loads student names and grades from a JSON file or string.
- Stores that information in a **2D `ArrayList`** (each row = one student).
- Allows the user to:
    - Add new students.
    - Update or remove existing ones.
    - Modify individual grades.
    - Calculate averages.
    - Sort students by name or grade average.
- Saves the modified data back into JSON.

---

## 🧾 Step 3: Design the Data Structure

Each student will have:

- A `name` (string).
- A list of `grades` (list of integers).

Conceptually, this maps to:

- A **list of students** (the outer `ArrayList`).
- Each student contains another list of grades (the inner `ArrayList`).

The data structure should allow:

- Access by **row** (student).
- Access by **column** (grade).
- **Nested iteration** and modification.

---

## 📄 Step 4: Create JSON Test Data

1. Create a new file named `students.json` inside your project’s `data` folder.
2. Structure it as follows:
    - A root key representing the dataset (e.g., `"students"`).
    - Each element containing a student object with:
        - A `"name"` field (string).
        - A `"grades"` array (list of integers).
3. Include at least **3–5 students** for testing.
4. Ensure your JSON format matches the 2D list concept — one list for all students, one nested list for each student’s grades.

---

## 🔍 Step 5: Plan the Core Program Flow

1. Load the JSON data from a file or a string variable.
2. Parse it into Java objects.
3. Convert those objects into a 2D `ArrayList` structure.
4. Display the data in a readable format.
5. Provide a simple **menu loop** in the console with options:
    - View all students.
    - Add a new student.
    - Remove a student.
    - Update a grade.
    - Sort by name or average.
    - Export and exit.
6. Each menu action should modify the `ArrayList` data directly.

---

## 🧠 Step 6: Implement Core Concepts

Focus on applying and understanding:

### Adding and Removing Elements
- Use `.add()` and `.remove()` for students and grades.
- Handle index validation using condition checks and try-catch blocks.

### Accessing and Modifying Data
- Use `.get()` and `.set()` for individual grade updates.
- Practice **nested loops** to traverse the 2D structure.

### Calculating Averages
- Iterate through grade lists to compute each student’s average score.

### Sorting and Filtering
- Implement sorting by **name** (alphabetical).
- Implement sorting by **average** (descending).
- Optionally, add filtering (e.g., show only passing students).

### Parsing and Type Conversion
- Convert user inputs (strings) to integers safely.
- Handle invalid input using exception handling (`try`/`catch`).

### JSON Integration
- Parse JSON into Java objects (using Gson or org.json).
- Extract student data into your 2D `ArrayList`.
- After editing, reassemble and export it back into JSON format.

---

## 💡 Step 7: Add Console Interaction

1. Use the `Scanner` class for reading user input.
2. Create a loop that displays the available menu actions.
3. Ensure each option calls a method that performs a specific task:
    - `addStudent()`
    - `removeStudent()`
    - `updateGrade()`
    - `sortStudents()`
    - `exportToJson()`
4. Provide clear **success/error messages** for every operation.
5. Validate all inputs (empty strings, invalid indices, etc.).

---

## 💾 Step 8: Export Updated Data

1. After user operations, convert your in-memory data back into JSON.
2. Save or print it to the console for review.
3. Use **pretty printing** for readable JSON output.
4. Confirm that:
    - All student changes persist.
    - The JSON structure matches the original schema.

---

## 🚀 Step 9: Stretch Goals

Once the main app works, enhance it by:

- Allowing **multi-field sorting** (by name, then by average).
- Supporting **dynamic subjects** (variable number of grades per student).
- Adding **search filters** (e.g., find students above a threshold).
- Implementing **lambda expressions** and **streams** for filtering/sorting.
- Writing changes to a local JSON file automatically.
- Handling **empty datasets** or **duplicate names** gracefully.
- Adding **data validation rules** (e.g., grade must be between 0–100).

---

## 🧩 Step 10: Review and Reflect

When finished:

- Review how **2D `ArrayList` indexing** works.
- Revisit how **JSON maps to nested lists**.
- Reflect on how **sorting and filtering** are implemented.
- Identify which Java utilities (`Arrays`, `Collections`, etc.) made tasks easier.
- Practice explaining your design decisions aloud — as if presenting to a team.

---

## 🧭 Skills Reinforced

| Category | Concepts Mastered |
|-----------|-------------------|
| **Core Java** | `ArrayList`, `Collections`, `Comparator`, `Scanner` |
| **Data Structures** | 2D nested lists, list operations |
| **JSON Handling** | Parsing, mapping, and exporting structured data |
| **Error Handling** | Input validation, exception management |
| **Data Processing** | Sorting, filtering, and iteration logic |
| **Code Design** | Modular method structure, reusability, readability |

---

## ✅ Outcome

By completing this project, you’ll have a full understanding of:

- Managing complex 2D data with Java’s collection framework.
- Handling real-world JSON input/output workflows.
- Writing maintainable and safe console applications.
- Using Java utilities effectively to manipulate, sort, and validate data.
