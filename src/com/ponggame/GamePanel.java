package com.ponggame;

import javax.swing.*; // GUI
import java.awt.*; // Import for graphics
import java.awt.event.*;


public class GamePanel extends JPanel implements ActionListener, KeyListener {

    Paddle player1, player2;
    Ball ball;
    Score score;
    Timer timer;
    boolean gameOver = false; // Track if the game is over
    final int WIN_SCORE = 10; // Score required to win

    GamePanel() {
        // Create player 1 and player 2 paddles
        player1 = new Paddle(50, 250); // Player 1 paddle position at (50, 250) LEFT
        player2 = new Paddle(730, 250); // Player 2 paddle at position (730, 250) RIGHT
        ball = new Ball(390, 290); // Ball starting position in the center of the screen
        score = new Score(800,600); // Initialize the score with the window size


        this.setPreferredSize(new Dimension(800, 600)); // Set the game window size to 800x600
        this.setBackground(Color.BLACK); // Set the background color to black
        this.setFocusable(true); // Allow panel to receive keyboard input
        this.addKeyListener(this); // Add the key Listener to listen for keyboard events


        // Create a timer that calls the actionPerformed method every 10 milliseconds
        timer = new Timer(10, this); // Updates game every 10 milliseconds
        timer.start(); // Start the timer to keep updating the game
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the screen before redrawing (important for smooth graphics)

        if(!gameOver) {
            player1.draw(g); // Draw player 1's paddle
            player2.draw(g); // Draw player 2's paddle
            ball.draw(g); // Draw the ball
            score.draw(g); // Draw the score
        } else {
            drawWinner(g); // Draw the Winning Message
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            ball.move(player1, player2); // Update the ball's position and check for paddle collisions
            player1.move(); // Update player 1's position
            player2.move(); // Update player 2's position

            // Check if player1 or player2 missed the ball
            if (ball.x <= 0) { // player1 missed the ball
                score.player2Score++; // increase player 2's score
                resetBall(); // Reset the ball to the center
            }
            if (ball.x >= 780) { // Player2 missed the ball
                score.player1Score++; // Increase Player2's score
                resetBall(); // Reset the ball to the center
            }

            // Check for win condition
            if (score.player1Score >= WIN_SCORE) {
                gameOver = true; // End the game if player 1's score equals WIN_SCORE
            } else if (score.player2Score >= WIN_SCORE) {
                gameOver = true; // End the game if player 2's score equals WIN_SCORE
            }
        }
        repaint(); // repaint the game panel to show the updated ball position and scores
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
            resetGame(); // Reset the Game if "R" sis press
        } else {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    player1.setYDirection(-5); // Move player 1's paddle up
                    break;
                case KeyEvent.VK_S:
                    player1.setYDirection(5); // Move Player 1's paddle down
                    break;
                case KeyEvent.VK_UP:
                    player2.setYDirection(-5); // Move Player 2's paddle up
                    break;
                case KeyEvent.VK_DOWN:
                    player2.setYDirection(5); // Move Player 2's paddle up
                    break;
            }
        }
    }
@Override
public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                player1.setYDirection(0); // Stop player 1's paddle movement
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player2.setYDirection(0); // Stop player 2's paddle movement
                break;
        }
}
@Override
public void keyTyped(KeyEvent e) {
        // not used
}

    // Reset the ball to the center of the screen after a point is scored
    public void resetBall() {
        ball.x = 390;  // Reset the ball's y position
        ball.y = 290; // Reset ball's x position
        ball.xVelocity = -ball.xVelocity; // Reverse the ball's direction after each point
    }

    // Reset the game to the initial state
    public void resetGame() {
        score.reset(); // reset scores to 0
        resetBall(); // reset ball position
        player1.y = 250; // Reset player 1's paddle position
        player2.y = 250; // Reset Player 2's paddle position
        gameOver = false; // resume the game
    }

    // Draw the winning message
    public void drawWinner(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 50));
        String winner = score.player1Score <= WIN_SCORE ? "Player 1 Wins" : "Player 2 Wins";
        g.drawString(winner, 250, 300); // Draw the winner text in the middle of the screen
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString("Press 'R' to Restart", 250, 350); // Prompt to restart
    }
}
