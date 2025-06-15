import java.util.List; // For sorting if needed, though not strictly required for finding max.
class ScienceStudent extends Student {
    private List<Subject> subjects; // List to hold all 5 subjects
    private double overallPercentage;
    private String grade;

    // Constructor for ScienceStudent
    public ScienceStudent(int rollNumber, String name, List<Subject> subjects) {
        super(rollNumber, name); // Call parent class constructor
        this.subjects = subjects;
        calculateOverallPercentageAndGrade(); // Calculate percentage and grade upon creation
    }

    // Method to calculate overall percentage and assign grade
    private void calculateOverallPercentageAndGrade() {
        int totalMarksObtained = 0;
        int totalMaxMarks = 0;

        for (Subject subject : subjects) {
            totalMarksObtained += subject.getTotalObtainedMarks();
            totalMaxMarks += subject.getMaxTotalMarks();
        }

        // Avoid division by zero
        if (totalMaxMarks > 0) {
            this.overallPercentage = (double) totalMarksObtained / totalMaxMarks * 100;
        } else {
            this.overallPercentage = 0.0;
        }

        determineGrade(); // Determine grade based on calculated percentage
    }

    // Method to determine the grade based on percentage
    private void determineGrade() {
        if (overallPercentage >= 80) {
            this.grade = "Honours";
        } else if (overallPercentage >= 60) {
            this.grade = "First Div";
        } else if (overallPercentage >= 48) {
            this.grade = "Second Div";
        } else if (overallPercentage >= 40) {
            this.grade = "Third Div";
        } else {
            this.grade = "Failed";
        }
    }

    // Getter for overall percentage
    public double getOverallPercentage() {
        return overallPercentage;
    }

    // Getter for grade
    public String getGrade() {
        return grade;
    }

    // Method to display all details of the science student
    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        super.displayBasicDetails(); // Display basic details from parent class
        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            subject.displaySubjectDetails(); // Display details for each subject
        }
        System.out.printf("Overall Percentage: %.2f%%\n", overallPercentage);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------\n");
    }
}
