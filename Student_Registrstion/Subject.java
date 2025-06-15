class Subject {
    private String subjectName;
    private int theoryMarks;
    private int practicalMarks; // For subjects with practical/lab component
    private int maxTheoryMarks;
    private int maxPracticalMarks;
    private int totalObtainedMarks;
    private int maxTotalMarks;

    // Constructor for Subject
    public Subject(String subjectName, int theoryMarks, int practicalMarks) {
        this.subjectName = subjectName;
        this.theoryMarks = theoryMarks;
        this.practicalMarks = practicalMarks;
        initializeSubjectMaxMarks(); // Call method to set max marks and calculate totals
    }

    // Private method to set maximum marks based on subject name
    private void initializeSubjectMaxMarks() {
        switch (subjectName.toLowerCase()) {
            case "physics":
            case "chemistry":
            case "biology":
                maxTheoryMarks = 70;
                maxPracticalMarks = 30;
                break;
            case "mathematics":
            case "english":
                maxTheoryMarks = 100;
                maxPracticalMarks = 0; // Mathematics and English have no practical/lab
                break;
            case "computer":
            case "physical education":
                maxTheoryMarks = 60;
                maxPracticalMarks = 40;
                break;
            default:
                // Default for unexpected subjects, or can throw an error
                System.err.println("Warning: Unknown subject " + subjectName + ". Assuming 100 marks total (100 theory, 0 practical).");
                maxTheoryMarks = 100;
                maxPracticalMarks = 0;
                break;
        }

        // Calculate total obtained marks and total maximum marks
        this.totalObtainedMarks = theoryMarks + practicalMarks;
        this.maxTotalMarks = maxTheoryMarks + maxPracticalMarks;

        // Basic validation for marks entered (optional, but good practice)
        if (theoryMarks > maxTheoryMarks || practicalMarks > maxPracticalMarks) {
            System.err.println("Error: Marks entered for " + subjectName + " exceed maximum allowed.");
        }
    }

    // Getter for subject name
    public String getSubjectName() {
        return subjectName;
    }

    // Getter for theory marks obtained
    public int getTheoryMarks() {
        return theoryMarks;
    }

    // Getter for practical marks obtained
    public int getPracticalMarks() {
        return practicalMarks;
    }

    // Getter for total obtained marks in the subject
    public int getTotalObtainedMarks() {
        return totalObtainedMarks;
    }

    // Getter for maximum total marks for the subject
    public int getMaxTotalMarks() {
        return maxTotalMarks;
    }

    // Method to display subject details
    public void displaySubjectDetails() {
        System.out.println("    Subject: " + subjectName);
        System.out.println("        Theory Marks: " + theoryMarks + " / " + maxTheoryMarks);
        System.out.println("        Practical Marks: " + practicalMarks + " / " + maxPracticalMarks);
        System.out.println("        Total Obtained: " + totalObtainedMarks + " / " + maxTotalMarks);
    }
}
