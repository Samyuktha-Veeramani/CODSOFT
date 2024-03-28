import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static final int QUESTION_TIME_LIMIT = 5; 
    private static int score = 0;
    private static int currentQuestionIndex = 0;

    private static final String[] questions = {
        "What is the output of the following code snippet?\nint x = 5;\nint y = 2;\nSystem.out.println(x / y);",
        "Which keyword is used to define a constant in Java?",
        "What will be the output of the following code?\nString str = \"Java\";\nstr.concat(\" is fun\");\nSystem.out.println(str);",
        "Which of the following is not a valid identifier in Java?",
        "What is the correct way to declare a two-dimensional array in Java?"
    };

    private static final String[][] options = {
        {"A. 2", "B. 2.5", "C. 2.0", "D. Compilation Error"},
        {"A. const", "B. final", "C. static", "D. constant"},
        {"A. Java", "B. Java is fun", "C. is fun", "D. Compilation Error"},
        {"A. _variableName", "B. 123variable", "C. $variableName", "D. variableName"},
        {"A. int[][] array;", "B. int[][] array = new int[][];", "C. int[][] array = new int[rows][columns];", "D. int[][] array = new int[];"}
    };

    private static final char[] correctAnswers = {'A', 'B', 'A', 'B', 'C'};

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz App!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up!");
                    System.out.println("Moving to the next question...");
                    timer.cancel();
                    displayNextQuestion(scanner);
                }
            };
            timer.schedule(task, QUESTION_TIME_LIMIT * 1000);

            System.out.print("\nEnter your answer (A, B, C, or D): ");
            String userAnswer = scanner.nextLine().toUpperCase().trim();

            if (!userAnswer.isEmpty() && userAnswer.charAt(0) == correctAnswers[i]) {
                score++;
                System.out.println("Correct!");
            } else if (!userAnswer.isEmpty()) {
                System.out.println("Incorrect! The correct answer is " + correctAnswers[i]);
            }

            timer.cancel();
            displayNextQuestion(scanner);
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        scanner.close();
    }

    private static void displayNextQuestion(Scanner scanner) {
        System.out.println("Press Enter to continue...");
        
    }
}
