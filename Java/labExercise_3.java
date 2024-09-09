import java.util.Scanner;

public class labExercise_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pythonGrade = getGrade(scanner, "Python");
        double javaGrade = getGrade(scanner, "Java");
        double phpGrade = getGrade(scanner, "PHP");
        double javascriptGrade = getGrade(scanner, "Javascript");

        double averageGrade = calculateAverage(pythonGrade, javaGrade, phpGrade, javascriptGrade);

        printResults(pythonGrade, javaGrade, phpGrade, javascriptGrade, averageGrade);
    }

    public static double getGrade(Scanner scanner, String subject) {
        System.out.print("Enter your grade in " + subject + ": ");
        return scanner.nextDouble();
    }

    public static double calculateAverage(double... grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public static void printResults(double pythonGrade, double javaGrade, double phpGrade, double javascriptGrade,
            double averageGrade) {
        String passedSubjects = "";
        String failedSubjects = "";

        if (pythonGrade >= 60) {
            passedSubjects += "Python, ";
        } else {
            failedSubjects += "Python, ";
        }

        if (javaGrade >= 60) {
            passedSubjects += "Java, ";
        } else {
            failedSubjects += "Java, ";
        }

        if (phpGrade >= 60) {
            passedSubjects += "PHP, ";
        } else {
            failedSubjects += "PHP, ";
        }

        if (javascriptGrade >= 60) {
            passedSubjects += "javascript, ";
        } else {
            failedSubjects += "JavaScript, ";
        }

        passedSubjects = passedSubjects.replaceAll(", $", "");
        failedSubjects = failedSubjects.replaceAll(", $", "");

        System.out.println("You passed your subjects: " + passedSubjects);
        System.out.println("You failed your subject: " + failedSubjects);

        System.out.println(
                "Your average grade is " + averageGrade + " and you " + (averageGrade >= 60 ? "passed" : "failed"));
    }
}