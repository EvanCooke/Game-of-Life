import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame(){
        this.add(new Panel()); // add new GamePanel to GameFrame
        this.setTitle("Conway's Game of Life");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); // size frame around all elements inside of it
        this.setVisible(true);
        this.setLocationRelativeTo(null); // set frame to center of computer screen
    }

}