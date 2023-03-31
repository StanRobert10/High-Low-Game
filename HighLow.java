import java.util.Random;
import javax.swing.*;

class HighLowGame {
    private int currentCard; // variable to store the current card
    private int score; // variable to store the user's score
    private final Random rand; // object to generate random numbers
    private boolean loggedIn; // variable to check if the user is logged in

    public HighLowGame() {
        rand = new Random(); // initialize the random object
        currentCard = rand.nextInt(13) + 1; // generates a random number between 1 and 13
        score = 0; // initialize score1 to 0
        loggedIn = false; // initialize loggedIn to false
    }

    public void login() {
        // loop until user is logged in
        while (!loggedIn) {
            String username = JOptionPane.showInputDialog("Enter your username:"); // prompt for username
            String password = JOptionPane.showInputDialog("Enter your password:"); // prompt for password
            // check if the entered username and password are valid
            if (username.equals("player1") && password.equals("password1") || username.equals("player2") && password.equals("password2")) {
                JOptionPane.showMessageDialog(null, "Welcome, " + username + "!");
                loggedIn = true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
            }
        }
    }

    public int play() {
        login(); // call the login method
        // game loop
        while (true) {
            // prompt for user's guess
            int guess = Integer.parseInt(JOptionPane.showInputDialog("Guess if the next card will be higher or lower."+" The current card is " + currentCard + " (1 = higher, 0 = lower)"));
            int nextCard = rand.nextInt(13) + 1; // generate the next card
            // check if the guess is correct
            if (guess == 1 && nextCard > currentCard) {
                JOptionPane.showMessageDialog(null, "Correct! The card was " + nextCard);
                score++;
            } else if (guess == 0 && nextCard < currentCard) {
                JOptionPane.showMessageDialog(null, "Correct! The card was " + nextCard);
                score++;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect. The card was " + nextCard);
                break;
            }
            currentCard = nextCard;
        }
        JOptionPane.showMessageDialog(null, "Your score was " + score);
        return score;
    }

    public static void main(String[] args) {
        int score1, score2;
        HighLowGame game= new HighLowGame();
        HighLowGame game2 = new HighLowGame();
        score1 = game.play();
        score2 = game2.play();

        if (score1 > score2){
            JOptionPane.showMessageDialog(null, "The winner is Player1 with a total of " + score1 + " points!");
        } else if (score1 < score2){
            JOptionPane.showMessageDialog(null, "The winner is Player2 with a total of " + score2 + " points!");
        } else {
            JOptionPane.showMessageDialog(null, "Congratulations you both have " + score2 + " points!\n Draw!!!");
        }
    }
}
