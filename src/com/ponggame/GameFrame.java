package com.ponggame;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    GameFrame() {
        this.add(new GamePanel()); // Add the GamePanel (where Game is drawn) to the window
        this.setTitle("Pong Game"); // Set the window title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the app when clicking "X"
        this.setResizable(false); // Prevent resizing the window (so the game window size stays fixed)
        this.pack(); // Adjust the windows size to fit the components
        this.setVisible(true); // Make the window visible
        this.setLocationRelativeTo(null); // Center the window on the screen
    }

    public static void main(String[] args) {
        new GameFrame(); // Create and display the window when the program starts
    }
}