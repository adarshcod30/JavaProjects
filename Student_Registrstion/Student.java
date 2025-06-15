// Base class for general student information
class Student {
    private int rollNumber;
    private String name;

    // Constructor to initialize student details
    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    // Getter for roll number
    public int getRollNumber() {
        return rollNumber;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Method to display basic student details
    public void displayBasicDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
    }
}
