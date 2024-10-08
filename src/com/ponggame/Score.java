package com.ponggame;

import java.awt.*;

public class Score {
    int width;
    int height;
    int player1Score;
    int player2Score;

    //Constructor to initialize the game window size and scores
    Score(int width, int height) {
        this.width = width;
        this.height = height;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    // Method to draw the scores on the screen
    public void draw(Graphics g) {
        g.setColor(Color.WHITE); // Set score color to white
        g.setFont(new Font("Consolas", Font.PLAIN, 50)); // Set the font for the scores

        // Draw player 1's score (on the left side of the screen)
        g.drawString(String.valueOf(player1Score), width / 4, 50);

        // Draw player 2's score (on the right side of the screen)
        g.drawString(String.valueOf(player2Score), 3 * width / 4, 50);
    }

    // Method to reset the scores
    public void reset() {
        player1Score = 0;
        player2Score = 0;
    }
}
