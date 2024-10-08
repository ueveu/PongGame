package com.ponggame;

import javax.swing.*; // GUI
import java.awt.*; // Import for graphics
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    Paddle player1, player2;
    Ball ball;
    Score score;
    Timer timer;

    GamePanel() {
        // Create player 1 and player 2 paddles
        player1 = new Paddle(50, 250); // Player 1 paddle position at (50, 250) LEFT
        player2 = new Paddle(730, 250); // Player 2 paddle at position (730, 250) RIGHT
        ball = new Ball(390, 290); // Ball starting position in the center of the screen
        score = new Score(800,600); // Initialize the score with the window size

        this.setPreferredSize(new Dimension(800, 600)); // Set the game window size to 800x600
        this.setBackground(Color.BLACK); // Set the background color to black

        // Create a timer that calls the actionPerformed method every 10 milliseconds
        timer = new Timer(10, this); // Updates game every 10 milliseconds
        timer.start(); // Start the timer to keep updating the game
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the screen before redrawing (important for smooth graphics)
        player1.draw(g); // Draw player 1's paddle
        player2.draw(g); // Draw player 2's paddle
        ball.draw(g); // Draw the ball
        score.draw(g); // Draw the scores
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.move(player1, player2); // Update the ball's position and check for paddle collisions

        // Check if player1 or player2 missed the ball
        if (ball.x <= 0) { // player1 missed the ball
            score.player2Score++; // increase player 2's score
            resetBall(); // Reset the ball to the center
        }
        if (ball.x >= 780) { // Player2 missed the ball
            score.player2Score++;
            resetBall();
        }

        repaint(); // repaint the game panel to show the updated ball position
    }
    // Reset the ball to the center of the screen after a point is scored
    public void resetBall() {
        ball.x = 390;  // Reset the ball's y position
        ball.y = 290; // Reset ball's x position
        ball.xVelocity = -ball.xVelocity; // Reverse the ball's direction after each point
    }
}
