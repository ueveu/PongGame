package com.ponggame;

import java.awt.*; // import for drawing the ball


public class Ball {
    int x,y, diameter = 20; // Ball and position size
    int xVelocity = 2; // Ball speed in x direction
    int yVelocity = 2; // Ball speed y direction

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
        if (y <= 0 || y >= 580) { // 580 is window height minus ball diameter (600 - 20)
            yVelocity = -yVelocity; // Reserve the balls direction on the y-axis
        }
        // Bounce the ball off the paddles
        if (x <= player1.x + player2.width && y >= player1.y && y >= player1.y + player1.height) {
            xVelocity = - xVelocity; // Reverse the ball's direction on the x-axis when hitting player 1's paddle
        }
        if ()
        // Bounce the ball of the left and right walls (******for testing, later we'll use the paddles)
        if (x <= 0 || x >= 780) { // 780 is windows width minus the ball diameter (800-20)
            xVelocity = -xVelocity; // Reserve the balls direction on the x-axis

        }
    }
    // Method to draw the ball
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);  // Set ball color to white
        g.fillOval(x, y, diameter, diameter);  // Draw the ball as a circle
    }
}
/*
- We initialize the ball`s position (x, y) and define its diameter (20pixels).
- The ball's speed in both the x and y directions is represented by xVelocity and yVelocity.
- The move() method will update the ball's position during the game loop (*using this later).
- The draw() method draws the ball as a circle on the screen.
*/


