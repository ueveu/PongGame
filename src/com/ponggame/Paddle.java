package com.ponggame;


/* java. awt Contains classes for creating user interfaces and for painting graphics and images. */
import java.awt.*; // import for drawing the paddle

public class Paddle {
    int x, y, width = 20, height = 100; //Paddle dimensions and position

    // Constructor to initialize paddle's position
    Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to draw the paddle
    public void draw(Graphics g) {
        g.setColor(Color.WHITE); // set paddle color to white
        g.fillRect(x, y, width, height); // draw the paddle as a rectangle
    }
}
/*
The Paddle class holds the position (x, y) and size (width, height) of the paddle.
The draw method uses Graphics to draw the paddle on the screen.
*/


