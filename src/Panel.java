import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;




public class Panel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int NUM_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;

    static int DELAY = 75;

    Cell[] livingCells = new Cell[NUM_UNITS];

    int[] x = new int[NUM_UNITS];
    int[] y = new int[NUM_UNITS];

    Timer timer;
    Random random;
    boolean running = false;

    Panel(){
        livingCells[0] = new Cell(10,10, true);


        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        random = new Random();

        startGame();
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        //timer.start();
    }

    public void draw(Graphics g) {
        if (running) {

            // draw columns
            for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            }

            // draw rows
            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }
        }

        for(int i = 0; i < livingCells.length; i++){
            g.setColor(Color.white);
            //g.fillRect(livingCells[i].getX(), livingCells[i].getY(), UNIT_SIZE, UNIT_SIZE);
            g.fillRect(10,10, UNIT_SIZE, UNIT_SIZE);

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // colors background
        draw(g);
    }

    public void checkRules(){

    }

    public void updateData(){
        for(int i = 0; i < livingCells.length; i++){
            x[i] = livingCells[i].getX();
            y[i] = livingCells[i].getY();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            updateData();
            checkRules();
        }
        repaint();
    }
}
