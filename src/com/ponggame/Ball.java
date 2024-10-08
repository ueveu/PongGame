package com.ponggame;

import java.awt.*; // import for drawing the ball


public class Ball {
    int x,y, diameter = 20; // Ball and position size
    int xVelocity = 5; // Ball speed in x direction
    int yVelocity = 5; // Ball speed y direction

    // Constructor to initialize ball's position
    Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Method to update the ball's position and handle collisions
    public void move(Paddle player1, Paddle player2) {
        // Update the ball's position based on its velocity
        x += xVelocity;
        y += yVelocity;

        // Bounce the ball off the top and bottom walls
        if (y <= 0 || y >= 600) { // Use window height directly, ball size included
            yVelocity = -yVelocity; // Reserve the balls direction on the y-axis
        }

        // Collision  with player 1's paddle (left paddle)
        if (x <= player1.x + player1.width && y + diameter >= player1.y && y <= player1.y + player1.height) {
            xVelocity = -xVelocity;  // Reverse the ball's direction on the x-axis when hitting player 1's paddle
            x = player1.x + player1.width; // Adjust ball position to avoid overlap
        }
        // Collision with player 2's paddle (right paddle)
        if (x + diameter >= player2.x && y + diameter >= player2.y && y <= player2.y + player2.height) {
            xVelocity = -xVelocity;  // Reverse the ball's direction on the x-axis when hitting player 2's paddle
            x = player2.x - diameter; // Adjust ball position to avoid overlap
        }

        // Bounce the ball of the left and right walls (**for testing)
        if (x <= 0 || x + diameter >= 800) { // 800 is window width
            xVelocity = -xVelocity; // Reserve the balls direction on the x-axis

        }
    }
    // Method to draw the ball
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);  // Set ball color to white
        g.fillOval(x, y, diameter, diameter);  // Draw the ball as a circle
    }
}


