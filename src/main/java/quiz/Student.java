package quiz;

import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Student {
    private final String QUIZ_FILE = "quiz.json";
    private final Gson gson = new Gson();
    private final Scanner scanner = new Scanner(System.in);

    public void takeQuiz() {
        while (true) {
            List<Question> questions = loadQuestions();
            if (questions.size() < 1) {
                System.out.println("No questions available.");
                return;
            }

            System.out.println("We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start.");
            String ready = scanner.nextLine().trim();
            if (!ready.equalsIgnoreCase("s")) {
                System.out.println("Exiting quiz...");
                return;
            }

            Collections.shuffle(questions);
            int score = 0;
            int count = Math.min(10, questions.size());

            for (int i = 0; i < count; i++) {
                Question q = questions.get(i);
                System.out.printf("[%d] %s%n", i + 1, q.getQuestion());
                System.out.printf("1. %s%n2. %s%n3. %s%n4. %s%n", q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
                System.out.print("Answer (1-4): ");
                int ans;

                try {
                    ans = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Skipping question.");
                    continue;
                }

                if (ans == q.getAnswerKey()) {
                    score++;
                }
            }

            System.out.println("You have got " + score + " out of " + count);
            if (score >= 8) System.out.println("Excellent!");
            else if (score >= 5) System.out.println("Good.");
            else if (score >= 3) System.out.println("Very poor!");
            else System.out.println("Very sorry you are failed.");

            System.out.println("Would you like to start again? Press 's' for start or 'q' for quit:");
            String again = scanner.nextLine().trim();
            if (!again.equalsIgnoreCase("s")) {
                System.out.println("Thank you for taking the quiz!");
                break;
            }
        }
    }

    private List<Question> loadQuestions() {
        try {
            FileReader reader = new FileReader(QUIZ_FILE);
            List<Question> questions = gson.fromJson(reader, new TypeToken<List<Question>>() {}.getType());
            reader.close();
            return questions;
        } catch (Exception e) {
            System.out.println("Failed to load questions.");
            return Collections.emptyList();
        }
    }
}
