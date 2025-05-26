package studentgrades;

	import java.util.Scanner;
	import java.util.Arrays;
	import java.util.Comparator;
	public class StudentGrades {
		 public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		       
		        // Arrays to store student data
		        String[] studentNames = new String[5];
		        int[][] grades = new int[5][3];
		        double[] averages = new double[5];
		       
		        // Input student names and grades
		        for (int i = 0; i < 5; i++) {
		            System.out.print("Enter name for Student " + (i + 1) + ": ");
		            studentNames[i] = sc.nextLine();
		           
		            System.out.println("Enter grades for " + studentNames[i] + " (Subjects: Calculus 1, Symbolic Logic, Art Appreciation):");
		            for (int j = 0; j < 3; j++) {
		                System.out.print("Subject " + (j + 1) + ": ");
		                try {
		                    grades[i][j] = Integer.parseInt(sc.nextLine());
		                } catch (NumberFormatException e) {
		                    System.out.println("Please enter a valid number!");
		                    j--; // Retry this subject
		                }
		            }
		        }
		       
		        // Compute averages and find highest and lowest grades
		        int highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
		        int highestIndex = 0;
		       
		        for (int i = 0; i < 5; i++) {
		            int sum = 0;
		            for (int j = 0; j < 3; j++) {
		                sum += grades[i][j];
		                if (grades[i][j] > highest) highest = grades[i][j];
		                if (grades[i][j] < lowest) lowest = grades[i][j];
		            }
		            averages[i] = sum / 3.0;
		        }
		       
		        // Create a Student array for sorting
		        Student[] students = new Student[5];
		        for (int i = 0; i < 5; i++) {
		            students[i] = new Student(studentNames[i], grades[i], averages[i]);
		        }
		       
		        // Sort students by average grade in descending order
		        Arrays.sort(students, Comparator.comparing(Student::getAverage).reversed());
		       
		        // Print the entire table of grades (sorted by average)
		        System.out.println("\n----- STUDENT GRADES (Average) -----");
		        System.out.printf("%-15s %-10s %-10s %-10s %-10s%n",
		                         "Name", "Subject 1", "Subject 2", "Subject 3", "Average");
		        System.out.println("----------------------------------------------------");
		       
		        for (Student student : students) {
		            System.out.printf("%-15s %-10d %-10d %-10d %-10.2f%n",
		                             student.getName(),
		                             student.getGrades()[0],
		                             student.getGrades()[1],
		                             student.getGrades()[2],
		                             student.getAverage());
		        }
		       
		        // Display top performer
		        System.out.println("\nTop Performer: " + students[0].getName() +
		                          " with average grade: " + String.format("%.2f", students[0].getAverage()));
		       
		        // Display highest and lowest grades
		        System.out.println("Highest Grade in Class: " + highest);
		        System.out.println("Lowest Grade in Class: " + lowest);
		       
		        sc.close();
		    }
		}
		// Student class to facilitate sorting
		class Student {
		    private String name;
		    private int[] grades;
		    private double average;
		   
		    public Student(String name, int[] grades, double average) {
		        this.name = name;
		        this.grades = grades;
		        this.average = average;
		    }
		   
		    public String getName() {
		        return name;
		    }
		   
		    public int[] getGrades() {
		        return grades;
		    }
		   
		    public double getAverage() {
		        return average;
		    }
		}

