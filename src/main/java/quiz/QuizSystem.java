package quiz;

import java.util.Scanner;

public class QuizSystem {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine().trim();

        UserManager userManager = new UserManager();
        User user = userManager.authenticate(username, password);

        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        if ("admin".equals(user.getRole())) {
            Admin admin = new Admin();
            admin.addQuestions();
        } else {
            Student student = new Student();
            student.takeQuiz();
        }
    }
}

