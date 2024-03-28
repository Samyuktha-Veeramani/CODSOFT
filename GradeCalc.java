import java.util.Scanner;

public class GradeCalc{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the name of the student:");
        String name=scanner.nextLine();

        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + (i+1) + ":");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
        
        double avgPercentage = (double) totalMarks / numSubjects;
        
        System.out.println("Student Name:"+name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        
        char grade = calcGrade(avgPercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
    
    public static char calcGrade(double avgPercentage) {
        if (avgPercentage >= 90) {
            return 'A';
        } else if (avgPercentage >= 80) {
            return 'B';
        } else if (avgPercentage >= 70) {
            return 'C';
        } else if (avgPercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

