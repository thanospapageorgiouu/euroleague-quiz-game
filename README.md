# EuroLeague Quiz Game

A two-player quiz game inspired by the EuroLeague, built with Java and JavaFX.

The project started as a general quiz application and evolved into a two-player, board-based quiz game. Players take turns selecting questions from different categories and earn points based on the selected question.

## Features

- Two-player local gameplay
- Category-based game board
- Turn-based question selection
- Multiple-choice questions
- Score tracking for both players
- Questions loaded from JSON files
- Category-specific question data
- JavaFX-based graphical user interface
- Object-oriented project structure

## Technologies

- Java 21
- JavaFX 21.0.2
- Maven
- Gson 2.14.0
- JSON
- Git / GitHub

## Project Structure

The application is organized into separate packages based on responsibility:

src/
└── main/
    ├── java/
    │   └── com/ath/euroquiz/
    │       ├── enums/
    │       ├── loaders/
    │       ├── managers/
    │       ├── models/
    │       └── views/
    └── resources/
        └── *_questions.json

### Main Components

- **models/** — Domain objects such as players and questions
- **views/** — JavaFX screens and user interface components
- **managers/** — Game and quiz logic
- **loaders/** — Loading question data from JSON resources
- **enums/** — Application enums such as question categories
- **resources/** — Category-specific question data in JSON format

## How It Works

1. Two players start a game from the main menu.
2. The game board displays available question categories and point values.
3. The current player selects a question.
4. The selected question is displayed with multiple answer choices.
5. The player's score is updated based on the answer.
6. The turn switches to the other player.
7. Used questions are disabled on the board.

## Running the Project

### Requirements

- JDK 21 or later
- Maven

### Run with Maven

Clone the repository:

git clone https://github.com/thanospapageorgiouu/euroleague-quiz-game.git
cd euroleague-quiz-game

Run the application:

mvn javafx:run

## Current Status

The project is actively being developed. New question categories, gameplay features, and UI improvements are being added as development continues.

## Future Improvements

- Expand the question database
- Add more question types
- Improve the visual design and user experience
- Add additional game mechanics
- Improve game-state management
- Refine the overall architecture

## Author

**Thanos Papageorgiou**

Computer Science student at Athens University of Economics and Business, interested in Software Engineering and Java development.
