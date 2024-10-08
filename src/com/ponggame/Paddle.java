package com.ponggame;


/* java. awt Contains classes for creating user interfaces and for painting graphics and images. */
import java.awt.*; // import for drawing the paddle

public class Paddle {
    int x, y, width = 20, height = 100; //Paddle dimensions and position
    int yVelocity = 0; // Speed of paddle movement

    // Constructor to initialize paddle's position
    Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Set the direction for vertical movement
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    // Update the paddle's position
    public void move() {
        y += yVelocity;
        // Prevent paddles from moving out of bounds
        if (y < 0) {
            y = 0;
        } else if (y > 500) { // 600 (height) - 100 (paddle height)
            y = 500;
        }
    }



    // Method to draw the paddle on the screen
    public void draw(Graphics g) {
        g.setColor(Color.WHITE); // set paddle color to white
        g.fillRect(x, y, width, height); // draw the paddle as a rectangle
    }
}
/*
The Paddle class holds the position (x, y) and size (width, height) of the paddle.
The draw method uses Graphics to draw the paddle on the screen.
*/


