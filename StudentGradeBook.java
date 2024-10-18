import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averageScores = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            studentNames[i] = scanner.next();

            double total = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
                total += grades[i][j];
            }
            averageScores[i] = total / numAssignments;
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + "\t");
            for (int j = 0; j < numAssignments; j++) {
                System.out.print(grades[i][j] + "\t");
            }
            String grade = assignGrade(averageScores[i]);
            System.out.printf("%.2f\t%s%n", averageScores[i], grade);
        }

        double highestAverage = averageScores[0];
        double lowestAverage = averageScores[0];
        for (int i = 1; i < numStudents; i++) {
            if (averageScores[i] > highestAverage) {
                highestAverage = averageScores[i];
            }
            if (averageScores[i] < lowestAverage) {
                lowestAverage = averageScores[i];
            }
        }
        System.out.println("Highest Average: " + highestAverage);
        System.out.println("Lowest Average: " + lowestAverage);

        sortStudents(studentNames, averageScores);

        System.out.println("\nSorted by average scores:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%s - %.2f%n", studentNames[i], averageScores[i]);
        }

        scanner.close();
    }

    public static String assignGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void sortStudents(String[] names, double[] averages) {
        for (int i = 0; i < averages.length - 1; i++) {
            for (int j = 0; j < averages.length - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }
    }
}