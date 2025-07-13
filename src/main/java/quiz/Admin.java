package quiz;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Admin {
    private final String QUIZ_FILE = "quiz.json";
    private final Scanner scanner = new Scanner(System.in);
    private final Gson gson = new Gson();

    public void addQuestions() {
        System.out.println("Welcome admin! Please create new questions in the question bank.");
        while (true) {
            System.out.print("Input your question: ");
            String question = scanner.nextLine();

            System.out.print("Input option 1: ");
            String opt1 = scanner.nextLine();
            System.out.print("Input option 2: ");
            String opt2 = scanner.nextLine();
            System.out.print("Input option 3: ");
            String opt3 = scanner.nextLine();
            System.out.print("Input option 4: ");
            String opt4 = scanner.nextLine();
            System.out.print("What is the answer key? (1-4): ");
            int answerKey = Integer.parseInt(scanner.nextLine());

            Question q = new Question(question, opt1, opt2, opt3, opt4, answerKey);
            List<Question> questions = readQuestions();
            questions.add(q);
            saveQuestions(questions);

            System.out.println("Saved successfully!");
            System.out.print("Do you want to add more questions? (press 's' to start, 'q' to quit): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) break;
        }
    }

    private List<Question> readQuestions() {
        try {
            FileReader reader = new FileReader(QUIZ_FILE);
            List<Question> questions = gson.fromJson(reader, new TypeToken<List<Question>>(){}.getType());
            reader.close();
            if (questions != null) return questions;
        } catch (Exception ignored) {}
        return new ArrayList<>();
    }

    private void saveQuestions(List<Question> questions) {
        try {
            FileWriter writer = new FileWriter(QUIZ_FILE);
            gson.toJson(questions, writer);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Failed to save question: " + e.getMessage());
        }
    }
}
