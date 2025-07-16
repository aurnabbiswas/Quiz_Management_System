# Java Quiz Management System

This is a console-based role-specific quiz application built using Java. The system allows admin users to add questions to a JSON-based question bank, and student users to take a quiz based on those questions.

## Features

- Admin can add multiple-choice questions with 4 options and an answer key.
- Student can take a quiz of 10 randomly selected questions.
- Scoring system based on number of correct answers.
- All questions and users are stored using JSON files.
- No negative marking during quiz evaluation.

## User Credentials

- Admin
  - Username: admin
  - Password: 1234

- Student
  - Username: salman
  - Password: 1234

## Files Used

- `users.json`: Stores login information and roles.
- `quiz.json`: Stores all multiple-choice questions.
- `src/main/java/quiz/`: Contains all Java classes.

## How to Run the Project

1. Clone the repository or download the project.
2. Open the project in IntelliJ IDEA (Community Edition recommended).
3. Add Gson dependency:
   - Go to `File > Project Structure > Libraries > + > From Maven`
   - Add: `com.google.code.gson:gson:2.8.9`
4. Make sure `users.json` and `quiz.json` are placed in the root directory of the project.
5. Run the program by right-clicking on `Main.java` and selecting `Run`.

## Quiz Flow

- Student must press 's' to start the quiz.
- Ten questions are selected randomly from the question bank.
- One mark is awarded for each correct answer.
- Score is shown at the end with feedback:
  - 8–10: Excellent
  - 5–7: Good
  - 3–4: Very Poor
  - 0–2: Failed
- Option to retake quiz after completion.

## Admin Flow

- Admin logs in and can add as many questions as desired.
- Admin enters question, 4 options, and correct answer number (1–4).
- Data is saved to `quiz.json` automatically.

## .gitignore

This project includes the following in `.gitignore`:
- .idea/
- .gradle/
- gradle/
- build/

## Demo

The project demo includes:
- Admin login and adding questions
- Student login and taking a quiz
- Score evaluation and restart option

### Project denmo video link: 
https://drive.google.com/file/d/1tR456AQ2QxOFMwAGQMtHYUgyCgJlpIqb/view?usp=sharing
