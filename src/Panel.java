import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;




public class Panel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int NUM_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;

    static int DELAY = 750;

    //Cell[] livingCells = new Cell[NUM_UNITS];
    static ArrayList<Cell> livingCells = new ArrayList<>();

    // Grid
    //int[][] grid = new int[Panel.SCREEN_WIDTH / Panel.UNIT_SIZE][Panel.SCREEN_HEIGHT / Panel.UNIT_SIZE];
    Grid grid = new Grid();
    int[] x = new int[NUM_UNITS];
    int[] y = new int[NUM_UNITS];

    Timer timer;
    Random random;
    boolean running = false;

    Panel(){
        grid.getGrid()[6][5].setLiving(true);
        grid.getGrid()[7][6].setLiving(true);
        grid.getGrid()[5][7].setLiving(true);
        grid.getGrid()[6][7].setLiving(true);
        grid.getGrid()[7][7].setLiving(true);

        livingCells.add(grid.getGrid()[8][7]);
        livingCells.add(grid.getGrid()[9][8]);
        livingCells.add(grid.getGrid()[7][9]);
        livingCells.add(grid.getGrid()[8][9]);
        livingCells.add(grid.getGrid()[9][9]);

        System.out.println(livingCells.size());
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        random = new Random();

        startGame();
    }

    public void startGame() {
        //checkRules();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
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

        for(Cell cell : livingCells){
            g.setColor(Color.white);
            g.fillRect(cell.getX() * UNIT_SIZE, cell.getY()* UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);

        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // colors background
        draw(g);
    }

    // 1. Any live cell with two or three live neighbours survives.
    // 2. Any dead cell with three live neighbours becomes a live cell.
    // 3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
    public void checkRules(){
        ArrayList<Cell> survivingCells = new ArrayList<>();
        livingCells.clear();

        for(int y = 1; y < grid.getGrid().length-1; y++){
            for(int x = 1; x < grid.getGrid()[0].length-1; x++){                    // REMOVE -2 AND =2 FROM THESE FOR LOOPS
                int numTouching = numTouching(grid.getGrid()[x][y]);
                // rule 1
                if(grid.getGrid()[x][y].getLiving()) {
                    if(numTouching == 2 || numTouching == 3){
                        survivingCells.add(grid.getGrid()[x][y]);
                        break;
                    }
                }else {
                    // rule 2
                    if (numTouching == 3) {
                        survivingCells.add(grid.getGrid()[x][y]);
                    }
                }
            }
        }

        // rule 3
        for(int y = 0; y < grid.getGrid().length; y++){
            for(int x = 0; x < grid.getGrid()[0].length; x++) {
                if(!survivingCells.contains(grid.getGrid()[x][y])){
                    grid.getGrid()[x][y].setLiving(false);
                }else{
                    grid.getGrid()[x][y].setLiving(true);
                    livingCells.add(grid.getGrid()[x][y]);
                }
            }
        }
    }

    public int numTouching(Cell cell){
        int numTouching = 0;
        int x = cell.getX();
        int y = cell.getY();

        if (grid.getGrid()[x + 1][y + 1].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x + 1][y].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x + 1][y - 1].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x][y + 1].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x][y - 1].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x - 1][y + 1].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x - 1][y].getLiving()) {
            numTouching++;
        }
        if (grid.getGrid()[x - 1][y - 1].getLiving()) {
            numTouching++;
        }
        return numTouching;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            //updateData();
            checkRules();
        }
        repaint();
    }
}
