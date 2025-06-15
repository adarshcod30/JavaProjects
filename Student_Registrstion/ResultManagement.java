import java.util.ArrayList; // For sorting if needed, though not strictly required for finding max.
import java.util.List;
import java.util.Scanner;

// Main class to manage and test the examination result application
public class ResultManagement {

    private static Scanner scanner = new Scanner(System.in);

    // Method to get marks input safely
    private static int getMarksInput(String prompt, int max) {
        int marks;
        while (true) {
            System.out.print(prompt);
            try {
                marks = Integer.parseInt(scanner.nextLine());
                if (marks >= 0 && marks <= max) {
                    break;
                } else {
                    System.out.println("Invalid marks. Please enter a value between 0 and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return marks;
    }

    public static void main(String[] args) {
        ArrayList<ScienceStudent> students = new ArrayList<>();

        System.out.println("Welcome to Class XII Science Stream Result Management System!");

        // 1. Enter records for 5 students
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEntering details for Student " + (i + 1));

            System.out.print("Enter Roll Number: ");
            int rollNumber = getMarksInput("Roll Number (e.g., 101): ", 9999); // Reusing getMarksInput for roll num

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            List<Subject> studentSubjects = new ArrayList<>();

            // Compulsory Subjects
            System.out.println("\nEnter Compulsory Subjects:");
            String englishTheory = "english";
            int englishTheoryMarks = getMarksInput("Enter " + englishTheory + " Theory Marks (out of 100): ", 100);
            studentSubjects.add(new Subject(englishTheory, englishTheoryMarks, 0)); // English has no practical

            String compulsory2SubjectName;
            while (true) {
                System.out.print("Enter the second compulsory subject (Computer or Physical Education): ");
                compulsory2SubjectName = scanner.nextLine().toLowerCase();
                if (compulsory2SubjectName.equals("computer") || compulsory2SubjectName.equals("physical education")) {
                    break;
                } else {
                    System.out.println("Invalid compulsory subject. Please choose 'Computer' or 'Physical Education'.");
                }
            }
            int comp2TheoryMarks = getMarksInput("Enter " + compulsory2SubjectName + " Theory Marks (out of 60): ", 60);
            int comp2PracticalMarks = getMarksInput("Enter " + compulsory2SubjectName + " Practical Marks (out of 40): ", 40);
            studentSubjects.add(new Subject(compulsory2SubjectName, comp2TheoryMarks, comp2PracticalMarks));


            // Optional Subjects
            System.out.println("\nEnter Optional Subjects (Physics, Chemistry, Mathematics, Biology):");
            List<String> optionalChoices = new ArrayList<>();
            optionalChoices.add("physics");
            optionalChoices.add("chemistry");
            optionalChoices.add("mathematics");
            optionalChoices.add("biology");

            for (int j = 0; j < 3; j++) {
                String optionalSubjectName;
                while (true) {
                    System.out.print("Enter Optional Subject " + (j + 1) + " (Available: " + String.join(", ", optionalChoices) + "): ");
                    optionalSubjectName = scanner.nextLine().toLowerCase();
                    if (optionalChoices.contains(optionalSubjectName)) {
                        optionalChoices.remove(optionalSubjectName); // Remove chosen subject from choices
                        break;
                    } else {
                        System.out.println("Invalid optional subject or already chosen. Please select from available options.");
                    }
                }

                int optTheoryMarks, optPracticalMarks;
                if (optionalSubjectName.equals("mathematics")) {
                    optTheoryMarks = getMarksInput("Enter " + optionalSubjectName + " Theory Marks (out of 100): ", 100);
                    optPracticalMarks = 0; // Math has no practical
                } else {
                    optTheoryMarks = getMarksInput("Enter " + optionalSubjectName + " Theory Marks (out of 70): ", 70);
                    optPracticalMarks = getMarksInput("Enter " + optionalSubjectName + " Lab Marks (out of 30): ", 30);
                }
                studentSubjects.add(new Subject(optionalSubjectName, optTheoryMarks, optPracticalMarks));
            }

            // Create ScienceStudent object and add to list
            ScienceStudent student = new ScienceStudent(rollNumber, name, studentSubjects);
            students.add(student);
            System.out.println("Student record added successfully for " + name + ".");
        }

        System.out.println("\n--- All Student Records Entered ---");
        for (ScienceStudent student : students) {
            student.displayStudentDetails();
        }

        // 2. Display the student details with highest percentage
        displayHighestPercentageStudent(students);

        // 3. Display a record of student on the basis of Roll number
        System.out.print("\nEnter Roll Number to search for a student: ");
        int searchRollNumber = getMarksInput("Roll Number: ", 9999);
        displayStudentByRollNumber(students, searchRollNumber);

        scanner.close();
    }

    // Function to display the student details with the highest percentage
    public static void displayHighestPercentageStudent(List<ScienceStudent> students) {
        if (students.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        ScienceStudent highestPercentageStudent = students.get(0);
        for (ScienceStudent student : students) {
            if (student.getOverallPercentage() > highestPercentageStudent.getOverallPercentage()) {
                highestPercentageStudent = student;
            }
        }

        System.out.println("\n--- Student with Highest Percentage ---");
        highestPercentageStudent.displayStudentDetails();
    }

    // Function to display a record of student on the basis of Roll number
    public static void displayStudentByRollNumber(List<ScienceStudent> students, int rollNumber) {
        boolean found = false;
        for (ScienceStudent student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("\n--- Student Found (Roll Number: " + rollNumber + ") ---");
                student.displayStudentDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nNo student found with Roll Number: " + rollNumber);
        }
    }
}

